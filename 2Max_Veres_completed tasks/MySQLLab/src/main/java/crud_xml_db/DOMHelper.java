package crud_xml_db;
import java.io.IOException;
import java.io.StringWriter;
import javax.xml.parsers.*;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;

public class DOMHelper {

    public static Document getDocument(String filename){
        Document document = null;
        try
        {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            document = db.parse(filename);

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return document;
    }

    public static String getXMLContent(Document document){
        String result = "";
        try
        {
        TransformerFactory tff = TransformerFactory.newInstance();
        Transformer tf = tff.newTransformer();
        tf.setOutputProperty(OutputKeys.INDENT,"yes");
        StringWriter sw = new StringWriter();
        StreamResult sr = new StreamResult(sw);
        DOMSource source = new DOMSource(document);
        tf.transform(source,sr);
        result = sw.toString();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void saveXMLContent(Document document, String filename){
        try
        {
        TransformerFactory tff = TransformerFactory.newInstance();
        Transformer tf = tff.newTransformer();
        tf.setOutputProperty(OutputKeys.INDENT,"yes");
        DOMSource ds = new DOMSource(document);
        StreamResult sr = new StreamResult(filename);
        tf.transform(ds,sr);
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
    }
}
