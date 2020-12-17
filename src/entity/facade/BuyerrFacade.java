/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.facade;

import entity.Buyer;
import factory.ConnectSingleton;
import javax.persistence.EntityManager;

/**
 *
 * @author JKTVR19Library
 */
public class BuyerrFacade extends AbstractFacade<Buyer>{
   
    public BuyerrFacade() {
        super(Buyer.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        ConnectSingleton connect = ConnectSingleton.getInstance();
        return connect.getEntityManager();
    }
    
}
