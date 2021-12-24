package by.epamtc.vaskevichartsiom.task_xml.model;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

public class Medicine implements Serializable {
    private String name;
    private String pharm;
    private String group;
    private String[] analogs;
    private String[] versions;
    private Certificate certificate;
    private Package aPackage;
    private Dosage dosage;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPharm() {
        return pharm;
    }

    public void setPharm(String pharma) {
        this.pharm = pharma;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String[] getAnalogs() {
        return analogs;
    }

    public void setAnalogs(String[] analogs) {
        this.analogs = analogs;
    }

    public String[] getVersions() {
        return versions;
    }

    public void setVersions(String[] versions) {
        this.versions = versions;
    }

    public Certificate getCertificate() {
        return certificate;
    }

    public void setCertificate(Certificate certificate) {
        this.certificate = certificate;
    }

    public Package getaPackage() {
        return aPackage;
    }

    public void setaPackage(Package aPackage) {
        this.aPackage = aPackage;
    }

    public Dosage getDosage() {
        return dosage;
    }

    public void setDosage(Dosage dosage) {
        this.dosage = dosage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Medicine medicine = (Medicine) o;
        return Objects.equals(name, medicine.name) && Objects.equals(pharm, medicine.pharm) && Objects.equals(group, medicine.group) && Arrays.equals(analogs, medicine.analogs) && Arrays.equals(versions, medicine.versions) && Objects.equals(certificate, medicine.certificate) && Objects.equals(aPackage, medicine.aPackage) && Objects.equals(dosage, medicine.dosage);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(name, pharm, group, certificate, aPackage, dosage);
        result = 31 * result + Arrays.hashCode(analogs);
        result = 31 * result + Arrays.hashCode(versions);
        return result;
    }

    @Override
    public String toString() {
        return "Medicine{" +
                "name='" + name + '\'' +
                ", pharma='" + pharm + '\'' +
                ", group='" + group + '\'' +
                ", analogs=" + Arrays.toString(analogs) +
                ", versions=" + Arrays.toString(versions) +
                ", certificate=" + certificate +
                ", aPackage=" + aPackage +
                ", dosage=" + dosage +
                '}';
    }
}
