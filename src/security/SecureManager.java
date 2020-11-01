/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package security;

import entity.Buyer;
import entity.User;
import java.util.Scanner;
import tools.creaters.BuyerManager;
import tools.creaters.UserManager;
import tools.savers.BuyersStorageManager;
import tools.savers.UsersStorageManager;

/**
 *
 * @author Melnikov
 */
public class SecureManager {
private Scanner scanner = new Scanner(System.in);
private UserManager userManager = new UserManager();
private BuyerManager buyerManager = new BuyerManager();
private UsersStorageManager usersStorageManager = new UsersStorageManager();
private BuyersStorageManager buyersStorageManager = new BuyersStorageManager();

    public User checkInLogin(User[] users, Buyer[] buyers) {
        do{
            System.out.println("YOUR CHOISE: ");
            System.out.println("0. Close the program");
            System.out.println("1. Registration");
            System.out.println("2. Login to the system");
            System.out.print("Enter the task number: ");
            String task = scanner.nextLine();
            switch (task) {
                case "0":
                    System.out.println("bye Bye! :)");
                    System.exit(0);
                    break;
                case "1":
                    User user = userManager.createUser();
                    userManager.addUserToArray(user, users);
                    buyerManager.addBuyerToArray(user.getBuyer(), buyers);
                    buyersStorageManager.saveBuyersToFile(buyers);
                    usersStorageManager.saveUsersToFile(users);
                    break;
                case "2":
                    User checkInUser = userManager.getCheckInUser(users);
                    if(checkInUser == null) break;
                    return checkInUser;
                default:
                    System.out.println("No such action.");;
            }
        }while(true);
    }
    
}
