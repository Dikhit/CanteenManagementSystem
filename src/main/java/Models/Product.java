package Models;

import java.util.UUID;

public class Product {
    String id;
    String name;
    int price;
    String description;
    String vendorID;
    String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Product(String name, int price, String description, String vendorID) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.price = price;
        this.description = description;
        this.vendorID = vendorID;
    }

    public Product(String id, String name, int price, String description, String vendorID, String date) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.vendorID = vendorID;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVendorID() {
        return vendorID;
    }

    public void setVendorID(String vendorID) {
        this.vendorID = vendorID;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", vendorID='" + vendorID + '\'' +
                '}';
    }
}
