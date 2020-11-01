/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.creaters;

import entity.Furniture;
import entity.History;
import entity.Buyer;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 *
 * @author Melnikov
 */
public class UserCardManager {
    private Scanner scanner = new Scanner(System.in);
    private FurnitureManager furnitureManager = new FurnitureManager();
    private BuyerManager buyerManager = new BuyerManager();

    public History checkOutFurniture(Furniture[] furnitures, Buyer[] buyers) {
        System.out.println("--- List kitchen furniture ---");
        int furnitureNumber;
        do{
            furnitureManager.printListFurnitures(furnitures);
            System.out.print("Choose furniture number: ");    
            String furnitureNumberStr = scanner.nextLine();
            try {
                furnitureNumber = Integer.parseInt(furnitureNumberStr);
                if(furnitureNumber < 1 && furnitureNumber >= furnitures.length){
                    throw new Exception();
                }
                break;
            } catch (Exception e) {
                System.out.println("Choose furniture number frome list above");
            }
        }while(true);
        Furniture furniture = furnitures[furnitureNumber - 1];
        int buyerNumber;
        do{
            System.out.println("--- Buyers list---");
            buyerManager.printListBuyers(buyers);
            System.out.print("Chose number of buyer: ");    
            String buyerNumberStr = scanner.nextLine();
            try {
                buyerNumber = Integer.parseInt(buyerNumberStr);
                if(buyerNumber < 1 && buyerNumber >= buyers.length){
                    throw new Exception();
                }
                break;
            } catch (Exception e) {
                System.out.println("Choose buyer number from list above");
            }
        }while(true);
        Buyer buyer = buyers[buyerNumber - 1];
//------------emptying the buyers wallet----
        
        int wallet =buyer.getWallet()- furniture.getPrice();        
        buyer.setWallet(wallet);          
//-------------------------------------------
        Calendar calendar = new GregorianCalendar();
        return new History(furniture, buyer, calendar.getTime(), null);
    }

    public void returnFurniture(History[] histories) {
        System.out.println("Solded furnitures:");
        this.printListReadFurnitures(histories);
        System.out.println("Select the furniture number to return: ");
        int historyNumber = scanner.nextInt();
        histories[historyNumber - 1].setReturnDate(new GregorianCalendar().getTime());
    }

    public void addHistoryToArray(History history, History[] histories) {
        for (int i = 0; i < histories.length; i++) {
            if(histories[i] == null){
                histories[i] = history;
                break;
            }
        } 
    }

    public void printListReadFurnitures(History[] histories) {
        boolean notReadFurnitures = true;
        for (int i = 0;i<histories.length;i++) {
            if(histories[i] != null && histories[i].getReturnDate() == null){
                System.out.printf("%d. Furbiture \"%s\" bought %s %s%n"
                        ,i+1
                        ,histories[i].getFurniture().getName()
                        ,histories[i].getBuyer().getFirstname()
                        ,histories[i].getBuyer().getLastname()
                );
                notReadFurnitures = false;
            }
        }
        if(notReadFurnitures){
            System.out.println("There is no sold furniture");
        }
    }
}
