package by.epamtc.vaskevichartsiom.task_xml.dao.SAX;

import by.epamtc.vaskevichartsiom.task_xml.dao.MedicineTag;
import by.epamtc.vaskevichartsiom.task_xml.model.Medicine;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SAXParserHandler extends DefaultHandler {
    private List<Medicine> medicines;
    private Medicine currentMedicine;
    private StringBuilder data;

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
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        if (qName.equalsIgnoreCase(MedicineTag.MEDICINE.getValue())) {
            currentMedicine = new Medicine();
            if (medicines == null)
                medicines = new ArrayList<>();
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
        data = new StringBuilder();
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (bName) {
            currentMedicine.setName(data.toString());
            bName = false;
        } else if (bPharm) {
            currentMedicine.setPharm(data.toString());
            bPharm = false;
        } else if (bGroup) {
            currentMedicine.setGroup(data.toString());
            bGroup = false;
        } else if (bAnalogs) {
            currentMedicine.setAnalogs(data.toString());
            bAnalogs = false;
        } else if (bAnalog) {
            currentMedicine.setAnalog(data.toString());
            bAnalog = false;
        } else if (bVersions) {
            currentMedicine.setVersions(data.toString());
            bVersions = false;
        } else if (bVersion) {
            currentMedicine.setVersion(Integer.parseInt(data.toString()));
            bVersion = false;
        } else if (bNumber) {
            currentMedicine.setNumber(Integer.parseInt(data.toString()));
            bNumber = false;
        } else if (bIssueDate) {
            currentMedicine.setIssueDate(new Date(new Long(data.toString())));
            bIssueDate = false;
        } else if (bExpiryDate) {
            currentMedicine.setExpiryDate(new Date(new Long(data.toString())));
            bExpiryDate = false;
        } else if (bType) {
            currentMedicine.setType(data.toString());
            bType = false;
        } else if (bQuantity) {
            currentMedicine.setQuantity(Integer.parseInt(data.toString()));
            bQuantity = false;
        } else if (bPrice) {
            currentMedicine.setPrice(Integer.parseInt(data.toString()));
            bPrice = false;
        } else if (bAmount) {
            currentMedicine.setAmount(Integer.parseInt(data.toString()));
            bAmount = false;
        } else if (bPeriod) {
            currentMedicine.setPeriod(Integer.parseInt(data.toString()));
            bPeriod = false;
        }
        if (qName.equalsIgnoreCase(MedicineTag.MEDICINE.getValue())) {
            medicines.add(currentMedicine);
        }
    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {
        data.append(new String(ch, start, length));
    }

    public List<Medicine> getMedicines() {
        return medicines;
    }
}
