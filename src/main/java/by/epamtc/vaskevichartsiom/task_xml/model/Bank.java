package by.epamtc.vaskevichartsiom.task_xml.model;

import java.util.Date;
import java.util.Objects;

public class Bank {
    private String name;
    private String country;
    private Type type;
    private String depositor;
    private String accountId;
    private Float amountOnDeposit;
    private Float profitability;
    private Date timeConstrains;

    public Bank() {
    }

    public Bank(String name, String country, String depositor, String accountId, Float amountOnDeposit, Float profitability, Date timeConstrains) {
        this.name = name;
        this.country = country;
        this.depositor = depositor;
        this.accountId = accountId;
        this.amountOnDeposit = amountOnDeposit;
        this.profitability = profitability;
        this.timeConstrains = timeConstrains;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getDepositor() {
        return depositor;
    }

    public void setDepositor(String depositor) {
        this.depositor = depositor;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public Float getAmountOnDeposit() {
        return amountOnDeposit;
    }

    public void setAmountOnDeposit(Float amountOnDeposit) {
        this.amountOnDeposit = amountOnDeposit;
    }

    public Float getProfitability() {
        return profitability;
    }

    public void setProfitability(Float profitability) {
        this.profitability = profitability;
    }

    public Date getTimeConstrains() {
        return timeConstrains;
    }

    public void setTimeConstrains(Date timeConstrains) {
        this.timeConstrains = timeConstrains;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bank bank = (Bank) o;
        return Objects.equals(name, bank.name) && Objects.equals(country, bank.country) && type == bank.type && Objects.equals(depositor, bank.depositor) && Objects.equals(accountId, bank.accountId) && Objects.equals(amountOnDeposit, bank.amountOnDeposit) && Objects.equals(profitability, bank.profitability) && Objects.equals(timeConstrains, bank.timeConstrains);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, country, type, depositor, accountId, amountOnDeposit, profitability, timeConstrains);
    }

    @Override
    public String toString() {
        return "Bank{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", type=" + type +
                ", depositor='" + depositor + '\'' +
                ", accountId='" + accountId + '\'' +
                ", amountOnDeposit=" + amountOnDeposit +
                ", profitability=" + profitability +
                ", timeConstrains=" + timeConstrains +
                '}';
    }
}
