package DAL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Access {
    private static final String databaseName = "anticafeM3205Gudauskayte";
    private static final String connectionString = "jdbc:sqlserver://localhost;databaseName=" + databaseName + ";integratedSecurity=true";
    private static Connection connection;

    public Access() {
        connection=connect();
    }

    public static Connection connect() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection connection = DriverManager.getConnection(connectionString);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }

    public static Connection getConnection() {
        return connection;
    }

    public static void main (String[] args){
        Access access = new Access();
    }
}
