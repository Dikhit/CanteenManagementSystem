package Models;

import java.util.UUID;

public class User {
    String id;
    String name;
    String email;
    int walletPrice;
    String password;
    String role;

    public User( String name, String email, int walletPrice, String password) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.email = email;
        this.walletPrice = walletPrice;
        this.password = password;
        this.role = "CUSTOMER";
    }

    public User(String id, String name, String email, int walletPrice, String password, String role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.walletPrice = walletPrice;
        this.password = password;
        this.role = role;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getWalletPrice() {
        return walletPrice;
    }

    public void setWalletPrice(int walletPrice) {
        this.walletPrice = walletPrice;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\n' +
                ", email='" + email + '\n' +
                ", walletPrice=" + walletPrice + '\n' +
                ", password='" + password + '\n' +
                ", role=" + role +
                '}';
    }
}
