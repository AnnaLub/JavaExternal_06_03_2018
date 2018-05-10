package mySql_model;

public class Discipline {
    private int id;
    private String disname;
    private int hours;
    private short isExam;
    private String teachername;

    public Discipline(int id, String disname, int hours, short isExam, String teachername) {
        this.id = id;
        this.disname = disname;
        this.hours = hours;
        this.isExam = isExam;
        this.teachername = teachername;
    }

    public int getId() {
        return id;
    }

    public String getDisname() {
        return disname;
    }

    public int getHours() {
        return hours;
    }

    public short getIsExam() {
        return isExam;
    }

    public String getTeachername() {
        return teachername;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDisname(String disname) {
        this.disname = disname;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public void setIsExam(short isExam) {
        this.isExam = isExam;
    }

    public void setTeachername(String teachername) {
        this.teachername = teachername;
    }
}
