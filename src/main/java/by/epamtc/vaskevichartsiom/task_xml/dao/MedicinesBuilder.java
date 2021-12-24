package by.epamtc.vaskevichartsiom.task_xml.dao;

import by.epamtc.vaskevichartsiom.task_xml.dao.DOM.MedicinesDOMBuilder;
import by.epamtc.vaskevichartsiom.task_xml.dao.SAX.MedicinesSAXBuilder;
import by.epamtc.vaskevichartsiom.task_xml.dao.StAX.MedicinesStAXBuilder;
import org.xml.sax.SAXException;

public class MedicinesBuilder {
    private static MedicinesBuilder instance;

    private enum ParserType{
        SAX, STAX, DOM
    }

    private MedicinesBuilder() {
    }

    public static MedicinesBuilder getInstance() {
        if(instance == null){
            synchronized (MedicinesBuilder.class){
                if(instance == null){
                    instance = new MedicinesBuilder();
                }
            }
        }
        return instance;
    }

    public AbstractMedicinesBuilder createMedicinesBuilder(String parserType) throws SAXException {
        ParserType type = ParserType.valueOf(parserType.toUpperCase());
        switch (type){
            case SAX:
                return new MedicinesSAXBuilder();
            case STAX:
                return new MedicinesStAXBuilder();
            case DOM:
                return new MedicinesDOMBuilder();
            default:
                return null;
        }
    }
}
