/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.manager;

import entity.Buyer;
import entity.User;
import entity.facade.BuyerrFacade;
import entity.facade.UserFacade;
import factory.FacadeFactory;
import java.util.List;
import java.util.Scanner;
import security.SecureManager;

/**
 *
 * @author JKTVR19Library
 */
public class UserManager {
    private Scanner scanner = new Scanner(System.in);
    private BuyerrFacade buyerFacade = FacadeFactory.getBuyerFacade();
    private UserFacade userFacade = FacadeFactory.getUserFacade();

    public User createUser() {
        BuyerManager buyerManager = new BuyerManager();
        Buyer buyer = buyerManager.createBuyer();
        User user = new User();
        System.out.println("--- Add Buyer ---");
        System.out.println("Buyer login:");
        user.setLogin(scanner.nextLine());
        System.out.println("Enter password:");
        user.setPassword(scanner.nextLine());
        int numRole;
        do{
            System.out.println("Role list:");
            for (int i = 0; i < SecureManager.role.values().length; i++) {
                System.out.printf("%d. %s%n"
                        ,i+1
                        ,SecureManager.role.values()[i].toString()
                );
            }
            System.out.println("Enter role number:");
            String numRoleStr = scanner.nextLine();
            try {
                numRole = Integer.parseInt(numRoleStr);
                break;
            } catch (Exception e) {
                System.out.println("Enter number.");
            }
        }while(true);
        user.setRole(SecureManager.role.values()[numRole-1].toString());
        user.setBuyer(buyer);
        userFacade.create(user);
        return user;
    }
  
    public User getCheckInUser() {
        System.out.println("--- Login to system ---");
        System.out.print("Login: ");
        String login = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();
        List<User> listUsers = userFacade.findAll();
        if(listUsers == null){
            System.out.println("You don't have not enaugh rights. Register now.");
            return null;
        }
        for (int i = 0; i < listUsers.size(); i++) {
            if(listUsers.get(i) != null && listUsers.get(i).getLogin().equals(login)){
                for (int j = 0; j < 2; j++) {
                   if(listUsers.get(i).getPassword().equals(password)){
                       return listUsers.get(i);
                   }else{
                       System.out.println("Try once more.");
                       password = scanner.nextLine();
                   }
                }
                System.out.println("You are not authorized to log in.");
                return null;
            }
        }
        System.out.println("You are not authorized to log in. Register now.");
        return null;
    }
    
}
