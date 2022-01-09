package by.epamtc.vaskevichartsiom.task_xml.model;

import java.util.ArrayList;
import java.util.List;

public class Banks {
    private List<Bank> banks;

    public Banks() {
        banks = new ArrayList<Bank>();
    }

    public void addBank(Bank bank){
        banks.add(bank);
    }

    public List<Bank> getBanks() {
        return banks;
    }

    public void setBanks(List<Bank> banks) {
        this.banks = banks;
    }

    @Override
    public String toString() {
        return "Banks{" +
                "banks=" + banks +
                '}';
    }
}
