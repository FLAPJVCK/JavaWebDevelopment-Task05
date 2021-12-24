package by.epamtc.vaskevichartsiom.task_xml.model;

import java.util.Objects;

public class Dosage {
    private int amount;
    private int period;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dosage dosage = (Dosage) o;
        return amount == dosage.amount && period == dosage.period;
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, period);
    }

    @Override
    public String toString() {
        return "Dosage{" +
                "amount=" + amount +
                ", period=" + period +
                '}';
    }
}
