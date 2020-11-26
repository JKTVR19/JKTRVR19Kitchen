/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.manager;

import entity.Buyer;
import entity.facade.BuyerFacade;
import factory.FacadeFactory;
import java.util.List;
import java.util.Scanner;


/**
 *
 * @author Melnikov
 */
public class BuyerManager {
    
    private BuyerFacade buyerFacade = FacadeFactory.getBuyerFacade();

    public Buyer createBuyer() {
        Buyer buyer = new Buyer();
        System.out.println("--- Зарегистрировать покупателя ---");
        System.out.println("Введите имя:");
        Scanner scanner = new Scanner(System.in);
        buyer.setFirstname(scanner.nextLine());
        System.out.println("Введите фамилию:");
        buyer.setLastname(scanner.nextLine());
        System.out.println("Введите телефон:");
        buyer.setPhone(scanner.nextLine());
        buyerFacade.create(buyer);
        return buyer;
    }

    public void printListBuyers() {
        List<Buyer> listBuyers = buyerFacade.findAll();
        if(listBuyers == null){
            System.out.println("Нет покупателей");
            return;
        }
        for (Buyer r : listBuyers) {
            if(r != null){
                System.out.println(r.getId()+". "+r.toString());
            }
        }
    }
    
}
