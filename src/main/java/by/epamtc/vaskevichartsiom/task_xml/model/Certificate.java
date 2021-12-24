package by.epamtc.vaskevichartsiom.task_xml.model;

import java.util.Date;
import java.util.Objects;

public class Certificate {
    private int number;
    private Date issueDate;
    private Date expiryDate;
    private String organization;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Certificate that = (Certificate) o;
        return number == that.number && Objects.equals(issueDate, that.issueDate) && Objects.equals(expiryDate, that.expiryDate) && Objects.equals(organization, that.organization);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, issueDate, expiryDate, organization);
    }

    @Override
    public String toString() {
        return "Certificate{" +
                "number=" + number +
                ", issueDate=" + issueDate +
                ", expiryDate=" + expiryDate +
                ", organization='" + organization + '\'' +
                '}';
    }
}
