package by.epamtc.vaskevichartsiom.task_xml.dao;

import by.epamtc.vaskevichartsiom.task_xml.model.Banks;

public abstract class AbstractBanksBuilder {
    protected Banks banks;

    public AbstractBanksBuilder() {
        banks = new Banks();
    }

    public Banks getBanks(){
        return banks;
    }

    public abstract void buildBanks(String filename);
}
