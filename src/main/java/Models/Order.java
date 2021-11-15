package Models;

import java.util.UUID;

public class Order {
    String id;
    String customerID;
    String productID;
    int quantity;
    String date;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Order(String id, String customerID, String productID, int quantity, String date) {
        this.id = id;
        this.customerID = customerID;
        this.productID = productID;
        this.date = date;
        this.quantity = quantity;
    }

    public Order(String customerID, String productID, int quantity) {
        this.id = UUID.randomUUID().toString();
        this.customerID = customerID;
        this.productID = productID;
        this.quantity = quantity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", customerID='" + customerID + '\'' +
                ", productID='" + productID + '\'' +
                ", quantity=" + quantity +
                ", date='" + date + '\'' +
                '}';
    }
}
