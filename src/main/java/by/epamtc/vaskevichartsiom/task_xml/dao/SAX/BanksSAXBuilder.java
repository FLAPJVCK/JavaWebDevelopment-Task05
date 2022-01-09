package by.epamtc.vaskevichartsiom.task_xml.dao.SAX;

import by.epamtc.vaskevichartsiom.task_xml.dao.AbstractBanksBuilder;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.IOException;

public class BanksSAXBuilder extends AbstractBanksBuilder {
    private final static String XSDSchema = "resources/Banks.xsd";
    private SAXParser saxParser;
    private SAXParserHandler saxParserHandler;

    public BanksSAXBuilder() throws SAXException {
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        saxParserFactory.setSchema(SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI).newSchema(new File(XSDSchema)));
        saxParserFactory.setNamespaceAware(true);
        saxParserFactory.setValidating(false);
        try{
            saxParser = saxParserFactory.newSAXParser();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        saxParserHandler = new SAXParserHandler();
    }

    @Override
    public void buildBanks(String filename) {
        try{
            saxParser.parse(filename,saxParserHandler);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        banks.setBanks(saxParserHandler.getBanks());
    }
}
