package exposed.source.geekycamp5.jdbcstudents.models;

import exposed.source.geekycamp5.jdbcstudents.App;
import exposed.source.geekycamp5.jdbcstudents.contract.Course;
import exposed.source.geekycamp5.jdbcstudents.contract.Faculty;

public class SqlCourse implements Course {
    private final App app;
    private final int mId;

    public SqlCourse (App app, int id){
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
    public String description() {
        return null;
    }

    @Override
    public Faculty faculty() {
        return null;
    }

    @Override
    public int creditReward() {
        return 0;
    }

    @Override
    public Course setCreditReward(int reward) {
        return null;
    }

    @Override
    public Course setName(String name) {
        return null;
    }

    @Override
    public Course setDescription(String description) {
        return null;
    }
}
