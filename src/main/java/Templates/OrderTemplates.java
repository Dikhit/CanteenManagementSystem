package Templates;


import Models.Order;
import Models.Product;
import Models.User;
import Services.ProductsServices;
import Services.UserServices;

import java.util.ArrayList;
import java.util.Scanner;

public class OrderTemplates {

    public static Order newOrderTemplate(User currentUser) {
        ArrayList<Product> products = new ArrayList<>();
        Scanner userInput = new Scanner(System.in);

        System.out.println("New Order ...");
        products = ProductsServices.getAllProducts();
        for (int i = 0; i < products.size(); i++) {
            System.out.println(i + "-->");
            System.out.println(products.get(i).getName());
            System.out.println(products.get(i).getPrice());
            System.out.println(products.get(i).getDescription());
            System.out.println(products.get(i).getDate());
            System.out.println("\n");
        }
        int choice = userInput.nextInt();
        userInput.nextLine();
        String buyer = currentUser.getId();
        Product product = products.get(choice);

        System.out.println("Enter the quantity : ");
        int quantity = userInput.nextInt();
        if(currentUser.getWalletPrice() >= product.getPrice() * quantity){
            Order order = new Order(buyer, product.getId(), quantity);
            currentUser.setWalletPrice(
                    currentUser.getWalletPrice() - product.getPrice() * quantity
            );
            UserServices.updateProfile(currentUser);
            return order;
        }
        else{
            System.out.println("Not Enough Balance !! Recharge Your Wallet !!");
        }
        return null;
    }
}
