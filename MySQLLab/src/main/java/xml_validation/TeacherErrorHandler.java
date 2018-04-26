package xml_validation;

import org.apache.log4j.Logger;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

public class TeacherErrorHandler extends DefaultHandler {
    private Logger xmllogger;


    public TeacherErrorHandler() {
        this.xmllogger = Logger.getLogger("xml.logger");
    }

    public void warning(SAXParseException e){
        xmllogger.warn(getLineAddress(e) + e.getMessage());
    }
    public void error(SAXParseException e){
        xmllogger.error(getLineAddress(e) + e.getMessage());
    }
    public void fatalError(SAXParseException e){
        xmllogger.fatal(getLineAddress(e) + e.getMessage());
    }
    private String getLineAddress(SAXParseException e){
        return e.getLineNumber()+" : "+e.getColumnNumber();
    }
}
