package normalize;

import enums.Enviroment;
import enums.SqlType;
import filecreator.FileWrapper;

import java.util.List;
import java.util.Map;

public class EntityGenerator extends Normalize {

    private String primaryKey = "" +
            "@Id\n" +
            "@GeneratedValue(strategy = GenerationType.IDENTITY)\n" +
            "private Long {{fieldName}};\n";
    private String columnGeneric = "" +
            "@Column({{columnParams}})\n"
            +"private {{type}} {{fieldName}};\n";
    private String manyToOne = "" +
            "@ManyToOne\n" +
            "@JoinColumn({{columnsParams}})\n" +
            "private {{type}} {{fieldName}};";
    private String oneToMany = "" +
            "@OneToMany({{columnsParams}})\n" +
            "private List<{{type}}> {{fieldName}};";
    private String getter = " public {{type}} get{{fieldName}}(){" +
            "   return this.{{fieldName}};" +
            "}";
    private String setter = " public void set{{fieldName}}({{type}} {{fieldName}}){" +
            "   this.{{fieldName}} = {{fieldName}};" +
            "}";
    private String entity;
    private String entityClass;
    private String baseClass;
    private List<Map<String, Object>> databaseMetadata;
    private List<Map<String, String>> entitiesGenerated;

    public EntityGenerator(String entity, List<Map<String, Object>> databaseMetadata){
        this.entity = localeString(entity);
        FileWrapper file = new FileWrapper(Enviroment.ENTITY_TEMPLATE.toString());
        this.entityClass = file.readFile();
        this.entityClass = this.entityClass.replaceAll("\\{\\{entityPackage}}", Enviroment.ENTITY_PACKAGE.toString());
        this.databaseMetadata = databaseMetadata;
    }

    public void addColumnsToEntity(){
        //We need here 3 things:
        //  1º columnsParams: this is the params to add in columnsParams
        //  2º type: this is the param to add in type
        //  3º fieldName: name of field in camelcase
        String classToWrite = "";
        for(Map<String, Object> column : this.databaseMetadata){
            String template = this.selectedTemplate(column);
            String fullEntity = this.getType(column, this
                    .getColumnParams(column,
                            this.getColumnName(column,
                                    template)))+"\n";
            //Here we create getters And Setters;
            String getters = this.getType(column, this.getColumnNameUpperEveryStartChar(column, this.getter))+"\n";
            String setters = this.getType(column, this.getColumnNameUpperEveryStartChar(column, this.setter))+"\n";
            classToWrite +=fullEntity+getters+setters;
        }
        FileWrapper reader = new FileWrapper(Enviroment.ENTITY_TEMPLATE.toString());
        FileWrapper writer = new FileWrapper(Enviroment.ENTITY_ROUTE.toString()+"/"+this.entity+".java");
        writer.generateFile(reader
                .readFile()
                .replace("{{entityPackage}}", Enviroment.ENTITY_PACKAGE.toString())
                .replace("{{entity}}", this.entity)
                .replace("{{data}}", classToWrite)
        );
    }

    private String selectedTemplate(Map<String, Object> metadata){
        //In this step we need to validate 3 things:
        //  1º If we have a primary key or not
        //  2º If we have a one to many entity or not
        //  3º If we have a normal field
        if(metadata.get("COLUMN_KEY").toString().equals("PRI")){
            return this.primaryKey;
        }
        if(metadata.get("REFERENCED_COLUMN_NAME")==null){
            return this.columnGeneric;
        }
        return "";
    }

    private String getColumnParams(Map<String, Object> columnMetadata, String template){
        return this.getGenericColumnString(template, columnMetadata);
    }

    private String getColumnNameUpperEveryStartChar(Map<String, Object> metadata, String template){
        return template.replace("{{fieldName}}", localeString(metadata.get("COLUMN_NAME").toString()));
    }

    private String getColumnName(Map<String, Object> metadata, String template){
        return template.replace("{{fieldName}}", cammelCase(metadata.get("COLUMN_NAME").toString()));
    }

    private String getType(Map<String, Object> metadata, String template){
        return template.replace("{{type}}", SqlType.fromSqlType(metadata.get("COLUMN_TYPE").toString()));
    }

    private String getGenericColumnString(String template, Map<String, Object> metadata){
        String columData =
                "name : '" + metadata.get("COLUMN_NAME").toString() + "',"
                + "type : '" + metadata.get("DATA_TYPE").toString() + "',"
                + ((metadata.get("CHARACTER_MAXIMUM_LENGTH") != null ? "length : '"+metadata.get("CHARACTER_MAXIMUM_LENGTH").toString()+"'" : ""))+","
                + ((metadata.get("IS_NULLABLE").toString() == "YES" ? "nullable :'true'" : "nullable :'false'"))
                ;
        String returnable = template.replace("{{columnParams}}", columData);
        return returnable;
    }

}
