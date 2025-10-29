package jdbcwrapper;

import java.util.List;
import java.util.Map;

public class BBDDMetadata extends Driver{

    public List<Map<String, Object>> getTables(){
        return this.launchQuery("SHOW TABLES");
    }

    public List<Map<String, Object>> getMetadata(String table){
        return this.launchQuery("SELECT c.*, k.REFERENCED_TABLE_NAME, k.REFERENCED_COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS c LEFT JOIN INFORMATION_SCHEMA.KEY_COLUMN_USAGE k on c.COLUMN_NAME = k.COLUMN_NAME  AND c.TABLE_NAME = k.TABLE_NAME AND c.COLUMN_NAME = k.COLUMN_NAME WHERE c.TABLE_NAME = '"+table+"';");
    }

}
