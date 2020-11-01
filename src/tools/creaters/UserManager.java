/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.creaters;

import entity.Furniture;
import entity.Buyer;
import entity.User;
import java.util.Scanner;

/**
 *
 * @author Melnikov
 */
public class UserManager {
    private Scanner scanner = new Scanner(System.in);

    public User createUser() {
        BuyerManager buyerManager = new BuyerManager();
        Buyer buyer = buyerManager.createBuyer();
        User user = new User();
        System.out.println("--- ФAdd buyer ---");
        System.out.println("Buyers login:");
        user.setLogin(scanner.nextLine());
        System.out.println("Set password:");
        user.setPassword(scanner.nextLine());
        System.out.println("Set role:");
        user.setRole(scanner.nextLine());
        user.setBuyer(buyer);
        return user;
    }

    public void addUserToArray(User user, User[] users) {
        for (int i = 0; i < users.length; i++) {
            if(users[i] == null){
                users[i] = user;
                break;
            }
        }    
    }

    public void printListUsers(User[] users) {
        int j = 0;
        for (User u : users) {
            if(u != null){
                System.out.println(j+1+". "+u.toString());
                j++;
            }
        }
    }

    public User getCheckInUser(User[] users) {
        System.out.println("--- entrance to the system  ---");
        System.out.print("Login: ");
        String login = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();
        for (int i = 0; i < users.length; i++) {
            if(users[i] != null && users[i].getLogin().equals(login)){
                for (int j = 0; j < 3; j++) {
                   if(users[i].getPassword().equals(password)){
                       return users[i];
                   }else{
                       System.out.println("Try again.");
                       password = scanner.nextLine();
                   }
                }
                System.out.println("Davay Dosvidanija! I'm sorry to see you go :)");
                return null;
            }
        }
        return null;
    }
    
}
