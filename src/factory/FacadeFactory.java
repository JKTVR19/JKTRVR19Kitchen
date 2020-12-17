/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factory;

import entity.Furniture;
import entity.History;
import entity.Buyer;
import entity.User;
import entity.facade.FurnitureFacade;
import entity.facade.HistoryFacade;
import entity.facade.BuyerFacade;
import entity.facade.UserFacade;

/**
 *
 * @author Melnikov
 */
public class FacadeFactory {
    public static FurnitureFacade getFurnitureFacade(){
        return new FurnitureFacade();
    }
    public static UserFacade getUserFacade(){
        return new UserFacade();
    }
    public static BuyerFacade getBuyerFacade(){
        return new BuyerFacade();
    }
    public static HistoryFacade getHistoryFacade(){
        return new HistoryFacade();
    }
}
