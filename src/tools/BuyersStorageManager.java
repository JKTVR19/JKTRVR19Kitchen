/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import entity.Buyer;
//import entity.Furniture;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
//import java.util.logging.Level;
//import java.util.logging.Logger;
        
/**
 *
 * @author Juri
 */
public class BuyersStorageManager {
    
    public void saveBuyersToFile(Buyer[] buyers){
        String fileName = "buyers";
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            fos = new FileOutputStream(fileName);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(buyers);
            oos.flush();
        } catch (FileNotFoundException ex) {
            System.out.println("No such file");
        } catch (IOException ex) {
            System.out.println("input/output error");
        }
    }
    public Buyer[] loadBuyersFromFile(){
        Buyer[] buyers = null;
        String fileName = "buyers";
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(fileName);
            ois = new ObjectInputStream(fis);
            return (Buyer[]) ois.readObject();
        } catch (FileNotFoundException ex) {
            System.out.println("No such file");
        } catch (IOException ex) {
            System.out.println("Оinput/output error");
        } catch (ClassNotFoundException ex) {
            System.out.println("No such class");
        }
        return buyers;
    }

    
}
