package xml_factory;

import mySql_model.Teacher;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.IOException;
import java.util.Set;

public class TeachersSAXBuilder extends AbstractTeachersBuilder {
    private TeacherHandler th;
    private XMLReader reader;

    public TeachersSAXBuilder() {
        th = new TeacherHandler();
        try
        {
        reader = XMLReaderFactory.createXMLReader();
        reader.setContentHandler(th);
        } catch (SAXException e) {
            System.err.print("SAX parser error: " + e);
        }
    }
    public TeachersSAXBuilder (Set<Teacher> teachers) {
        super(teachers);
         }

    @Override
    public void buildSetTeachers(String filename) {
        try
        {
        reader.parse(filename);
        } catch (SAXException e) {
            System.err.print("SAX parser error: " + e);
        } catch (IOException e) {
            System.err.print("I/O error: " + e);
        }
        teachers=th.getTeachers();
    }
}
