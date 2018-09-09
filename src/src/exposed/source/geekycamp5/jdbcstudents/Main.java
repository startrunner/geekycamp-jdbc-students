package exposed.source.geekycamp5.jdbcstudents;

import exposed.source.geekycamp5.jdbcstudents.contract.Faculty;
import exposed.source.geekycamp5.jdbcstudents.contract.UniversityDatabase;
import exposed.source.geekycamp5.jdbcstudents.models.SqlUniversityDb;

import java.io.IOException;
import java.io.InputStream;
import java.io.LineNumberInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.UUID;

public class Main {
    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

    public static  void main(String[] args)throws  Exception{
        App app = buildApp();

        UniversityDatabase db = new SqlUniversityDb(app);

        db.createFaculty(UUID.randomUUID().toString().substring(0, 10));

        Iterable<Faculty> faculties = db.faculties();
        faculties.forEach((x)->{
            System.out.println(x.id());
        });
        ;
    }

    private  static App buildApp() throws IOException {
        Properties prop = new Properties();
        InputStream in = Main.class.getResourceAsStream("config.properties");
        prop.load(in);

        String dbHost = prop.getProperty("DB_ADDRESS");
        String dbName = prop.getProperty("DB_NAME");
        String dbUsername = prop.getProperty("DB_USERNAME");
        String dbPassword = prop.getProperty("DB_PASSWORD");
        in.close();
        return  new App(dbHost, dbName, dbUsername, dbPassword);
    }
}
