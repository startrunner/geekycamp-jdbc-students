package exposed.source.geekycamp5.jdbcstudents.contract;

public interface Faculty {
    int id();

    String name();
    String setName();

    Course createCourse();
    Student enrollStudent();
}
