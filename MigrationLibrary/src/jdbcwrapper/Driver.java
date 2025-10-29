package jdbcwrapper;

import enums.Enviroment;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.sql.DriverManager;

public class Driver {

    private Connection db;

    public Driver(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.db = DriverManager.getConnection(
                    Enviroment.CONNECTION.toString(),
                    Enviroment.USER.toString(),
                    Enviroment.PASSWORD.toString());
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<Map<String, Object>> launchQuery(String sql){
        List<Map<String, Object>> list = new ArrayList<>();
        try {
            Statement stmt = this.db.createStatement();
            ResultSet data = stmt.executeQuery(sql);
            ResultSetMetaData meta = data.getMetaData();
            int columns = meta.getColumnCount();
            while(data.next()) {
                Map<String, Object> row = new HashMap<>();
                for(int i = 1; i<=columns; i++) {
                    row.put(meta.getColumnName(i), data.getObject(i));
                }
                list.add(row);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("Consulta fallida");
            e.printStackTrace();
        }
        return list;
    }

}
