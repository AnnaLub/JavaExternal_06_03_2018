package mySql_model;

public class Teacher {
    private String name;
    private String status;

    public Teacher(String name, String status) {
        setName(name);
        setStatus(status);
    }

    public Teacher() {
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
