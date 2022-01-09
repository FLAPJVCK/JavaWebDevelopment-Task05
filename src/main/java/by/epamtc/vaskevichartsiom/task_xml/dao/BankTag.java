package by.epamtc.vaskevichartsiom.task_xml.dao;

public enum BankTag {
    BANKS("banks"),
    BANK("bank"),
    NAME("name"),
    COUNTRY("country"),
    TYPE("type"),
    DEPOSITOR("depositor"),
    ACCOUNT_ID("accountId"),
    AMOUNT_ON_DEPOSIT("amountOnDeposit"),
    PROFITABILITY("profitability"),
    TIME_CONSTRAINS("timeConstrains");

    private final String value;

    BankTag(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static BankTag fromValue(String value){
        for(BankTag type : BankTag.values()){
            if(type.value.equals(value)){
                return type;
            }
        }
        return null;
    }
}
