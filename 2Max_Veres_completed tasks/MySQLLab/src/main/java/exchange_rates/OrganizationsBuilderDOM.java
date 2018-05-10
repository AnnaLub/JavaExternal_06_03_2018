package exchange_rates;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class OrganizationsBuilderDOM {
    protected Set<Organization> organizations;
    private DocumentBuilder docBuilder;

    public OrganizationsBuilderDOM() {
        organizations = new HashSet<>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try
        {
            docBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    public OrganizationsBuilderDOM(Set<Organization> organizations) {
        this.organizations = organizations;
    }

    public Set<Organization> getOrganizations() {
        return organizations;
    }

    static void displayOrganizations(Set<Organization> organizations){
        Organization [] arr = organizations.toArray(new Organization[organizations.size()]);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i].toString());

        }
    }

    public void buildSetOrganizations(String filename) {
        Document doc = null;
        try {
            doc = docBuilder.parse(filename);
            Element root = doc.getDocumentElement();
            NodeList organizationsList = root.getElementsByTagName("organization");
            for (int i = 0; i < organizationsList.getLength(); i++) {
                Element organizationElement = (Element) organizationsList.item(i);
                Organization organization = buildOrganization(organizationElement);
                organizations.add(organization);
            }
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Organization buildOrganization(Element organizationElement){
        Organization organization = new Organization();
        /*organization.setTitle(organizationElement.getAttribute("title"));*/
        organization.setTitle(getElementTextContent(organizationElement,"title"));
        Organization.Currency [] currency = organization.getCurrency();
        for (int i = 0; i < currency.length; i++) {
        Element  currencyElement = (Element)organizationElement.getElementsByTagName("c").item(i);
        currency[i].setId(getElementTextContent(currencyElement,"id"));
        Double br = Double.parseDouble(getElementTextContent(currencyElement,"br"));
        currency[i].setBr(br);
        Double ar = Double.parseDouble(getElementTextContent(currencyElement,"ar"));
        currency[i].setAr(ar);
        }
        organization.setCurrency(currency);
        return organization;
    }
    private static String getElementTextContent(Element element, String elementName){
        NodeList nList = element.getElementsByTagName(elementName);
        Node node = nList.item(0);
        /*String text = node.getNodeName();*/
        String text = node.getTextContent();
        return text;
    }

}



