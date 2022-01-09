package by.epamtc.vaskevichartsiom.task_xml.dao.StAX;

import by.epamtc.vaskevichartsiom.task_xml.dao.AbstractBanksBuilder;
import by.epamtc.vaskevichartsiom.task_xml.dao.BankTag;
import by.epamtc.vaskevichartsiom.task_xml.model.Bank;
import by.epamtc.vaskevichartsiom.task_xml.model.Type;


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

public class BanksStAXBuilder extends AbstractBanksBuilder {
    private XMLInputFactory xmlInputFactory;

    public BanksStAXBuilder() {
        xmlInputFactory = XMLInputFactory.newInstance();
    }

    boolean bName = false;
    boolean bCountry = false;
    boolean bType = false;
    boolean bDepositor = false;
    boolean bAccountId = false;
    boolean bAmountOnDeposit = false;
    boolean bProfitability = false;
    boolean bTimeConstrains = false;

    @Override
    public void buildBanks(String filename) {
        XMLEventReader xmlEventReader;
        Bank bank = null;
        try {
            xmlEventReader = xmlInputFactory.createXMLEventReader(new FileReader(filename));
            while (xmlEventReader.hasNext()) {
                XMLEvent xmlEvent = xmlEventReader.nextEvent();
                switch (xmlEvent.getEventType()) {
                    case XMLStreamConstants.START_ELEMENT:
                        StartElement startElement = xmlEvent.asStartElement();
                        String qName = startElement.getName().getLocalPart();
                        if (qName.equalsIgnoreCase(BankTag.BANK.getValue())) {
                            bank = new Bank();
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
                        break;

                    case XMLStreamConstants.CHARACTERS:
                        Characters characters = xmlEvent.asCharacters();
                        if (bName) {
                            bank.setName(characters.getData());
                            bName = false;
                        }
                        if (bCountry) {
                            bank.setCountry(characters.getData());
                            bCountry = false;
                        }
                        if (bType) {
                            bank.setType(Type.valueOf(characters.getData()));
                            bType = false;
                        }
                        if (bDepositor) {
                            bank.setDepositor(characters.getData());
                            bDepositor = false;
                        }
                        if (bAccountId) {
                            bank.setAccountId(characters.getData());
                            bAccountId = false;
                        }
                        if (bAmountOnDeposit) {
                            bank.setAmountOnDeposit(new Float(characters.getData()));
                            bAmountOnDeposit = false;
                        }
                        if (bProfitability) {
                            bank.setProfitability(new Float(characters.getData()));
                            bProfitability = false;
                        }
                        if (bTimeConstrains) {
                            bank.setTimeConstrains(new Date(new Long((characters.getData()))));
                            bTimeConstrains = false;
                        }
                        break;

                    case XMLStreamConstants.END_ELEMENT:
                        EndElement endElement = xmlEvent.asEndElement();
                        if (endElement.getName().getLocalPart().equals(BankTag.BANK.getValue())) {
                            banks.addBank(bank);
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
