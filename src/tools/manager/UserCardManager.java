/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.manager;

import entity.Furniture;
import entity.History;
import entity.Buyer;
import entity.facade.FurnitureFacade;
import entity.facade.HistoryFacade;
import entity.facade.BuyerFacade;
import factory.FacadeFactory;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;
import jktvr19furniture.App;
import security.SecureManager;

/**
 *
 * @author Melnikov
 */
public class UserCardManager {
    private Scanner scanner = new Scanner(System.in);
    private FurnitureManager furnitureManager = new FurnitureManager();
    private BuyerManager readerManager = new BuyerManager();
    private FurnitureFacade furnitureFacade = FacadeFactory.getBookFacade();
    private BuyerFacade buyerFacade = FacadeFactory.getBuyerFacade();
    private HistoryFacade historyFacade = FacadeFactory.getHistoryFacade();


    public void checkOutFurniture() {
        System.out.println("--- Список мебели ---");
        Long furnitureNumber;
        do{
            if(!furnitureManager.printListFurnitures()){
                return;
            };
            System.out.print("Выберите номер мебели: ");    
            String furnitureNumberStr = scanner.nextLine();
            try {
                furnitureNumber = Long.parseLong(furnitureNumberStr);
                break;
            } catch (Exception e) {
                System.out.println("Выберите номер из списка.");
            }
        }while(true);
        Furniture furniture = furnitureFacade.find(furnitureNumber);
        Buyer buyer = null;
        if(SecureManager.role.MANAGER.toString().equals(App.loggedInUser.getRole())){
            Long buyerNumber;
            do{
                System.out.println("--- Список читателей ---");
                readerManager.printListBuyers();
                System.out.print("Выберите номер читателя: ");    
                String buyerNumberStr = scanner.nextLine();
                try {
                    buyerNumber = Long.parseLong(buyerNumberStr);
                    break;
                } catch (Exception e) {
                    System.out.println("Выберите номер из указанного списка");
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
        System.out.println("Полученная мебель:");
        if(this.printListReadFurnitures()){
            Long historyNumber;
            do{    
               System.out.println("Выберите номер возвращаемой мебели: ");
                String historyNumberStr = scanner.nextLine();
                try {
                    historyNumber = Long.parseLong(historyNumberStr);
                    break;
                } catch (Exception e) {
                    System.out.println("Выберите номер из указанного выше списка");
                }
            }while(true);
            
            History history = historyFacade.find(historyNumber);
            history.setReturnDate(new GregorianCalendar().getTime());
            historyFacade.edit(history);
        }
    }

   

    public boolean printListReadFurnitures() {
        
        if(SecureManager.role.MANAGER.toString().equals(App.loggedInUser.getRole())){
            List<History> listHistories = historyFacade.findAll(true);
            if(listHistories == null){
                System.out.println("Полученной мебели нет");
                return false;
            }
            for (int i = 0;i<listHistories.size();i++) {
                System.out.printf("%d. Мебель \"%s\" получил %s %s%n"
                        ,listHistories.get(i).getId()
                        ,listHistories.get(i).getFurniture().getName()
                        ,listHistories.get(i).getBuyer().getFirstname()
                        ,listHistories.get(i).getBuyer().getLastname()
                );
            }
        }else if(SecureManager.role.BUYER.toString().equals(App.loggedInUser.getRole())){
            List<History> listHistories = historyFacade.findAll(App.loggedInUser.getBuyer());
            if(listHistories == null){
                System.out.println("Поученной мебели нет");
                return false;
            }
            for (int i = 0;i<listHistories.size();i++) {
                System.out.printf("%d. Мебель \"%s\" получил %s %s%n"
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
