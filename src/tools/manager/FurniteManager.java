/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.manager;

import entity.Furniture;
import entity.facade.FurniteFacade;
import factory.FacadeFactory;
import java.util.List;
import java.util.Scanner;


/**
 *
 * @author JKTVR19Library
 */
public class FurniteManager {
    private FurniteFacade furnitureFacade = FacadeFactory.getFurnitureFacade();

    public Furniture createFurniture() {
        Furniture furniture = new Furniture();
        System.out.println("---Add furniyure ---");
        System.out.println("Enter name:");
        Scanner scanner = new Scanner(System.in);
        furniture.setName(scanner.nextLine());
        System.out.println("Enter color:");
        furniture.setColor(scanner.nextLine());
        System.out.println("Enter size:");
        furniture.setSize(scanner.nextLine());
        int numPrice;
        do{
            System.out.println("Enter price");
            String strPrice = scanner.nextLine();
            try {
                numPrice = Integer.parseInt(strPrice);
                break;
            } catch (Exception e) {
                System.out.println("Enter only numbers!");
            }
        }while(true);
        furniture.setPrice(numPrice);
        furnitureFacade.create(furniture);
        return furniture;
    }
    
    public boolean printListFurnitures() {
        List<Furniture> listFurnitures = furnitureFacade.findAll();
        if(listFurnitures == null || listFurnitures.size() < 1){
            System.out.println("No furnitures!");
            return false;
        }
        for (Furniture b : listFurnitures) {
            if(b != null){
                System.out.println(b.getId()+". "+b.toString());
            }
        }
        return true;
    }
    
}
