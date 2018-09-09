package exposed.source.geekycamp5.jdbcstudents.models;

import exposed.source.geekycamp5.jdbcstudents.App;
import exposed.source.geekycamp5.jdbcstudents.contract.Course;
import exposed.source.geekycamp5.jdbcstudents.contract.Faculty;
import exposed.source.geekycamp5.jdbcstudents.contract.Student;

public class SqlStudent  implements Student {
    private final App app;
    private final int mFacultyNumber;
    private final int facultyId;

    public  SqlStudent(App app, int facultyNumber, int facultyId){
        this.app = app;
        this.mFacultyNumber = facultyNumber;
        this.facultyId = facultyId;
    }

    @Override
    public int facultyNumber() {
        return mFacultyNumber;
    }

    @Override
    public Faculty faculty() {
        return null;
    }

    @Override
    public Iterable<Course> courses() {
        return null;
    }

    @Override
    public String firstName() {
        return null;
    }

    @Override
    public String fullName() {
        return null;
    }

    @Override
    public int credits() {
        return 0;
    }

    @Override
    public Student setFirstName() {
        return null;
    }

    @Override
    public Student setFullName() {
        return null;
    }

    @Override
    public Student setCredits() {
        return null;
    }

    @Override
    public Student enrollInCourse(Course course) {
        return null;
    }
}
