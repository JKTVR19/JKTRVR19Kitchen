/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.creaters;

import entity.Furniture;
import java.util.Scanner;

/**
 *
 * @author Melnikov
 */
public class FurnitureManager {

    public Furniture createFurniture() {
        Furniture furniture = new Furniture();
        System.out.println("---Add kitchen furniture---");
        System.out.println("Enter the title (name):");
        Scanner scanner = new Scanner(System.in);
        furniture.setName(scanner.nextLine());
        System.out.println("Set color:");
        furniture.setColor(scanner.nextLine());
        System.out.println("Set size:");
        furniture.setSize(scanner.nextLine());
        System.out.println("Set price:");
        furniture.setPrice(scanner.nextInt());
        return furniture;
    }

    public void addFurnitureToArray(Furniture furniture, Furniture[] furnitures) {
        for (int i = 0; i < furnitures.length; i++) {
            if(furnitures[i] == null){
                furnitures[i] = furniture;
                break;
            }
        }    
    }

    public void printListFurnitures(Furniture[] furnitures) {
        int j = 0;
        for (Furniture b : furnitures) {
            if(b != null){
                System.out.println(j+1+". "+b.toString());
                j++;
            }
        }
    }
    
}
