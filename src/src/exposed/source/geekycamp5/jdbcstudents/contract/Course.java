package exposed.source.geekycamp5.jdbcstudents.contract;

public interface Course {
    int id();

    String name();
    String description();
    Faculty faculty();
    int creditReward();

    Course setCreditReward(int reward);
    Course setName(String name);
    Course setDescription(String description);
}
