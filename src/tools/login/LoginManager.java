/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools.login;

import entity.Buyer;
import java.util.Scanner;

/**
 *
 * @author Juri
 */
public class LoginManager {
    private Scanner scanner = new Scanner(System.in);
    public Buyer login(Buyer[] buyers) {
        System.out.print("Set Login: ");
        String login = scanner.nextLine();
        System.out.print("Set Password: ");
        String password = scanner.nextLine();
        if(buyers == null || buyers.length < 1){
            System.out.println("No such user. Register now");
            return null;
        }
        for (int i = 0; i < buyers.length; i++) {
            Buyer buyer = buyers[i];
            if(buyer != null 
                    && buyer.getLogin().equals(login)
                    && buyer.getPassword().equals(password)){
                return buyer;
            }
        }
        System.out.println("No such user or password");
        return null;
    }
}
