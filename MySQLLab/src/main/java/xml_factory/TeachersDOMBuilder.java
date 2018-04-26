package xml_factory;

import mySql_model.Teacher;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class TeachersDOMBuilder extends AbstractTeachersBuilder{
    private DocumentBuilder docBuilder;

    public TeachersDOMBuilder() {
        this.teachers = new HashSet<Teacher>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try
        {
            docBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    public TeachersDOMBuilder (Set<Teacher> teachers) {
        super(teachers);
    }

    @Override
    public void buildSetTeachers(String filename){
        Document doc = null;
        try
        {
        doc = docBuilder.parse(filename);
        Element root = doc.getDocumentElement();
        NodeList teachersList = root.getElementsByTagName("teacher");
            for (int i = 0; i < teachersList.getLength(); i++) {
                Element teacherElement = (Element) teachersList.item(i);
                Teacher teacher = buildTeacher(teacherElement);
                teachers.add(teacher);
            }
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Teacher buildTeacher(Element teacherElement){
        Teacher teacher = new Teacher();
        teacher.setName(getElementTextContent(teacherElement,"name"));
        teacher.setStatus(getElementTextContent(teacherElement,"status"));
        return teacher;
    }
    private static String getElementTextContent(Element element, String elementName){
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        String text = node.getTextContent();
        return text;


    }
}
