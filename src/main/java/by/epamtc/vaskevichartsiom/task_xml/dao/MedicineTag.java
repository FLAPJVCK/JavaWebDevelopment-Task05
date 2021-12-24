package by.epamtc.vaskevichartsiom.task_xml.dao;

public enum MedicineTag {
    MEDICINES("medicines"),
    MEDICINE("medicine"),
    ANALOGS("analogs"),
    ANALOG("analog"),
    VERSIONS("versions"),
    VERSION("version"),
    CERTIFICATE("certificate"),
    PACKAGE("package"),
    DOSAGE("dosage");

    private final String value;

    MedicineTag(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public static MedicineTag fromValue(String value){
        for(MedicineTag type : MedicineTag.values()){
            if(type.value.equals(value)){
                return type;
            }
        }
        return null;
    }
}
