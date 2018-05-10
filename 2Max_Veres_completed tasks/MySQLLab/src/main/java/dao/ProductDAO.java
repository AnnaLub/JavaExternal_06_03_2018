package dao;

import org.apache.log4j.Logger;

import mySql_connector.ConnectorDB;
import mySql_model.Discipline;
import mySql_model.Teacher;
import xml_factory.AbstractTeachersBuilder;
import xml_factory.TeachersBuilderFactory;
import xml_factory.TeachersDOMBuilder;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ProductDAO {
    private Connection connection = null;
    private Statement stmn = null;
    private PreparedStatement pstmt = null;

    private final static Logger logger = Logger.getLogger(ProductDAO.class);

    /*PropertyConfigurator.configure("log4j.properties");*/

    /**
     * method finds all teacher from DB
     * @return {@code ArrayList} of {@code Teacher}
     * @exception Exception all exceptions are thrown higher and catches in the client's code
     *
     **/
    public List<Teacher> getTeachers() throws Exception {
        List<Teacher> teachersList = new ArrayList<>();
        connection = ConnectorDB.getConnection();
        String sql = "SELECT T_NAME, STATUS FROM TEACHER";
        stmn = connection.createStatement();
        logger.info("Statement has been created");
        ResultSet rs = stmn.executeQuery(sql);
        logger.info("Statement Query has been executed");
        while (rs.next()){
            String name = rs.getString("T_NAME");
            String status = rs.getString("STATUS");
            Teacher teacher = new Teacher(name, status);
            teachersList.add(teacher);
        }
        logger.info("All Teachers have been added to TeachersList");
        stmn.close();
        logger.info("Statement has been closed");
        ConnectorDB.closeConnection(connection);
        return teachersList;
    }

    /**
     * method prints all teachers from {@code List<Teacher>}
     **/
    public static void printAllTeacher(List<Teacher> teachersList){
        for (Teacher teacher : teachersList) {
            System.out.print(teacher.getName()+" ");
            System.out.println(teacher.getStatus());
        }
    }

    /**
     * method gets all teachers names from DB
     * @exception Exception all exceptions are thrown higher and catches in the client's code
     **/
    public List<String> getTeachersName() throws Exception {
        List<String> teacherByName = new ArrayList<>();
        connection = ConnectorDB.getConnection();
        String sql = "SELECT T_NAME FROM TEACHER";
        pstmt = connection.prepareStatement(sql);
        logger.info("Prepared Statement has been created");
        ResultSet rs = pstmt.executeQuery();
        logger.info("Prepared Statement Query has been executed");
        while(rs.next()){
            teacherByName.add(rs.getString(1));
        }
        rs.close();
        logger.info("ResultSet has been closed");
        ConnectorDB.closeConnection(connection);
        return teacherByName;
    }

    /**
     * method prints teacher's features from {@code List<String>}
     **/
    public static void printFeatures(List<String> features){
        for (String tname : features) {
            System.out.println(tname);
        }
    }

    /**
     * method gets teacher's status by name from DB
     * @exception Exception all exceptions are thrown higher and catches in the client's code
     **/
    public List<String> getTeachersStatusByName(String name) throws Exception {
        List<String> teacherStatusByName = new ArrayList<>();
        connection = ConnectorDB.getConnection();
        String sql = "SELECT STATUS FROM TEACHER WHERE T_NAME = ?";
        pstmt = connection.prepareStatement(sql);
        pstmt.setString(1,name);
        logger.info("Prepared Statement has been created");
        ResultSet rs = pstmt.executeQuery();
        logger.info("Prepared Statement Query has been executed");
        while(rs.next()){
            String status = rs.getString("STATUS");
            teacherStatusByName.add(status);
        }
        logger.info("All STATUS have been added to the StatusList");
        rs.close();
        logger.info("ResultSet has been closed");
        ConnectorDB.closeConnection(connection);
        return teacherStatusByName;
    }

    /**
     * method set new {@code Teacher} to the DB
     * @exception Exception all exceptions are thrown higher and catches in the client's code
     **/
    public void addTeacher(Teacher teacher) throws Exception{
        connection = ConnectorDB.getConnection();
        String sql = "INSERT INTO TEACHER(T_NAME,STATUS) VALUES (?,?)";
        pstmt = connection.prepareStatement(sql);
        pstmt.setString(1,teacher.getName());
        pstmt.setString(2,teacher.getStatus());
        logger.info("Prepared Statement has been created");
        pstmt.executeUpdate();
        logger.info("Prepared Statement has been executed Updates");
        ConnectorDB.closeConnection(connection);
    }

    //add elements2DBfromXML
    public void addTeacherDOM() throws Exception {
        TeachersBuilderFactory tFactory = new TeachersBuilderFactory();
        AbstractTeachersBuilder builder = tFactory.createTeacherBuilder("sax");
        builder.buildSetTeachers("data/teachers.xml");
        Set<Teacher> teachers = builder.getTeachers();
        Teacher[] teach = teachers.toArray(new Teacher[teachers.size()]);
        connection = ConnectorDB.getConnection();
        for (Teacher teacher : teach) {
        String sql = "INSERT INTO TEACHER(T_NAME,STATUS) VALUES (?,?)";
        pstmt = connection.prepareStatement(sql);
        pstmt.setString(1,teacher.getName());
        pstmt.setString(2,teacher.getStatus());
        logger.info("Prepared Statement has been created");
        pstmt.executeUpdate();
        logger.info("Prepared Statement has been executed Updates");
        }
        ConnectorDB.closeConnection(connection);
    }

    /**
     * method set new parameters to the teacher's DB fields
     * @exception Exception all exceptions are thrown higher and catches in the client's code
     **/
    public void setTeacherStatus(Teacher teacher) throws Exception{
        connection = ConnectorDB.getConnection();
        String sql = "UPDATE TEACHER SET STATUS = ? WHERE T_NAME = ?";
        pstmt = connection.prepareStatement(sql);
        pstmt.setString(1,teacher.getStatus());
        pstmt.setString(2,teacher.getName());
        logger.info("Prepared Statement has been created");
        pstmt.executeUpdate();
        logger.info("Prepared Statement has been executed Updates");
        ConnectorDB.closeConnection(connection);
    }

    /**
     * method delete teacher from DB
     * @exception Exception all exceptions are thrown higher and catches in the client's code
     **/
    public void removeTeacher(Teacher teacher) throws Exception{
        connection = ConnectorDB.getConnection();
        String sql = "DELETE FROM TEACHER WHERE T_NAME = ?";
        pstmt = connection.prepareStatement(sql);
        pstmt.setString(1,teacher.getName());
        logger.info("Prepared Statement has been created");
        pstmt.executeUpdate();
        logger.info("Prepared Statement has been executed Updates");
        ConnectorDB.closeConnection(connection);
    }

    /**
     * method finds discipline by {@code Teacher} from DB
     * @return {@code ArrayList} of {@code Discipline}
     * @exception Exception all exceptions are thrown higher and catches in the client's code
     **/
    public List<Discipline> getDiscilineByTeacher(Teacher teacher) throws Exception {
        List<Discipline> disciplineList = new ArrayList<>();
        connection = ConnectorDB.getConnection();
        String sql = "SELECT ID_DN, D_NAME, HOURS, ISEXAM FROM DISCIPLINE WHERE T_NAME = ?";
        pstmt = connection.prepareStatement(sql);
        pstmt.setString(1,teacher.getName());
        logger.info("Prepared Statement has been created");
        ResultSet rs = pstmt.executeQuery();
        logger.info("Prepared Statement Query has been executed");
        while (rs.next()) {
           int id = rs.getInt("ID_DN");
           String dname = rs.getString("D_NAME");
           int hours = rs.getInt("HOURS");
           short isexam = rs.getShort("ISEXAM");
           Discipline discipline = new Discipline(id, dname, hours, isexam, teacher.getName());
           disciplineList.add(discipline);
        }
        logger.info("All Disciplines have been added to DisciplineList");
        rs.close();
        logger.info("ResultSet has been closed");
        ConnectorDB.closeConnection(connection);
        return disciplineList;
    }

    /**
     * method finds discipline by id from DB
     * @return {@code ArrayList} of {@code Discipline}
     * @exception Exception all exceptions are thrown higher and catches in the client's code
     **/
    public List<Discipline> getDisciplineById(int id) throws Exception {
        List<Discipline> disciplineList = new ArrayList<>();
        connection = ConnectorDB.getConnection();
        String sql = "SELECT D_NAME, HOURS, ISEXAM, T_NAME FROM DISCIPLINE WHERE ID_DN = ?";
        pstmt = connection.prepareStatement(sql);
        pstmt.setInt(1,id);
        logger.info("Prepared Statement has been created");
        ResultSet rs = pstmt.executeQuery();
        logger.info("Prepared Statement Query has been executed");
        while (rs.next()){
            String dname = rs.getString("D_NAME");
            int hours = rs.getInt("HOURS");
            short isexam = rs.getShort("ISEXAM");
            String tname = rs.getString("T_NAME");
            Discipline discipline = new Discipline(id, dname, hours, isexam, tname);
            disciplineList.add(discipline);
        }
        logger.info("All Disciplines have been added to DisciplineList");
        rs.close();
        logger.info("ResultSet has been closed");
        ConnectorDB.closeConnection(connection);
        return disciplineList;
    }

    /**
     * method finds all discipline from DB
     * @return {@code ArrayList} of {@code Discipline}
     * @exception Exception all exceptions are thrown higher and catches in the client's code
     **/
    public List<Discipline> getDisciplines() throws Exception {
        List<Discipline> disciplinesList = new ArrayList<>();
        connection = ConnectorDB.getConnection();
        String sql = "SELECT ID_DN, D_NAME, HOURS, ISEXAM, T_NAME FROM DISCIPLINE";
        stmn = connection.createStatement();
        logger.info("Prepared Statement has been created");
        ResultSet rs = stmn.executeQuery(sql);
        logger.info("Statement Query has been executed");
        while (rs.next()){
            int id = rs.getInt("ID_DN");
            String dname = rs.getString("D_NAME");
            int hours = rs.getInt("HOURS");
            short isexam = rs.getShort("ISEXAM");
            String tname = rs.getString("T_NAME");
            Discipline discipline = new Discipline(id, dname, hours, isexam, tname);
            disciplinesList.add(discipline);
        }
        logger.info("All Disciplines have been added to DisciplineList");
        stmn.close();
        logger.info("ResultSet has been closed");
        ConnectorDB.closeConnection(connection);
        return disciplinesList;
    }

    /**
     * method set new {@code Discipline} to the DB
     * @exception Exception all exceptions are thrown higher and catches in the client's code
     **/
    public void addDiscipline(Discipline discipline) throws Exception {
        connection = ConnectorDB.getConnection();
        String sql = "INSERT INTO DISCIPLINE(ID_DN, D_NAME, HOURS, ISEXAM, T_NAME) VALUES (?,?,?,?,?)";
        pstmt = connection.prepareStatement(sql);
        pstmt.setInt(1, discipline.getId());
        pstmt.setString(2,discipline.getDisname());
        pstmt.setInt(3, discipline.getHours());
        pstmt.setShort(4,discipline.getIsExam());
        pstmt.setString(5,discipline.getTeachername());
        logger.info("Prepared Statement has been created");
        pstmt.executeUpdate();
        logger.info("Prepared Statement has been executed Updates");
        ConnectorDB.closeConnection(connection);
    }

    public void removeDiscipline(int id) throws Exception{
        connection = ConnectorDB.getConnection();
        String sql = "DELETE FROM DISCIPLINE WHERE ID_DN = ?";
        pstmt = connection.prepareStatement(sql);
        pstmt.setInt(1,id);
        logger.info("Prepared Statement has been created");
        pstmt.executeUpdate();
        logger.info("Prepared Statement has been executed Updates");
        ConnectorDB.closeConnection(connection);
    }

    /**
     * method prints all disciplines from {@code List<Teacher>}
     **/
    public static void printAllDiscipline(List<Discipline> disciplineList){
        for (Discipline discipline : disciplineList) {
            System.out.print(discipline.getId()+" ");
            System.out.print(discipline.getDisname()+" ");
            System.out.print(discipline.getHours()+" ");
            System.out.print(discipline.getIsExam()+" ");
            System.out.println(discipline.getTeachername());
        }
    }
}
