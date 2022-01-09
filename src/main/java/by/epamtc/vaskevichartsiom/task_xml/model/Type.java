package by.epamtc.vaskevichartsiom.task_xml.model;

public enum Type {
    DEMAND("Demand"),
    TERM("Term"),
    SETTLEMENT("Settlement"),
    ACCUMULATIVE("Accumulative"),
    SAVINGS("Savings"),
    METAL("Metal");

    private String name;

    Type(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
