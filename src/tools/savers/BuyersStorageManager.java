/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.savers;

import entity.Buyer;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Melnikov
 */
public class BuyersStorageManager {

    public void saveBuyersToFile(Buyer[] buyers) {
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
            System.out.println("Input/Output error");
        }
    }
    public Buyer[] loadBuyersFromFile() {
        //Reader[] readers = new Buyer[10];
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
        } catch (IOException ex){
            System.out.println("Input/Output error");
        } catch (ClassNotFoundException ex) {
            System.out.println("No such class");
        }
        return buyers;
    }
    
}
