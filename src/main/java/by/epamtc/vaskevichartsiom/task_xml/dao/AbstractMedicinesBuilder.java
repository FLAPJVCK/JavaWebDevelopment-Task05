package by.epamtc.vaskevichartsiom.task_xml.dao;

import by.epamtc.vaskevichartsiom.task_xml.model.Medicines;

public abstract class AbstractMedicinesBuilder {
    protected Medicines medicines;

    public AbstractMedicinesBuilder() {
        medicines = new Medicines();
    }

    public Medicines getMedicines(){
        return medicines;
    }

    public abstract void buildMedicines(String filename);
}
