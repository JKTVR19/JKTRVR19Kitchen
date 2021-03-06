/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.manager;

import entity.Furniture;
import entity.History;
import entity.Buyer;
import entity.facade.FurniteFacade;
import entity.facade.HistoryFacade;
import entity.facade.BuyerrFacade;
import factory.FacadeFactory;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;
import jktvr19library.App;
import security.SecureManager;

/**
 *
 * @author JKTVR19Library
 */
public class UserCardManager {
    private Scanner scanner = new Scanner(System.in);
    private FurniteManager furnitureManager = new FurniteManager();
    private BuyerManager buyerManager = new BuyerManager();
    private FurniteFacade furnitureFacade = FacadeFactory.getFurnitureFacade();
    private BuyerrFacade buyerFacade = FacadeFactory.getBuyerFacade();
    private HistoryFacade historyFacade = FacadeFactory.getHistoryFacade();


    public void checkOutFurniture() {
        System.out.println("---List of furnitues---");
        Long furnitureNumber;
        do{
            if(!furnitureManager.printListFurnitures()){
                return;
            };
            System.out.print("Enter furnire number: ");    
            String furnitureNumberStr = scanner.nextLine();
            try {
                furnitureNumber = Long.parseLong(furnitureNumberStr);
                break;
            } catch (Exception e) {
                System.out.println("Choose number from list.");
            }
        }while(true);
        Furniture furniture = furnitureFacade.find(furnitureNumber);
        Buyer buyer = null;
        if(SecureManager.role.MANAGER.toString().equals(App.loggedInUser.getRole())){
            Long buyerNumber;
            do{
                System.out.println("--- Buyers list ---");
                buyerManager.printListBuyers();
                System.out.print("Choose buyers number: ");    
                String buyerNumberStr = scanner.nextLine();
                try {
                    buyerNumber = Long.parseLong(buyerNumberStr);
                    break;
                } catch (Exception e) {
                    System.out.println("Choose number from the list above");
                }
            }while(true);
            buyer = buyerFacade.find(buyerNumber);
        }else if(SecureManager.role.BUYER.toString().equals(App.loggedInUser.getRole())){
            buyer = App.loggedInUser.getBuyer();
        }
        Calendar calendar = new GregorianCalendar();
        History history = new History(furniture, buyer, calendar.getTime(), null);
        historyFacade.create(history);
    }

    public void returnFurniture() {
        System.out.println("Solded furniyures:");
        if(this.printListReadFurnitures()){
            Long historyNumber;
            do{    
               System.out.println("Choose number of reterned furniture: ");
                String historyNumberStr = scanner.nextLine();
                try {
                    historyNumber = Long.parseLong(historyNumberStr);
                    break;
                } catch (Exception e) {
                    System.out.println("Choose number from thr list above");
                }
            }while(true);
        //------------emptying the buyers wallet----
        Buyer buyer = new Buyer();
        Furniture furniture = new Furniture();
//        BuyerrFacade buyerFacade1 = FacadeFactory.setBuyerFacade();
            int wallet =buyer.getWallet()- furniture.getPrice();        
             buyer.setWallet(wallet); 
//             buyerFacade.create();
        //-------------------------------------------------
            History history = historyFacade.find(historyNumber);
            history.setReturnDate(new GregorianCalendar().getTime());
            historyFacade.edit(history);
        }
    }

   

    public boolean printListReadFurnitures() {
        
        if(SecureManager.role.MANAGER.toString().equals(App.loggedInUser.getRole())){
            List<History> listHistories = historyFacade.findAll(true);
            if(listHistories == null){
                System.out.println("No solded fyrnitures");
                return false;
            }
            for (int i = 0;i<listHistories.size();i++) {
                System.out.printf("%d. Furniture \"%s\" bought %s %s%n"
                        ,listHistories.get(i).getId()
                        ,listHistories.get(i).getFurniture().getName()
                        ,listHistories.get(i).getBuyer().getFirstname()
                        ,listHistories.get(i).getBuyer().getLastname()
                );
            }
        }else if(SecureManager.role.BUYER.toString().equals(App.loggedInUser.getRole())){
            List<History> listHistories = historyFacade.findAll(App.loggedInUser.getBuyer());
            if(listHistories == null){
                System.out.println("No solded fyrnitures");
                return false;
            }
            for (int i = 0;i<listHistories.size();i++) {
                System.out.printf("%d. Furniture \"%s\" bought %s %s%n"
                        ,listHistories.get(i).getId()
                        ,listHistories.get(i).getFurniture().getName()
                        ,listHistories.get(i).getBuyer().getFirstname()
                        ,listHistories.get(i).getBuyer().getLastname()
                );
            }
        }
        return true;
    }
}
