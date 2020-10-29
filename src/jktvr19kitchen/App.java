/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jktvr19kitchen;

import entity.Buyer;
import entity.Furniture;
import java.util.Scanner;
import tools.BuyerManager;
import tools.BuyersStorageManager;
import static javafx.scene.input.KeyCode.R;

/**
 *
 * @author pupil
 */
public class App {
        
        private Scanner scanner = new Scanner(System.in);
        private Buyer[] buyers = new Buyer[10];
        
        public App() {
        BuyersStorageManager bsm = new BuyersStorageManager();
        buyers = bsm.loadBuyersFromFile();
    }
        
    public void run() {
        System.out.println("<<<<<<<<kitchen furniture store>>>>>>>>>");
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
            System.out.println("6. ");
            
            System.out.println("Select an action");
            String action = scanner.nextLine();
            System.out.println("=============================");
            switch (action){
                case "0" :
                    System.out.println("---END of PROGRAMM---");
                    repeat = false;
                    break;
                case "1":
                    System.out.println("---Add kitchen furniture---");
                    Furniture furniture = new Furniture("Table", "white", "XL", 100);
                    System.out.printf("Added furniture: "+furniture.getName());
                    System.out.println(furniture.toString());
                    
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
                    int i = 0;
                    for (Buyer b : buyers) {
                        if(b != null){
                            System.out.println(i+1+". "+b.toString());
                            i++;
                        }
                    }
                    break;
                case "5":
                    System.out.println("---Buyer buy goods ---");
                    break;
////                case "6":
////                    System.out.println("--- Вернуть книгу ---");
//                    break;
                default:
                    System.out.println("Нет такой задачи");;
                }
            }
        while (repeat);
    }
} 