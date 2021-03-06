/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import entity.Furniture;
import entity.User;
import java.util.Scanner;
import tools.manager.FurniteManager;
import tools.manager.BuyerManager;
import tools.manager.UserCardManager;
import tools.manager.UserManager;



/**
 *
 * @author JKTVR19Library
 */
public class UserInterface {
    private Scanner scanner = new Scanner(System.in);
    private FurniteManager furnitureManager = new FurniteManager(); 
    private BuyerManager readerManager = new BuyerManager(); 
    private UserCardManager userCardManager = new UserCardManager();
    
    public void printManagerUI(){
        boolean repeat = true;
        do{
            System.out.println("=============================");
            System.out.println("Choose:");
            System.out.println("0. Exit the programm");
            System.out.println("1. Add furniture");
            System.out.println("2. Furnitures list");
            System.out.println("3. Add buyer");
            System.out.println("4. Buyers list");
            System.out.println("5. Sell furniture");
            System.out.println("6. Sell furniture");
            System.out.println("7. List of solded furniture");
            System.out.print("Choose task: ");
            String task = scanner.nextLine();
            System.out.println("=============================");
            switch (task) {
                case "0":
                    System.out.println("--- Exit the programm ---");
                    repeat = false;
                    break;
                case "1":
                    System.out.println("--- Add furniture ---");
                    Furniture furniture = furnitureManager.createFurniture();
                    break;
                case "2":
                    System.out.println("--- Furnitures list ---");
                    furnitureManager.printListFurnitures();
                    break;
                case "3":
                    System.out.println("--- Add buyer ---");
                    UserManager userManager = new UserManager();
                    User user = userManager.createUser();
                    break;
                case "4":
                    System.out.println("--- Buyers list ---");
                    readerManager.printListBuyers();
                    break;
                case "5":
                    System.out.println("--- Sell furniture ---");
                    userCardManager.checkOutFurniture();
                    break;
                case "6":
                    System.out.println("--- Returne furniture ---");
                    userCardManager.returnFurniture();
                    break;
                case "7":  
                    System.out.println("--- List of solded furnitures ---");
                    userCardManager.printListReadFurnitures();
                    break;
                default:
                    System.out.println("No such task");;
            }
        }while(repeat);
    }
    public void printBuyerUI(){
        boolean repeat = true;
        do{
            System.out.println("=============================");
            System.out.println("Tasks:");
            System.out.println("0. Exit programm");
            System.out.println("1. List furnitures");
            System.out.println("2. Buy furniture");
            System.out.println("3. Returne furniture");
            System.out.println("4. List of soded furniture");
            System.out.print("Chose task: ");
            String task = scanner.nextLine();
            System.out.println("=============================");
            switch (task) {
                case "0":
                    System.out.println("--- End og programm ---");
                    repeat = false;
                    break;
                case "1":
                    System.out.println("--- List of furniture ---");
                    furnitureManager.printListFurnitures();
                    break;
                case "2":
                    System.out.println("--- Buy furniture ---");
                    userCardManager.checkOutFurniture();
                    break;
                case "3":
                    System.out.println("--- Returne furniture---");
                    userCardManager.returnFurniture();
                    break;
                case "4":  
                    System.out.println("--- List og solded furniture ---");
                    userCardManager.printListReadFurnitures();
                    break;
                default:
                    System.out.println("Нет такой задачи");;
            }
        }while(repeat);
    }
}
