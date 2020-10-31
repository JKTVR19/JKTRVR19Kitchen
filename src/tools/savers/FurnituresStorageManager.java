/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.savers;

/**
 *
 * @author Juri
 */


import entity.Furniture;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FurnituresStorageManager {
    public void saveFurnituresToFile(Furniture[] furnitures) {
        String fileName = "furnitures";
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(fileName);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(furnitures);
            oos.flush();
        } catch (FileNotFoundException ex) {
            System.out.println("No such file");
        } catch (IOException ex) {
            System.out.println("Оinput/output error");
        }
    }
    public Furniture[] loadFurnituresFromFile() {
        //Book[] books = new book[10];
        Furniture[] furnitures = null;
        String fileName = "furnitures";
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(fileName);
            ois = new ObjectInputStream(fis);
            return (Furniture[]) ois.readObject();
        } catch (FileNotFoundException ex) {
            System.out.println("No such file"); 
        } catch (IOException ex){
            System.out.println("Оinput/output error");
        } catch (ClassNotFoundException ex) {
            System.out.println("No such class");
        }
        return furnitures;
    }
    
}
