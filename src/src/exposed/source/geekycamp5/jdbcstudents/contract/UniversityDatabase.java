package exposed.source.geekycamp5.jdbcstudents.contract;

public interface UniversityDatabase {
    Iterable<Course> courses() throws Exception;
    Iterable<Student> students() throws Exception;
    Iterable<Faculty> faculties() throws Exception;

    Faculty createFaculty(String name) throws Exception;
}
