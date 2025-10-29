import enums.Enviroment;
import filecreator.FileWrapper;
import jdbcwrapper.BBDDMetadata;
import normalize.EntityGenerator;
import normalize.Normalize;
import normalize.RepositoryGenerator;

import javax.management.ObjectName;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        BBDDMetadata metadata = new BBDDMetadata();
        List<Map<String, Object>> tables = metadata.getTables();
        FileWrapper fileRepository = new FileWrapper(Enviroment.REPOSITORY_TEMPLATE.toString());
        String baseRepository = fileRepository.readFile();
        List<Map<String, Object>> metadataExtracted = new ArrayList<Map<String, Object>>();
        //1º We need to validate every table and get every field data and make repositories
        for(Map<String, Object> table : tables){
            // 1º We will extract repository
            String tableName = (String) table.get("Tables_in_"+Enviroment.DATABASE_NAME.toString());
            RepositoryGenerator repositoryGenerator = new RepositoryGenerator(tableName);
            repositoryGenerator.generateRepository(baseRepository);
            // We extract every entity metadata
            List<Map<String, Object>> data = metadata.getMetadata(tableName);
            //We will get every entity in a List
            for(Map<String, Object> column : data){
                metadataExtracted.add(column);
            }
        }
        //2º Once we have every metadata of every field in database we need to generate entity
        for(Map<String, Object> table : tables){
            String tableName = (String) table.get("Tables_in_"+Enviroment.DATABASE_NAME.toString());
            List<Map<String, Object>> tableMetadata = metadataExtracted
                    .stream()
                    .filter((item) -> item
                            .get("TABLE_NAME")
                            .toString()
                            .equals(tableName))
                    .collect(Collectors.toList());
            new EntityGenerator(tableName, tableMetadata).addColumnsToEntity();
        }
    }
}