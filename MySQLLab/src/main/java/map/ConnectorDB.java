/*package map;

import java.sql.*;
import java.util.ResourceBundle;

public class ConnectorDB {

    public static Connection getConnection() throws SQLException{
        ResourceBundle resourse = ResourceBundle.getBundle("database");
        String url = resourse.getString("db.url");
        String name = resourse.getString("db.user");
        String password = resourse.getString("db.password");
        return DriverManager.getConnection(url,name,password);
    }

    public static void main(String[] args) throws SQLException {
        Connection cn = ConnectorDB.getConnection();
    }
}*/
