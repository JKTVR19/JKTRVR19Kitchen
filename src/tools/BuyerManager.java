/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import entity.Buyer;
import java.util.Scanner;

/**
 *
 * @author Juri
 */
public class BuyerManager {
    public Buyer addBuyer (){
        Buyer  buyer = new Buyer ();
        System.out.println("---Register Buyer---");
        System.out.println("Set firstname: ");
        Scanner scanner = new Scanner(System.in);
        buyer.setFirstname(scanner.nextLine());
        System.out.println("Set lastname: ");
        buyer.setLastname(scanner.nextLine());
        System.out.println("Set phone: ");
        buyer.setPhone(scanner.nextLine());
        System.out.println("Set wallet(cash): ");
        buyer.setWallet(scanner.nextLine()); // was erroor: Ineger changed to String

        return buyer;
    }
}
