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
        System.out.println("--- Добавить книгу ---");
        System.out.println("Введите название:");
        Scanner scanner = new Scanner(System.in);
        furniture.setName(scanner.nextLine());
        System.out.println("Введите автора:");
        furniture.setColor(scanner.nextLine());
        System.out.println("Введите год издания:");
        furniture.setSize(scanner.nextLine());
        System.out.println("Введите год издания:");
        furniture.setPrice(scanner.nextInt());
        return furniture;
    }
    
}
