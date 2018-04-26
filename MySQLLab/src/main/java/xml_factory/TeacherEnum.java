package xml_factory;

public enum TeacherEnum {
    TEACHERS("teachers"),
    NAME("name"),
    STATUS("status"),
    TEACHER("teacher");

    private String value;

    TeacherEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
