package map;

import java.sql.*;

public class Map {
    private Connection connection = null;
    private Statement stmn = null;
    private PreparedStatement pstmt = null;

    public Map() throws Exception{
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        String url = "jdbc:mysql://localhost:3306/map?useSSL=false";
        connection = DriverManager.getConnection(url, "root","root");
        if(!connection.isClosed()){
            System.out.println("Connection with DB is ESTABLISHED");
        }
    }

    public void stop() throws SQLException{
        connection.close();
        if(connection.isClosed()){
            System.out.println("Connection with DB is CLOSED");
        }
    }

    public boolean addTeacher(String name, String status) {
        String sql = "INSERT INTO TEACHER(T_NAME,STATUS) VALUES (?,?)";
        try
        {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1,name);
            pstmt.setString(2,status);
            pstmt.executeUpdate();
            System.out.println("TEACHER "+name+" successfully added");
            return true;
        }catch (SQLException e){
            System.out.println("Error! Can not add TEACHER: "+name);
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean addDiscipline(int id, String name, int hours, short isexam, String teachername) {
        String sql = "INSERT INTO DISCIPLINE(ID_DN, D_NAME, HOURS, ISEXAM, T_NAME) VALUES (?,?,?,?,?)";
        try
        {
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, id);
            pstmt.setString(2, name);
            pstmt.setInt(3, hours);
            pstmt.setShort(4, isexam);
            pstmt.setString(5, teachername);
            pstmt.executeUpdate();
            System.out.println("DISCIPLINE "+name+" successfully added");
            return true;
        }catch (SQLException e){
            System.out.println("Error! Can not add DISCIPLINE: "+name);
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean deleteTeacher(String name) {
        String sql = "DELETE FROM TEACHER WHERE T_NAME = ?";
        try
        {
        pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, name);
        int c = pstmt.executeUpdate();
        if(c>0){
            System.out.println("TEACHER "+name+" successfully DELETED");
            return true;
        }
        else {
            System.out.println("Can not find TEACHER "+name);
            return false;
        }
    }
    catch (SQLException e) {
        System.out.println("ERROR! Something went wrong with TEACHER DELETE" + e.getMessage());
        return false;
        }
    }

    public boolean deleteDiscipline(int id) {
        String sql = "DELETE FROM DISCIPLINE WHERE ID_DN = ?";
        try
        {
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, id);
            int c = pstmt.executeUpdate();
            if(c>0){
                System.out.println("DISCIPLINE "+id+" successfully DELETED");
                return true;
            }
            else {
                System.out.println("Can not find DISCIPLINE "+id);
                return false;
            }
        }
        catch (SQLException e) {
            System.out.println("ERROR! Something went wrong with DISCIPLINE DELETE" + e.getMessage());
            return false;
        }
    }

    public void showAllTeacher() {
        String sql = "SELECT T_NAME, STATUS FROM TEACHER";
        try {
            stmn = connection.createStatement();
            ResultSet rs = stmn.executeQuery(sql);
            System.out.println("TEACHER LIST: ");
            while (rs.next()) {
                String name = rs.getString("T_NAME");
                String status = rs.getString("STATUS");
                System.out.println(name +" "+ status);
            }
            stmn.close();
        } catch (SQLException e) {
            System.out.println("ERROR! Something went wrong with TEACHER LIST" + e.getMessage());
        }
    }

