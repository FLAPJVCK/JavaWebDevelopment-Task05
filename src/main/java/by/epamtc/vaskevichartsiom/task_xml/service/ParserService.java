package by.epamtc.vaskevichartsiom.task_xml.service;

import by.epamtc.vaskevichartsiom.task_xml.dao.AbstractBanksBuilder;
import by.epamtc.vaskevichartsiom.task_xml.dao.BanksBuilder;
import by.epamtc.vaskevichartsiom.task_xml.model.Banks;
import org.xml.sax.SAXException;

public class ParserService {
    public Banks parseXML(String parserType, String fileXML) throws SAXException {
        AbstractBanksBuilder builder = BanksBuilder.getInstance().createBanksBuilder(parserType);
        builder.buildBanks(fileXML);
        return builder.getBanks();
    }
}
