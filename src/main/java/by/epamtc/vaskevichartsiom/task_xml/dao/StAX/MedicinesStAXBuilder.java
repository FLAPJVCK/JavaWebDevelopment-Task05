package by.epamtc.vaskevichartsiom.task_xml.dao.StAX;

import by.epamtc.vaskevichartsiom.task_xml.dao.AbstractMedicinesBuilder;
import by.epamtc.vaskevichartsiom.task_xml.dao.MedicineTag;
import by.epamtc.vaskevichartsiom.task_xml.model.Medicine;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Date;

public class MedicinesStAXBuilder extends AbstractMedicinesBuilder {
    private XMLInputFactory xmlInputFactory;

    public MedicinesStAXBuilder() {
        xmlInputFactory = XMLInputFactory.newInstance();
    }

    boolean bName = false;
    boolean bPharm = false;
    boolean bGroup = false;
    boolean bAnalogs = false;
    boolean bAnalog = false;
    boolean bVersions = false;
    boolean bVersion = false;
    boolean bNumber = false;
    boolean bIssueDate = false;
    boolean bExpiryDate = false;
    boolean bType = false;
    boolean bQuantity = false;
    boolean bPrice = false;
    boolean bAmount = false;
    boolean bPeriod = false;

    @Override
    public void buildMedicines(String filename) {
        XMLEventReader xmlEventReader;
        Medicine medicine = null;
        try {
            xmlEventReader = xmlInputFactory.createXMLEventReader(new FileReader(filename));

            while (xmlEventReader.hasNext()) {

                XMLEvent xmlEvent = xmlEventReader.nextEvent();
                switch (xmlEvent.getEventType()) {

                    case XMLStreamConstants.START_ELEMENT:
                        StartElement startElement = xmlEvent.asStartElement();
                        String qName = startElement.getName().getLocalPart();
                        if (qName.equalsIgnoreCase(MedicineTag.MEDICINE.getValue())) {
                            medicine = new Medicine();
                        } else if (qName.equalsIgnoreCase(MedicineTag.NAME.getValue())) {
                            bName = true;
                        } else if (qName.equalsIgnoreCase(MedicineTag.PHARM.getValue())) {
                            bPharm = true;
                        } else if (qName.equalsIgnoreCase(MedicineTag.GROUP.getValue())) {
                            bGroup = true;
                        } else if (qName.equalsIgnoreCase(MedicineTag.ANALOGS.getValue())) {
                            bAnalogs = true;
                        } else if (qName.equalsIgnoreCase(MedicineTag.ANALOG.getValue())) {
                            bAnalog = true;
                        } else if (qName.equalsIgnoreCase(MedicineTag.VERSIONS.getValue())) {
                            bVersions = true;
                        } else if (qName.equalsIgnoreCase(MedicineTag.VERSION.getValue())) {
                            bVersion = true;
                        } else if (qName.equalsIgnoreCase(MedicineTag.NUMBER.getValue())) {
                            bNumber = true;
                        } else if (qName.equalsIgnoreCase(MedicineTag.ISSUEDATE.getValue())) {
                            bIssueDate = true;
                        } else if (qName.equalsIgnoreCase(MedicineTag.EXPIRYDATE.getValue())) {
                            bExpiryDate = true;
                        } else if (qName.equalsIgnoreCase(MedicineTag.TYPE.getValue())) {
                            bType = true;
                        } else if (qName.equalsIgnoreCase(MedicineTag.QUANTITY.getValue())) {
                            bQuantity = true;
                        } else if (qName.equalsIgnoreCase(MedicineTag.PRICE.getValue())) {
                            bPrice = true;
                        } else if (qName.equalsIgnoreCase(MedicineTag.AMOUNT.getValue())) {
                            bAmount = true;
                        } else if (qName.equalsIgnoreCase(MedicineTag.PERIOD.getValue())) {
                            bPeriod = true;
                        }
                        break;

                    case XMLStreamConstants.CHARACTERS:
                        Characters characters = xmlEvent.asCharacters();
                        if (bName) {
                            medicine.setName(characters.getData());
                            bName = false;
                        }
                        if (bPharm) {
                            medicine.setPharm(characters.getData());
                            bPharm = false;
                        }
                        if (bGroup) {
                            medicine.setGroup(characters.getData());
                            bGroup = false;
                        }
                        if (bAnalogs) {
                            medicine.setAnalogs(characters.getData());
                            bAnalogs = false;
                        }
                        if (bAnalog) {
                            medicine.setAnalog(characters.getData());
                            bAnalog = false;
                        }
                        if (bVersions) {
                            medicine.setVersions(characters.getData());
                            bVersions = false;
                        }
                        if (bVersion) {
                            medicine.setVersion(characters.getData());
                            bVersion = false;
                        }
                        if (bNumber) {
                            medicine.setNumber(Integer.parseInt(characters.getData()));
                            bNumber = false;
                        }
                        if (bIssueDate) {
                            medicine.setIssueDate(new Date(new Long((characters.getData()))));
                            bIssueDate = false;
                        }
                        if (bExpiryDate) {
                            medicine.setExpiryDate(new Date(new Long((characters.getData()))));
                            bExpiryDate = false;
                        }
                        if (bType) {
                            medicine.setType(characters.getData());
                            bType = false;
                        }
                        if (bQuantity) {
                            medicine.setQuantity(Integer.parseInt(characters.getData()));
                            bQuantity = false;
                        }
                        if (bPrice) {
                            medicine.setPrice(Integer.parseInt(characters.getData()));
                            bPrice = false;
                        }
                        if (bAmount) {
                            medicine.setAmount(Integer.parseInt(characters.getData()));
                            bAmount = false;
                        }
                        if (bPeriod) {
                            medicine.setPeriod(Integer.parseInt(characters.getData()));
                            bPeriod = false;
                        }
                        break;

                    case XMLStreamConstants.END_ELEMENT:
                        EndElement endElement = xmlEvent.asEndElement();
                        if (endElement.getName().getLocalPart().equals(MedicineTag.MEDICINE.getValue())) {
                            medicines.addMedicine(medicine);
                        }
                        break;
                }
            }
        } catch (NullPointerException e){
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
    }
}
