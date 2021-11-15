package Templates;


import Models.User;
import Services.UserServices;

import java.util.Scanner;

public class UserTemplates {
    public static void updateProfileTemplate(User currentUser, Scanner userInput) {
        System.out.println(currentUser);
        System.out.println();
        System.out.println("What you want to update : ");
        boolean isDone = false;
        while (!isDone){
            System.out.println("1. Name \n2. Email \n3. Password \n4. Wallet Amount ");
            int choice = userInput.nextInt();
            userInput.nextLine();
            switch (choice){
                case 1:
                    System.out.println("Enter your new name !!");
                    String name = userInput.nextLine();
                    if (name.length() > 0){
                        currentUser.setName(name);
                    }
                    break;
                case 2:
                    System.out.println("Enter your new email !!");
                    String email = userInput.nextLine();
                    if(email.length() > 0){
                        currentUser.setEmail(email);
                    }
                    break;
                case 3:
                    System.out.println("Enter your new password !!");
                    String password = userInput.nextLine();
                    if (password.length() > 3){
                        currentUser.setPassword(password);
                    }
                    else {
                        System.out.println("password length min 3");
                    }
                    break;
                case 4:
                    System.out.println("Enter your amount !!");
                    int walletPrice = userInput.nextInt();
                    if(walletPrice > 0){
                        currentUser.setWalletPrice(
                                currentUser.getWalletPrice() + walletPrice
                        );
                    }
                    break;
                default:
                    isDone = true;
            }
        }
        currentUser = UserServices.updateProfile(currentUser);
        if(currentUser != null){
            System.out.println(currentUser + "\n");
            System.out.println("Update Successfully");
        }
        else{
            System.out.println("Please try again later !!");
        }
    }
}
