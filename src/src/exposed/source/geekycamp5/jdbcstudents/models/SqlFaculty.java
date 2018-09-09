package exposed.source.geekycamp5.jdbcstudents.models;

import exposed.source.geekycamp5.jdbcstudents.App;
import exposed.source.geekycamp5.jdbcstudents.contract.Course;
import exposed.source.geekycamp5.jdbcstudents.contract.Faculty;
import exposed.source.geekycamp5.jdbcstudents.contract.Student;

public class SqlFaculty implements Faculty {
    private final int mId;
    private final App app;

    public SqlFaculty(App app, int id){
        this.app = app;
        this.mId = id;
    }

    @Override
    public int id() {
        return mId;
    }

    @Override
    public String name() {
        return null;
    }

    @Override
    public String setName() {
        return null;
    }

    @Override
    public Course createCourse() {
        return null;
    }

    @Override
    public Student enrollStudent() {
        return null;
    }
}
