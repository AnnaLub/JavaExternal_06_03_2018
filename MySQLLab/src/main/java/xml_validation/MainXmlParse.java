package xml_validation;

import java.io.File;

public class MainXmlParse {
    public static void main(String[] args) {

        File xml = new File("data/teachers.xml");
        File xsd = new File("data/teachers.xsd");

        System.out.println(ValidatorXMLByXSD.validateXML(xml, xsd));
    }
}
