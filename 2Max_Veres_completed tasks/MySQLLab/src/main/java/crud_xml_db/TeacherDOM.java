package crud_xml_db;

import dao.ProductDAO;
import mySql_model.Teacher;
import org.w3c.dom.*;
import java.util.ArrayList;
import java.util.List;

public class TeacherDOM {

    //add elements2XMLfromDB
    public void addDOM(){
        List<Teacher> teachersListFromDB = new ArrayList<>();
        ProductDAO pDAO = new ProductDAO();
        try {
            teachersListFromDB = pDAO.getTeachers();
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            Document document = DOMHelper.getDocument("data/teachers.xml");
            for (int i = 0; i < teachersListFromDB.size(); i++) {
                Element teachers = document.getDocumentElement();
                Element teacher = document.createElement("teacher");
                String teacherName = teachersListFromDB.get(i).getName();
                Element name = document.createElement("name");
                name.appendChild(document.createTextNode(teacherName));
                teacher.appendChild(name);
                Element status = document.createElement("status");
                String teacherStatus = teachersListFromDB.get(i).getStatus();
                status.appendChild(document.createTextNode(teacherStatus));
                teacher.appendChild(status);
                teachers.appendChild(teacher);
                DOMHelper.saveXMLContent(document, "data/teachers.xml");
            }
        }
       catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void delete(String name){
        try
        {
        Document document = DOMHelper.getDocument("data/teachers.xml");
        NodeList teachersList = document.getElementsByTagName("teacher");
        for (int i = 0; i < teachersList.getLength(); i++) {
            Element et = (Element) teachersList.item(i);
            if (et.getElementsByTagName("name").item(0).getTextContent().equals(name)) {
                et.getParentNode().removeChild(et);
            }
        }
        DOMHelper.saveXMLContent(document,"data/teachers.xml");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void update(String name, String status){
        try
        {
        Document document = DOMHelper.getDocument("data/teachers.xml");
        NodeList teachersList = document.getElementsByTagName("teacher");
        for (int i = 0; i < teachersList.getLength(); i++) {
            Element et = (Element) teachersList.item(i);
            if (et.getElementsByTagName("name").item(0).getTextContent().equals(name)) {
                et.getElementsByTagName("status").item(0).setTextContent(status);
            }
        }
        DOMHelper.saveXMLContent(document,"data/teachers.xml");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
