/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.creaters;

import entity.Buyer;
import java.util.Scanner;

/**
 *
 * @author Melnikov
 */
public class BuyerManager {

    public Buyer createBuyer() {
        Buyer buyer = new Buyer();
        System.out.println("--- Buyer registration ---");
        System.out.println("Set Firstname:");
        Scanner scanner = new Scanner(System.in);
        buyer.setFirstname(scanner.nextLine());
        System.out.println("Set Lastname:");
        buyer.setLastname(scanner.nextLine());
        System.out.println("Set Phone:");
        buyer.setPhone(scanner.nextLine());
        System.out.println("Set Wallet:");
        buyer.setWallet(scanner.nextInt());
        return buyer;
    }

    public void addBuyerToArray(Buyer buyer, Buyer[] buyers) {
        for (int i = 0; i < buyers.length; i++) {
            if(buyers[i] == null){
                buyers[i] = buyer;
                break;
            }
        } 
    }

    public void printListBuyers(Buyer[] buyers) {
        int n = 0;
        for (Buyer r : buyers) {
            if(r != null){
                System.out.println(n+1+". "+r.toString());
                n++;
            }
        }
    }
    
}
