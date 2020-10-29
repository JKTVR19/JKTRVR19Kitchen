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
        System.out.println("---Зарегистриролвать читателя---");
        System.out.println("Введите имя: ");
        Scanner scanner = new Scanner(System.in);
        buyer.setFirstname(scanner.nextLine());
        System.out.println("Введите фамилию: ");
        buyer.setLastname(scanner.nextLine());
        System.out.println("Введите телефон: ");
        buyer.setPhone(scanner.nextLine());

        return buyer;
    }
}
