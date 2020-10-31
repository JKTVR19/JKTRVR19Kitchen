/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import entity.Furniture;
import java.util.Scanner;

/**
 *
 * @author Juri
 */
public class FurnitureManager {
    public Furniture addFurniture() {
        Furniture furniture = new Furniture();
        System.out.println("---Add Furniture---");
        System.out.println("Set name:");
        Scanner scanner = new Scanner(System.in);
        furniture.setName(scanner.nextLine());
        System.out.println("Set color:");
        furniture.setColor(scanner.nextLine());
        System.out.println("Set size:");
        furniture.setSize(scanner.nextLine());
        System.out.println("Set price:");
        int cash = 0;
        do { 
            String cashStr = scanner.nextLine(); 
            try {
                cash = Integer.parseInt(cashStr);
                break;
            } catch (Exception e) {
                System.out.println("Set number");
            }                             
        } while (true);
        furniture.setPrice(cash);
        return furniture;
    }
    
}
