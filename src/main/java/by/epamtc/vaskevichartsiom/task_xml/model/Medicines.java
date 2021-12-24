package by.epamtc.vaskevichartsiom.task_xml.model;

import java.util.ArrayList;
import java.util.List;

public class Medicines {
    private List<Medicine> medicines;

    public Medicines() {
        medicines = new ArrayList<Medicine>();
    }

    public List<Medicine> getMedicines(){
        return medicines;
    }

    public void setMedicines(List<Medicine> medicines){
        this.medicines = medicines;
    }

    public void addMedicine(Medicine medicine){
        medicines.add(medicine);
    }

    @Override
    public String toString() {
        return "Medicines{" +
                "medicines=" + medicines +
                '}';
    }
}
