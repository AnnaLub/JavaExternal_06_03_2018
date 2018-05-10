package xml_factory;

import mySql_model.Teacher;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

public class TeachersStAXBuilder extends AbstractTeachersBuilder{
    private XMLInputFactory inputFactory;

    public TeachersStAXBuilder(){
        inputFactory = XMLInputFactory.newInstance();
    }

    public TeachersStAXBuilder (Set<Teacher> teachers) {
        super(teachers);
    }

    @Override
    public void buildSetTeachers(String filename){
        FileInputStream inputStream = null;
        XMLStreamReader reader = null;
        String name;
        try
        {
        inputStream = new FileInputStream(new File(filename));
        reader = inputFactory.createXMLStreamReader(inputStream);
        while(reader.hasNext()){
            int type = reader.next();
            if(type == XMLStreamConstants.START_ELEMENT){
                name = reader.getLocalName();
                if(TeacherEnum.valueOf(name.toUpperCase())==TeacherEnum.TEACHER){
                    Teacher teacher = buildTeacher(reader);
                    teachers.add(teacher);
                }
            }
        }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }finally {
            try
            {
            if(inputStream != null){
                inputStream.close();
            }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    private Teacher buildTeacher(XMLStreamReader reader) throws XMLStreamException{
        Teacher teacher = new Teacher();
        String name;
        while (reader.hasNext()){
            int type = reader.next();
            switch (type){
                case XMLStreamConstants.START_ELEMENT:
                    name = reader.getLocalName();
                    switch (TeacherEnum.valueOf(name.toUpperCase())) {
                        case NAME:
                            teacher.setName(getXMLText(reader));
                            break;
                        case STATUS:
                            teacher.setStatus(getXMLText(reader));
                            break;
                    }
                    break;
            case XMLStreamConstants.END_ELEMENT:
                name = reader.getLocalName();
                if(TeacherEnum.valueOf(name.toUpperCase())==TeacherEnum.TEACHER) {
                    return teacher;
                }
            break;
            }
        }
        throw new XMLStreamException("Unknown element in tag student");
    }

    private String getXMLText(XMLStreamReader reader) throws XMLStreamException {
        String text = null;
        if(reader.hasNext()){
            reader.next();
            text = reader.getText();
        }
        return text;
    }

}

