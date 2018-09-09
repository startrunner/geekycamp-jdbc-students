package exposed.source.geekycamp5.jdbcstudents;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App {
    public final String connectionUrl;
    private final String dbUsername;
    private final String dbPassword;

    public App(String dbHost, String dbName, String dbUsername,String dbPassword) {
        this.connectionUrl = String.format(
            "jdbc:mysql://%s/%s",
            dbHost,
            dbName
        );
        this.dbUsername = dbUsername;
        this.dbPassword = dbPassword.trim();
        System.out.println(connectionUrl);
    }

    public Connection openConnection(){
        System.out.printf("DB pass: (%s)\n", dbPassword);
        Connection connection = null;
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(connectionUrl, dbUsername, dbPassword);
            System.out.println(connectionUrl);
        }
        catch (ClassNotFoundException ex) {System.err.println(ex.getMessage());}
        catch (SQLException ex){System.err.print(ex.getMessage());}

        return  connection;
    }
}
