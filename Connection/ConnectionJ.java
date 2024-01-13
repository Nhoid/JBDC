package JBDC.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionJ
{
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306";
        String username = "root";
        String password = "senha";
        return DriverManager.getConnection(url, username, password);
    }
}
