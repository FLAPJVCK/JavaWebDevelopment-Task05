package by.epamtc.vaskevichartsiom.task_xml.model;

import java.util.Objects;

public class Package {
    private String type;
    private int quantity;
    private float price;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Package aPackage = (Package) o;
        return quantity == aPackage.quantity && Float.compare(aPackage.price, price) == 0 && Objects.equals(type, aPackage.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, quantity, price);
    }

    @Override
    public String toString() {
        return "Package{" +
                "type='" + type + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
