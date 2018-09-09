package exposed.source.geekycamp5.jdbcstudents.models;

import exposed.source.geekycamp5.jdbcstudents.App;
import exposed.source.geekycamp5.jdbcstudents.contract.Course;
import exposed.source.geekycamp5.jdbcstudents.contract.Faculty;
import exposed.source.geekycamp5.jdbcstudents.contract.Student;
import exposed.source.geekycamp5.jdbcstudents.contract.UniversityDatabase;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class SqlUniversityDb implements UniversityDatabase {
    private  final App app;

    public SqlUniversityDb(App app) {
        this.app = app;
    }

    @Override
    public Iterable<Course> courses () throws  Exception {
        return  null;
    }

    @Override
    public Iterable<Student> students() throws Exception {
        Connection connection = app.openConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM `FACULTIES`");
        ResultSet set = statement.executeQuery();
        List<Student> faculties = new ArrayList<>();
        while (set.next()){
            faculties.add(new SqlStudent(
                app,
                set.getInt("FACULTY_NUMBER"),
                set.getInt("FACULTY_ID")
            ));
        }
        connection.close();
        return  faculties;
    }

    @Override
    public Iterable<Faculty> faculties() throws  Exception {
        Connection connection = app.openConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM `FACULTIES`");
        ResultSet set = statement.executeQuery();
        List<Faculty> faculties = new ArrayList<>();
        while (set.next()){
            faculties.add(new SqlFaculty(app, set.getInt("ID")));
        }
        connection.close();
        return  faculties;
    }

    @Override
    public Faculty createFaculty(String name) throws  Exception{
        Connection connection = app.openConnection();

        PreparedStatement createStatement =
            connection.prepareStatement("INSERT INTO FACULTIES(`NAME`) VALUES ( ? );");
        createStatement.setString(1, name);
        createStatement.execute();

        PreparedStatement getStatement =
            connection.prepareStatement("SELECT * FROM FACULTIES WHERE NAME = '?' LIMIT 1;");
        getStatement.setString(1, name);
        ResultSet set = getStatement.executeQuery();
        //set.next() ;
        int id = set.getInt("ID");

        connection.close();
        return new SqlFaculty(app, id);
    }
}
