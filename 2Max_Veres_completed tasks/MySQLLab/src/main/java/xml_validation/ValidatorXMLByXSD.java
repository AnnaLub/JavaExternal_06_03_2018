package xml_validation;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class ValidatorXMLByXSD {

    public static boolean validateXML(File xml, File xsd) {
        /*SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);*/
        try {
            /*Schema schema = factory.newSchema(xsd);
            SAXParserFactory spf = SAXParserFactory.newInstance();
            spf.setSchema(schema);
            SAXParser parser = spf.newSAXParser();
            parser.parse(xml, new TeacherErrorHandler());*/

            Validator validator = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI).newSchema(xsd).newValidator();
            TeacherErrorHandler seh = new TeacherErrorHandler();
            validator.setErrorHandler(seh);
            validator.validate(new StreamSource(xml));

        } catch (SAXException e) {
            System.err.println(xml.getName() + " config error: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("I/O error: " + e.getMessage());
            return false;
        } /*catch (ParserConfigurationException e) {
            e.printStackTrace();
        }*/
        return true;
    }
}
