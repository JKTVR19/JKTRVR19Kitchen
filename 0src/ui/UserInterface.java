/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import entity.Furniture;
import entity.User;
import java.util.Scanner;
import tools.manager.FurnitureManager;
import tools.manager.BuyerManager;
import tools.manager.UserCardManager;
import tools.manager.UserManager;



/**
 *
 * @author Melnikov
 */
public class UserInterface {
    private Scanner scanner = new Scanner(System.in);
    private FurnitureManager furnitureManager = new FurnitureManager(); 
    private BuyerManager buyerManager = new BuyerManager(); 
    private UserCardManager userCardManager = new UserCardManager();
    
    public void printManagerUI(){
        boolean repeat = true;
        do{
            System.out.println("=============================");
            System.out.println("Задачи:");
            System.out.println("0. Выйти из программы");
            System.out.println("1. Добавить мебель");
            System.out.println("2. Список мебели");
            System.out.println("3. Добавить покупателя");
            System.out.println("4. Список покупателей");
            System.out.println("5. Выдать мебель");
            System.out.println("6. Вернуть мебель");
            System.out.println("7. Список выданной мебели");
            System.out.print("Выберите задачу: ");
            String task = scanner.nextLine();
            System.out.println("=============================");
            switch (task) {
                case "0":
                    System.out.println("--- конец программы ---");
                    repeat = false;
                    break;
                case "1":
                    System.out.println("--- Добавить мебель ---");
                    Furniture furniture = furnitureManager.createFurniture();
                    break;
                case "2":
                    System.out.println("--- Список мебели ---");
                    furnitureManager.printListFurnitures();
                    break;
                case "3":
                    System.out.println("--- Добавить покупателя ---");
                    UserManager userManager = new UserManager();
                    User user = userManager.createUser();
                    break;
                case "4":
                    System.out.println("--- Список покупателей ---");
                    buyerManager.printListBuyers();
                    break;
                case "5":
                    System.out.println("--- Выдать мебель ---");
                    userCardManager.checkOutFurniture();
                    break;
                case "6":
                    System.out.println("--- Вернуть мебель ---");
                    userCardManager.returnFurniture();
                    break;
                case "7":  
                    System.out.println("--- Список выданной мебели ---");
                    userCardManager.printListReadFurnitures();
                    break;
                default:
                    System.out.println("Нет такой задачи");;
            }
        }while(repeat);
    }
    public void printBuyerUI(){
        boolean repeat = true;
        do{
            System.out.println("=============================");
            System.out.println("Задачи:");
            System.out.println("0. Выйти из программы");
            System.out.println("1. Список мебели");
            System.out.println("2. Получить мебель");
            System.out.println("3. Сдать мебель");
            System.out.println("4. Список выданной мебели");
            System.out.print("Выберите задачу: ");
            String task = scanner.nextLine();
            System.out.println("=============================");
            switch (task) {
                case "0":
                    System.out.println("--- конец программы ---");
                    repeat = false;
                    break;
                case "1":
                    System.out.println("--- Список мебели ---");
                    furnitureManager.printListFurnitures();
                    break;
                case "2":
                    System.out.println("--- Получить мебель ---");
                    userCardManager.checkOutFurniture();
                    break;
                case "3":
                    System.out.println("--- Сдать мебель ---");
                    userCardManager.returnFurniture();
                    break;
                case "4":  
                    System.out.println("--- Список выданной мебели ---");
                    userCardManager.printListReadFurnitures();
                    break;
                default:
                    System.out.println("Нет такой задачи");;
            }
        }while(repeat);
    }
}
