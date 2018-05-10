package dao;

import mySql_model.Discipline;
import mySql_model.Teacher;

import java.sql.SQLException;

public class DAOMain {
    public static void main(String[] args) {
        ProductDAO dao = new ProductDAO();
        try {
            dao.addTeacherDOM();
            /*Teacher darth = new Teacher("DARTH VADER","DARK SIDE SUPREME");
            dao.setTeacherStatus(darth);*/
            /*dao.printAllTeacher(dao.getTeachers());*/
            /*dao.printFeatures(dao.getTeachersStatusByName("IVANOV IVAN"));*/
            /*dao.printFeatures(dao.getTeachersName());*/
           /* Teacher obi1 = new Teacher("OBI-WAN KENOBI42", "JEDI");
            dao.addTeacher(obi1);*/
            /*dao.printAllTeacher(dao.getTeachers());*/
            /*dao.addDiscipline(new Discipline(01010, "TEST42", 42, (short)42, "OBI-WAN KENOBI42"));*/
            /*dao.printAllDiscipline(dao.getDisciplines());*/
            /*dao.removeTeacher(obi1);
            dao.printAllDiscipline(dao.getDisciplines());*/
            /*dao.deleteTeacher(obi1);*/
            /*Teacher darth = new Teacher("DARTH VADER","DARK SIDE");
            dao.setTeacherStatus(darth);*/
            /*Teacher ivan = new Teacher("IVANOV IVAN", "SENIOR");
            dao.printAllDiscipline(dao.getDiscilineByTeacher(ivan));*/
            /*dao.printAllDiscipline(dao.getDisciplineById(12111));*/
           /* dao.printAllDiscipline(dao.getDisciplines());*/
            /*dao.addDiscipline(new Discipline(12121, "MY SQL", 20, (short)1, "VERES MAX"));*/
           /* dao.addDiscipline(new Discipline(10111,"RUSSIAN LANGUAGE", 1, (short)0, "IVANOV IVAN"));*/
            /*dao.removeDiscipline(10111);*/

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
