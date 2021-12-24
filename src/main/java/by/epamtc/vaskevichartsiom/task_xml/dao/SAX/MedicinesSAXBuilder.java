package by.epamtc.vaskevichartsiom.task_xml.dao.SAX;

import by.epamtc.vaskevichartsiom.task_xml.dao.AbstractMedicinesBuilder;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.IOException;

public class MedicinesSAXBuilder extends AbstractMedicinesBuilder {
    private final static String XSDSchema = "resources/Medicines.xsd";
    private SAXParser saxParser;
    private SAXParserHandler saxParserHandler;

    public MedicinesSAXBuilder() throws SAXException {
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
    public void buildMedicines(String filename) {
        try{
            saxParser.parse(filename,saxParserHandler);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        medicines.setMedicines(saxParserHandler.getMedicines());
    }
}
