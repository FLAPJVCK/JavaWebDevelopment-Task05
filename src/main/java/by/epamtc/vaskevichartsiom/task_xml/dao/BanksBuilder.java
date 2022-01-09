package by.epamtc.vaskevichartsiom.task_xml.dao;

import by.epamtc.vaskevichartsiom.task_xml.dao.DOM.BanksDOMBuilder;
import by.epamtc.vaskevichartsiom.task_xml.dao.SAX.BanksSAXBuilder;
import by.epamtc.vaskevichartsiom.task_xml.dao.StAX.BanksStAXBuilder;
import org.xml.sax.SAXException;

public class BanksBuilder {
    private static BanksBuilder instance;

    private enum ParserType{
        SAX, STAX, DOM
    }

    private BanksBuilder() {
    }

    public static BanksBuilder getInstance() {
        if(instance == null){
            synchronized (BanksBuilder.class){
                if(instance == null){
                    instance = new BanksBuilder();
                }
            }
        }
        return instance;
    }

    public AbstractBanksBuilder createBanksBuilder(String parserType) throws SAXException {
        ParserType type = ParserType.valueOf(parserType.toUpperCase());
        switch (type){
            case SAX:
                return new BanksSAXBuilder();
            case STAX:
                return new BanksStAXBuilder();
            case DOM:
                return new BanksDOMBuilder();
            default:
                return null;
        }
    }
}
