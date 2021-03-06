/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package security;

import entity.User;
import factory.FacadeFactory;
import java.util.Scanner;
import tools.manager.BuyerManager;
import tools.manager.UserManager;

/**
 *
 * @author JKTVR19Library
 */
public class SecureManager {
private Scanner scanner = new Scanner(System.in);
private UserManager userManager = new UserManager();
private BuyerManager buyerManager = new BuyerManager();
//private FileManager storageManager = new FileManager();

public static enum role {BUYER, MANAGER};

    public User checkInLogin() {
        do{
            System.out.println("Your choose: ");
            System.out.println("0. Close programm");
            System.out.println("1. Regisration");
            System.out.println("2. Login to the shop");
            System.out.print("Enter the task number: ");
            String task = scanner.nextLine();
            switch (task) {
                case "0":
                    System.out.println("Пока! :)");
                    System.exit(0);
                    break;
                case "1":
                    User user = userManager.createUser();
                    FacadeFactory.getUserFacade().create(user);
                    break;
                case "2":
                    User checkInUser = userManager.getCheckInUser();
                    if(checkInUser == null) break;
                    return checkInUser;
                default:
                    System.out.println("There is no such task.");;
            }
        }while(true);
    }
    
}
