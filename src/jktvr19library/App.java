/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jktvr19library;

import entity.User;
import security.SecureManager;
import ui.UserInterface;


/**
 *
 * @author JKTVR19Library
 */
public class App {
    public static enum storageFile{FURNITURES, BUYERS, USERS, HISTORIES};
    public static User loggedInUser;
    
    public App() {
    }
    
    public void run() {
      
            System.out.println("---Kitchen furniture shop---");
            SecureManager secureManager = new SecureManager();
            App.loggedInUser = secureManager.checkInLogin();
            UserInterface userInterface = new UserInterface();
            if(App.loggedInUser == null){
                System.out.println("you don't have access right");
                return;
            }
            if(SecureManager.role.MANAGER.toString().equals(App.loggedInUser.getRole())){
                //public the manager interfase
                userInterface.printManagerUI();
            }else if(SecureManager.role.BUYER.toString().equals(App.loggedInUser.getRole())){
                //public the buyer interface
                userInterface.printBuyerUI();
            }
        
    }

}
