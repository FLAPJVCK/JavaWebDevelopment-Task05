package by.epamtc.vaskevichartsiom.task_xml.dao.DOM;

import by.epamtc.vaskevichartsiom.task_xml.dao.AbstractBanksBuilder;
import by.epamtc.vaskevichartsiom.task_xml.dao.BankTag;
import by.epamtc.vaskevichartsiom.task_xml.model.Bank;
import by.epamtc.vaskevichartsiom.task_xml.model.Type;
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

public class BanksDOMBuilder extends AbstractBanksBuilder {
    private final static String XSDSchema = "resources/Banks.xsd";
    private DocumentBuilder documentBuilder;

    public BanksDOMBuilder() throws SAXException {
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
    public void buildBanks(String filename){
        Document document;
        try{
            document = documentBuilder.parse(filename);
            Element root = document.getDocumentElement();
            NodeList banksNode = root.getElementsByTagName(BankTag.BANK.getValue());
            for(int i = 0; i < banksNode.getLength(); i++){
                Element bankElement = (Element)banksNode.item(i);
                Bank bank = buildBank(bankElement);
                banks.addBank(bank);
            }
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Bank buildBank(Element element){
        Bank bank = new Bank();
        bank.setName(getElementTextContext(element, BankTag.NAME));
        bank.setCountry(getElementTextContext(element, BankTag.COUNTRY));
        bank.setType(Type.valueOf(getElementTextContext(element, BankTag.TYPE)));
        bank.setDepositor(getElementTextContext(element, BankTag.DEPOSITOR));
        bank.setAccountId(getElementTextContext(element, BankTag.ACCOUNT_ID));
        bank.setAmountOnDeposit(new Float(getElementTextContext(element, BankTag.AMOUNT_ON_DEPOSIT)));
        bank.setProfitability(new Float(getElementTextContext(element, BankTag.PROFITABILITY)));
        bank.setTimeConstrains(new Date(new Long(getElementTextContext(element, BankTag.TIME_CONSTRAINS))));
        return bank;
    }

    private String getElementTextContext(Element element, BankTag tag){
        NodeList nodeList = element.getElementsByTagName(tag.getValue());
        Node node = nodeList.item(0);
        return node.getTextContent();
    }
}
