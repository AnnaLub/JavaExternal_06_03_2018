package xml_factory;

import mySql_model.Teacher;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

public class TeacherHandler extends DefaultHandler {
    private Set<Teacher> teachers;
    private Teacher current = null;
    private TeacherEnum currentEnum = null;
    private EnumSet<TeacherEnum> withText;

    public TeacherHandler() {
        teachers = new HashSet<Teacher>();
        withText = EnumSet.range(TeacherEnum.NAME,TeacherEnum.STATUS);
    }

    public Set<Teacher> getTeachers() {
        return teachers;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if ("teacher".equals(localName)) {
            current = new Teacher();
        }else{
            TeacherEnum temp = TeacherEnum.valueOf(localName.toUpperCase());
            if(withText.contains(temp)){
                currentEnum = temp;
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if("teacher".equals(localName)){
            teachers.add(current);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String s =new String(ch,start,length).trim();
        if(currentEnum != null){
            switch(currentEnum){
                case NAME:
                    current.setName(s);
                    break;
                case STATUS:
                    current.setStatus(s);
                    break;
                default:
                    throw new EnumConstantNotPresentException(currentEnum.getDeclaringClass(),currentEnum.name());
            }
            currentEnum = null;
        }
    }
}
