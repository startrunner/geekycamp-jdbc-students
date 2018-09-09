package exposed.source.geekycamp5.jdbcstudents.contract;

public interface Student {
    int facultyNumber();
    Faculty faculty();

    Iterable<Course> courses();
    String firstName();
    String fullName();
    int credits();

    Student setFirstName();
    Student setFullName();
    Student setCredits();
    Student enrollInCourse(Course course);
}
