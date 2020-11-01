/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jktvrkitchen;

import tools.savers.BuyersStorageManager;
import tools.creaters.BuyerManager;
import entity.Buyer;
import entity.Furniture;
import entity.History;
import entity.User;
import java.util.Scanner;
import security.SecureManager;
import tools.creaters.FurnitureManager;
import tools.savers.FurnituresStorageManager;
import tools.savers.HistoriesStorageManager;
import tools.creaters.UserCardManager;


/**
 *
 * @author Melnikov
 */
public class App {
    private Scanner scanner = new Scanner(System.in);
    
    private Buyer[] buyers = new Buyer[10];
    private Furniture[] furnitures = new Furniture[10];
    private History[] histories = new History[10];
    private User[] users = new User[10];

    private FurnitureManager furnitureManager = new FurnitureManager(); 
    private BuyerManager buyerManager = new BuyerManager(); 
    private UserCardManager userCardManager = new UserCardManager();
    
    private BuyersStorageManager buyersStorageManager = new BuyersStorageManager();
    private FurnituresStorageManager furnituresStorageManager = new FurnituresStorageManager();
    private HistoriesStorageManager historiesStorageManager = new HistoriesStorageManager();
    
    private User loggedInUser;

    public App() {
        Buyer[] loadedBuyers = buyersStorageManager.loadBuyersFromFile();
        if(loadedBuyers != null){
            buyers = loadedBuyers;
        }
        Furniture[] loadedFurnitures = furnituresStorageManager.loadFurnituresFromFile();
        if(loadedFurnitures != null){
           furnitures = loadedFurnitures;
        }
        History[] loaderHistories = historiesStorageManager.loadHistoriesFromFile();
        if(loaderHistories != null){
            histories = loaderHistories;
        }
    }

    public void run() {
        System.out.println("<<<   KITCHEN FURNITURE STORE   >>>");
        SecureManager secureManager = new SecureManager();
        this.loggedInUser = secureManager.checkInLogin(users,buyers);
        boolean repeat = true;
        do{
            System.out.println("=============================");
            System.out.println("ACTIONS:");
            System.out.println("0. Exit the programm");
            System.out.println("1. Add kitchen furnitur");
            System.out.println("2. List of kitchen furnitures");
            System.out.println("3. Add customer");
            System.out.println("4. Buyers list");
            System.out.println("5. Buyer buy goods (When buying goods from the buyer's wallet, deduct the cost of the goods)");
            System.out.println("6. Returne furniture");
            System.out.println("7. Kitchen Furniture Sold List");
            System.out.print("Select an action: _ ");
            String task = scanner.nextLine();
            System.out.println("=============================");
            switch (task) {
                case "0":
                    System.out.println("---END of PROGRAMM----");
                    repeat = false;
                    break;
                case "1":
                    System.out.println("--- Add kitchen furnitur ---");
                    Furniture furniture = furnitureManager.createFurniture();
                    furnitureManager.addFurnitureToArray(furniture,furnitures);
                    furnituresStorageManager.saveFurnituresToFile(furnitures);
                    break;
                case "2":
                    System.out.println("--- List of kitchen furnitures ---");
                    furnitureManager.printListFurnitures(furnitures);
                    break;
                case "3":
                    System.out.println("--- Add customer ---");
                    Buyer buyer = buyerManager.createBuyer();
                    buyerManager.addBuyerToArray(buyer,buyers);
                    buyersStorageManager.saveBuyersToFile(buyers);
                    break;
                case "4":
                    System.out.println("--- Buyers list ---");
                    buyerManager.printListBuyers(buyers);
                    break;
                case "5":
                    System.out.println("--- Buyer buy goods ---");
                    History history = userCardManager.checkOutFurniture(furnitures, buyers);
                    userCardManager.addHistoryToArray(history,histories);
                    historiesStorageManager.saveHistoriesToFile(histories);
                    break;
                case "6":
                    System.out.println("--- Returne furniture ---");
                    userCardManager.returnFurniture(histories);
                    historiesStorageManager.saveHistoriesToFile(histories);
                    break;
                case "7":  
                    System.out.println("--- Kitchen Furniture Sold List ---");
                    userCardManager.printListReadFurnitures(histories);
                    break;
                default:
                    System.out.println("There is no such acction");;
            }
        }while(repeat);
    }

}
