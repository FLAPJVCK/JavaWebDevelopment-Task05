package by.epamtc.vaskevichartsiom.task_xml.dao.DOM;

import by.epamtc.vaskevichartsiom.task_xml.dao.AbstractMedicinesBuilder;
import by.epamtc.vaskevichartsiom.task_xml.dao.MedicineTag;
import by.epamtc.vaskevichartsiom.task_xml.dao.MedicinesBuilder;
import by.epamtc.vaskevichartsiom.task_xml.model.Certificate;
import by.epamtc.vaskevichartsiom.task_xml.model.Medicine;
import by.epamtc.vaskevichartsiom.task_xml.model.Medicines;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.IOException;
import java.util.Date;

public class MedicinesDOMBuilder extends AbstractMedicinesBuilder {
    private final static String XSDSchema = "resources/Medicines.xsd";
    private DocumentBuilder documentBuilder;

    public MedicinesDOMBuilder() throws SAXException {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        documentBuilderFactory.setSchema(SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI).newSchema(new File(XSDSchema)));
        documentBuilderFactory.setNamespaceAware(true);
        documentBuilderFactory.setValidating(false);
        try{
            documentBuilder = documentBuilderFactory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void buildMedicines(String filename){
        Document document;
        try{
            document = documentBuilder.parse(filename);
            Element root = document.getDocumentElement();
            NodeList medicinesNode = root.getElementsByTagName(MedicineTag.MEDICINE.getValue());
            for(int i = 0; i < medicinesNode.getLength(); i++){
                Element medicineElement = (Element)medicinesNode.item(i);
                Medicine medicine = buildMedicine(medicineElement);
                medicines.addMedicine(medicine);
            }
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Medicine buildMedicine(Element element){
        Medicine medicine = new Medicine();
        medicine.setName(element.getAttribute("name"));
        medicine.setPharm(element.getAttribute("pharm"));
        medicine.setGroup(element.getAttribute("group"));
        String[] masMedicineAnalogs = getElementTextContext(element, MedicineTag.ANALOGS);
        medicine.setAnalogs(masMedicineAnalogs);
        String[] masMedicineVersions = getElementTextContext(element, MedicineTag.VERSIONS);
        medicine.setVersions(masMedicineVersions);
        return medicine;
    }

    private String[] getElementTextContext(Element element, MedicineTag tag){
        NodeList elementNode = element.getElementsByTagName(tag.getValue());
        String[] result = new String[elementNode.getLength()];
        for(int i = 0; i < elementNode.getLength(); i++){
            Element medicineElement = (Element)elementNode.item(i);
            result[i]=medicineElement.getTextContent();
        }
        return result;
    }
}
