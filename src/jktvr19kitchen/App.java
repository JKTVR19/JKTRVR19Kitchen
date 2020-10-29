/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jktvr19kitchen;

import tools.FurnitureManager;
import tools.FurnituresStorageManager;
import entity.Buyer;
import entity.Furniture;
import entity.History;
import java.util.Scanner;
import tools.BuyerManager;
import tools.BuyersStorageManager;
import tools.UserCardManager;
//import static javafx.scene.input.KeyCode.R;

/**
 *
 * @author pupil
 */
public class App {
        
        private Scanner scanner = new Scanner(System.in);
        private Buyer[] buyers = new Buyer[10];
        private Furniture[] furnitures = new Furniture[10];
        private History[] histories = new History[10];
        
        public App() {
        BuyersStorageManager bsm = new BuyersStorageManager();
//        buyers = bsm.loadBuyersFromFile();
        Buyer[] loadedBuyers = bsm.loadBuyersFromFile();
        if(loadedBuyers != null){
            buyers = loadedBuyers;
        }
        FurnituresStorageManager fsm = new FurnituresStorageManager();
        Furniture[] loadedFurnitures = fsm.loadFurnituresFromFile();
        if(loadedFurnitures != null){
            furnitures = loadedFurnitures;
        }
    }
        
    public void run() {
        System.out.println("<<<   kitchen furniture store   >>>");
        boolean repeat = true;
        do {            
            
        
            System.out.println("=====================");
            System.out.println("0. ");
            System.out.println("----ACTIONS-----");
            System.out.println("1. Add kitchen furniture");
            System.out.println("2. List of kitchen furnitures");
            System.out.println("3. Add customer");
            System.out.println("4. Buyers list");
            System.out.println("5. Buyer buy goods (When buying goods from the buyer's wallet, deduct the cost of the goods)");
            System.out.println("6. ");
            System.out.println("7. Kitchen Furniture Sold List");
            
            System.out.println("Select an action");
            String action = scanner.nextLine();
            System.out.println("=============================");
            switch (action){
                case "0" :
                    System.out.println("---END of PROGRAMM---");
                    repeat = false;
                    break;
                case "1":
//                    System.out.println("---Add kitchen furniture---");
//                    Furniture furniture = new Furniture("Table", "white", "XL", 100);
//                    System.out.printf("Added furniture: "+furniture.getName());
//                    System.out.println(furniture.toString());
                    FurnitureManager furnitureManager = new FurnitureManager(); 
                    Furniture furniture = furnitureManager.addFurniture();
                    for (int i = 0; i < furnitures.length; i++) {
                        if(furnitures[i] == null){
                            furnitures[i] = furniture;
                            break;
                        }
                    }
                    FurnituresStorageManager furnituresStorageManager = new FurnituresStorageManager();
                    furnituresStorageManager.saveFurnituresToFile(furnitures);
                    
                    break;
                case "2":
                    System.out.println("---List of kitchen furnitures---");
                    break;
                case "3":
                    System.out.println("---Add buyer---");
//                    Buyer buyer = new Buyer("John", "Johnson", "123456789", 888);
//                    System.out.println(buyer.toString());
//                    buyers[] = buyer;
//                    Buyer buyer1 = new Buyer("Anton", "Antonov", "123456789", 999);
//                    buyers[1] = buyer1;
                    BuyerManager buyerManager = new BuyerManager(); 
                    Buyer buyer = buyerManager.addBuyer();
                    for (int i = 0; i < buyers.length; i++) {
                        if(buyers[i] == null){
                            buyers[i] = buyer;
                            break;
                        }
                    }
                    BuyersStorageManager buyersStorageManager = new BuyersStorageManager();
                    buyersStorageManager.saveBuyersToFile(buyers);
                    
                    break;
                case "4":
                    System.out.println("---Buyers list---");
                    int n = 0;
                    for (Buyer b : buyers) {
                        if(b != null){
                            System.out.println(n+1+". "+b.toString());
                            n++;
                        }
                    }
                    break;
                case "5":
                    System.out.println("---Buyer buy goods ---");
                    UserCardManager userCardManager = new UserCardManager();
                    History history = userCardManager.giveFurniture(furnitures, buyers);
                    for (int i = 0; i < histories.length; i++) {
                        if(histories[i] == null){
                            histories[i] = history;
                            break;
                        }
                    }
                    break;
                case "7":  
                    System.out.println("--- Kitchen Furniture Sold List ---");
                    n = 0;
                    for (History h : histories) {
                        if(h != null && h.getReturnDate() == null){
                            System.out.println(n+1+". "+h.toString());
                            n++;
                        }
                    }
                    break;

                default:
                    System.out.println("There is no such acction");;
                }
            }
        while (repeat);
    }
} 