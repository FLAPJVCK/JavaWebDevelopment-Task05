package by.epamtc.vaskevichartsiom.task_xml.service;

import by.epamtc.vaskevichartsiom.task_xml.dao.AbstractMedicinesBuilder;
import by.epamtc.vaskevichartsiom.task_xml.dao.MedicinesBuilder;
import by.epamtc.vaskevichartsiom.task_xml.model.Medicines;
import org.xml.sax.SAXException;

public class ParserService {
    public Medicines parseXML(String parserType, String fileXML) throws SAXException {
        AbstractMedicinesBuilder builder = MedicinesBuilder.getInstance().createMedicinesBuilder(parserType);
        builder.buildMedicines(fileXML);
        return builder.getMedicines();
    }
}
