/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.manager;

import entity.Buyer;
import entity.facade.BuyerrFacade;
import factory.FacadeFactory;
import java.util.List;
import java.util.Scanner;


/**
 *
 * @author JKTVR19Library
 */
public class BuyerManager {
    
    private BuyerrFacade buyerFacade = FacadeFactory.getBuyerFacade();

    public Buyer createBuyer() {
        Buyer buyer = new Buyer();
        System.out.println("--- Buyer regisration ---");
        System.out.println("Enter first name:");
        Scanner scanner = new Scanner(System.in);
        buyer.setFirstname(scanner.nextLine());
        System.out.println("Enter last name:");
        buyer.setLastname(scanner.nextLine());
        System.out.println("Enter phone:");
        buyer.setPhone(scanner.nextLine());
//        System.out.println("Enter wallet:");
//        buyer.setWallet(scanner.nextLine());
        //-------------------
        int numWallet;
        do{
            System.out.println("Enter wallet cash");
            String strWallet = scanner.nextLine();
            try {
                numWallet = Integer.parseInt(strWallet);
                break;
            } catch (Exception e) {
                System.out.println("Enter only numbers!");
            }
        }while(true);
        buyer.setWallet(numWallet);
//        furnitureFacade.create(furniture);
//        return furniture;
        //--------------*-----
        buyerFacade.create(buyer);
        return buyer;
    }

    public void printListBuyers() {
        List<Buyer> listBuyers = buyerFacade.findAll();
        if(listBuyers == null){
            System.out.println("No buyers");
            return;
        }
        for (Buyer r : listBuyers) {
            if(r != null){
                System.out.println(r.getId()+". "+r.toString());
            }
        }
    }
    
}
