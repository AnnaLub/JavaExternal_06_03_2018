package xml_factory;

import mySql_model.Teacher;

import java.util.HashSet;
import java.util.Set;

public abstract class AbstractTeachersBuilder {
    protected Set<Teacher> teachers;

    public AbstractTeachersBuilder() {
        teachers = new HashSet<Teacher>();
    }

    public AbstractTeachersBuilder(Set<Teacher> teachers) {
        this.teachers = teachers;
    }

    public Set<Teacher> getTeachers() {
        return teachers;
    }
    abstract public void buildSetTeachers(String filename);
}