    public boolean changeTeacherName(String oldName, String newName) {
        String sql = "UPDATE TEACHER SET T_NAME = ? WHERE T_NAME = ?";
        try
        {
             pstmt = connection.prepareStatement(sql);
             pstmt.setString(1,newName);
             pstmt.setString(2,oldName);
             pstmt.executeUpdate();
             System.out.println("TEACHER "+oldName+" successfully changed to "+newName);
             return true;
        }
        catch (SQLException e) {
            System.out.println("Error! Can not change TEACHER NAME: "+oldName);
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean changeTeacherStatus(String name, String status) {
        String sql = "UPDATE TEACHER SET STATUS = ? WHERE T_NAME = ?";
        try
        {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1,status);
            pstmt.setString(2,name);
            pstmt.executeUpdate();
            System.out.println("TEACHER "+name+" successfully changed STATUS to "+status);
            return true;
        }
        catch (SQLException e) {
            System.out.println("Error! Can not change TEACHER STATUS: "+name);
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean changeDisciplineIdDn(int oldid, int newid) {
        String sql = "UPDATE DISCIPLINE SET ID_DN = ? WHERE ID_DN = ?";
        try
        {
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1,newid);
            pstmt.setInt(2,oldid);
            pstmt.executeUpdate();
            System.out.println("DISCIPLINE "+oldid+" successfully change ID_DN to "+newid);
            return true;
        }
        catch (SQLException e) {
            System.out.println("Error! Can not change ID_DN: "+newid);
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean changeDisciplineName(int id, String name) {
        String sql = "UPDATE DISCIPLINE SET D_NAME = ? WHERE ID_DN = ?";
        try
        {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1,name);
            pstmt.setInt(2,id);
            pstmt.executeUpdate();
            System.out.println("DISCIPLINE "+id+" successfully change D_NAME to "+name);
            return true;
        }
        catch (SQLException e) {
            System.out.println("Error! Can not change D_NAME to "+name);
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean changeDisciplineTeacher(int id, String name){
        String sql = "UPDATE DISCIPLINE SET T_NAME = ? WHERE ID_DN = ?";
        try
        {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1,name);
            pstmt.setInt(2,id);
            pstmt.executeUpdate();
            System.out.println("DISCIPLINE "+id+" successfully change TEACHER NAME to "+name);
            return true;
        }
        catch (SQLException e) {
            System.out.println("Error! Can not change TEACHER NAME: "+name);
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean changeDisciplineHours(int id, int hours) {
        String sql = "UPDATE DISCIPLINE SET HOURS = ? WHERE ID_DN = ?";
        try
        {
        pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1,hours);
            pstmt.setInt(2,id);
            pstmt.executeUpdate();
            System.out.println("DISCIPLINE "+id+" successfully change HOURS to "+hours);
            return true;
        }
        catch (SQLException e) {
            System.out.println("Error! Can not change HOURS: "+id);
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean changeIsExam(int id, short isexam) {
        String sql = "UPDATE DISCIPLINE SET ISEXAM = ? WHERE ID_DN = ?";
        try
        {
            pstmt = connection.prepareStatement(sql);
            pstmt.setShort(1,isexam);
            pstmt.setInt(2,id);
            pstmt.executeUpdate();
            System.out.println("DISCIPLINE "+id+" successfully change ISEXAM to "+isexam);
            return true;
        }
        catch (SQLException e) {
            System.out.println("Error! Can not change ISEXAM: "+id);
            System.out.println(e.getMessage());
            return false;
        }
    }

    public void searchTeacherByName(String name) {
        String sql = "SELECT T_NAME, STATUS FROM TEACHER WHERE T_NAME = ?";
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1,name);
            ResultSet rs = pstmt.executeQuery();
            System.out.println("TEACHER: ");
            while (rs.next()) {
                String tname = rs.getString("T_NAME");
                String status = rs.getString("STATUS");
                System.out.println(name +" "+ status);
            }
            pstmt.close();
        } catch (SQLException e) {
            System.out.println("ERROR! Something went wrong with TEACHER LIST" + e.getMessage());
        }
    }

    public void searchDisciplineById(int id) {
        String sql = "SELECT D_NAME, HOURS, ISEXAM, T_NAME FROM DISCIPLINE WHERE ID_DN = ?";
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1,id);
            ResultSet rs = pstmt.executeQuery();
            System.out.println("DISCIPLINE: ");
            while (rs.next()) {
                String dname = rs.getString("D_NAME");
                int hours = rs.getInt("HOURS");
                short isexam = rs.getShort("ISEXAM");
                String tname = rs.getString("T_NAME");
                System.out.println(dname +" "+hours+" "+isexam+" "+tname);
            }
            pstmt.close();
        } catch (SQLException e) {
            System.out.println("ERROR! Something went wrong with DISCIPLINE LIST" + e.getMessage());
        }
    }

    public void searchDisciplineByTeacher(String name) {
        String sql = "SELECT D_NAME, HOURS, ISEXAM FROM DISCIPLINE WHERE T_NAME = ?";
        try {
            pstmt = connection.prepareStatement(sql);
            pstmt.setString(1,name);
            ResultSet rs = pstmt.executeQuery();
            System.out.println("DISCIPLINE: ");
            while (rs.next()) {
                String dname = rs.getString("D_NAME");
                int hours = rs.getInt("HOURS");
                short isexam = rs.getShort("ISEXAM");
                System.out.println(dname +" "+hours+" "+isexam);
            }
            pstmt.close();
        } catch (SQLException e) {
            System.out.println("ERROR! Something went wrong with DISCIPLINE LIST" + e.getMessage());
        }
    }
}

