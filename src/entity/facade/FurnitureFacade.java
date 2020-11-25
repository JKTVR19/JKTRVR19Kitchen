/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.facade;

import entity.Furniture;
import factory.ConnectSingleton;
import javax.persistence.EntityManager;

/**
 *
 * @author Melnikov
 */
public class FurnitureFacade extends AbstractFacade<Furniture>{
    
    public FurnitureFacade() {
        super(Furniture.class);
    }
   
    @Override
    protected EntityManager getEntityManager() {
        ConnectSingleton connect = ConnectSingleton.getInstance();
        return connect.getEntityManager();
    }
}
