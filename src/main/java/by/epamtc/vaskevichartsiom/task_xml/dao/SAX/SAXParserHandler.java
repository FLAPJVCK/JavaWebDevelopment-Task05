package by.epamtc.vaskevichartsiom.task_xml.dao.SAX;

import by.epamtc.vaskevichartsiom.task_xml.dao.BankTag;
import by.epamtc.vaskevichartsiom.task_xml.model.Bank;
import by.epamtc.vaskevichartsiom.task_xml.model.Type;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SAXParserHandler extends DefaultHandler {
    private List<Bank> banks;
    private Bank currentBank;
    private StringBuilder data;

    boolean bName = false;
    boolean bCountry = false;
    boolean bType = false;
    boolean bDepositor = false;
    boolean bAccountId = false;
    boolean bAmountOnDeposit = false;
    boolean bProfitability = false;
    boolean bTimeConstrains = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

        if (qName.equalsIgnoreCase(BankTag.BANK.getValue())) {
            currentBank = new Bank();
            if (banks == null)
                banks = new ArrayList<>();
        } else if (qName.equalsIgnoreCase(BankTag.NAME.getValue())) {
            bName = true;
        } else if (qName.equalsIgnoreCase(BankTag.COUNTRY.getValue())) {
            bCountry = true;
        } else if (qName.equalsIgnoreCase(BankTag.TYPE.getValue())) {
            bType = true;
        } else if (qName.equalsIgnoreCase(BankTag.DEPOSITOR.getValue())) {
            bDepositor = true;
        } else if (qName.equalsIgnoreCase(BankTag.ACCOUNT_ID.getValue())) {
            bAccountId = true;
        } else if (qName.equalsIgnoreCase(BankTag.AMOUNT_ON_DEPOSIT.getValue())) {
            bAmountOnDeposit = true;
        } else if (qName.equalsIgnoreCase(BankTag.PROFITABILITY.getValue())) {
            bProfitability = true;
        } else if (qName.equalsIgnoreCase(BankTag.TIME_CONSTRAINS.getValue())) {
            bTimeConstrains = true;
        }
        data = new StringBuilder();
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (bName) {
            currentBank.setName(data.toString());
            bName = false;
        } else if (bCountry) {
            currentBank.setCountry(data.toString());
            bCountry = false;
        } else if (bType) {
            currentBank.setType(Type.valueOf(data.toString()));
            bType = false;
        } else if (bDepositor) {
            currentBank.setDepositor(data.toString());
            bDepositor = false;
        } else if (bAccountId) {
            currentBank.setAccountId(data.toString());
            bAccountId = false;
        } else if (bAmountOnDeposit) {
            currentBank.setAmountOnDeposit(new Float(data.toString()));
            bAmountOnDeposit = false;
        } else if (bProfitability) {
            currentBank.setProfitability(new Float(data.toString()));
            bProfitability = false;
        } else if (bTimeConstrains) {
            currentBank.setTimeConstrains(new Date(new Long(data.toString())));
            bTimeConstrains = false;
        }
        if (qName.equalsIgnoreCase(BankTag.BANK.getValue())) {
            banks.add(currentBank);
        }
    }

    @Override
    public void characters(char ch[], int start, int length) throws SAXException {
        data.append(new String(ch, start, length));
    }

    public List<Bank> getBanks() {
        return banks;
    }
}
