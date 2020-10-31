/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.creaters;

import entity.Buyer;
import entity.Furniture;
import entity.History;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 *
 * @author Juri
 */
public class UserCardManager {
    public History giveFurniture(Furniture[] furnitures, Buyer[] buyers) {
//        History history = null;
        History history = new History();
        System.out.println("--- List of Buyers ---");
        int n = 0;
        for (Buyer b : buyers) {
            if(b != null){
                System.out.println(n+1+". "+b.toString());
                n++;
            }
        }
         System.out.print("Choose a buyer number: ");    
         Scanner scanner = new Scanner(System.in);
         int buyerNumber = scanner.nextInt();
         scanner.nextLine();// carrige returne after Int
         Buyer buyer = buyers[buyerNumber - 1];
         System.out.println("--- List of furniture ---");
                    int j = 0;
                    for (Furniture f : furnitures) {
                        if(f != null){
                            System.out.println(j+1+". "+f.toString());
                            j++;
                        }
                    }

         System.out.print("Choose a furniture number: ");    
         int furnitureNumber = scanner.nextInt();
         Furniture furniture = furnitures[furnitureNumber - 1];
         Calendar calendar = new GregorianCalendar();
         
        //------------emptying the buyers wallet----
        
        int wallet =buyer.getWallet()- furniture.getPrice();        
        buyer.setWallet(wallet);          
        //-----------
        
//         history.setFurniture(furniture);
//         history.setBuyer(buyer);
//         history.setTakeOnDate(calendar.getTime());
//        return history;
        return new History(furniture, buyer, calendar.getTime(), null);
    }
    
}
