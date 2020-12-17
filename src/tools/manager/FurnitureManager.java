/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.manager;

import entity.Furniture;
import entity.facade.FurnitureFacade;
import factory.FacadeFactory;
import java.util.List;
import java.util.Scanner;


/**
 *
 * @author Melnikov
 */
public class FurnitureManager {
    private FurnitureFacade furnitureFacade = FacadeFactory.getFurnitureFacade();

    public Furniture createFurniture() {
        Furniture furniture = new Furniture();
        System.out.println("--- Добавить мебель ---");
        System.out.println("Введите название:");
        Scanner scanner = new Scanner(System.in);
        furniture.setName(scanner.nextLine());
        System.out.println("Введите размеры:");
        furniture.setSize(scanner.nextLine());
        int numPublishedYear;
        do{
            System.out.println("Введите размеры:");
            String strPublichedYear = scanner.nextLine();
            try {
                numPublishedYear = Integer.parseInt(strPublichedYear);
                break;
            } catch (Exception e) {
                System.out.println("Вводите цифры!");
            }
        }while(true);
        furniture.setPublishedYear(numPublishedYear);
        furnitureFacade.create(furniture);
        return furniture;
    }
    
    public boolean printListFurnitures() {
        List<Furniture> listFurnitures = furnitureFacade.findAll();
        if(listFurnitures == null || listFurnitures.size() < 1){
            System.out.println("Мебели нет нет!");
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
