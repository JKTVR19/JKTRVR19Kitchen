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
import entity.facade.FurniteFacade;
import entity.facade.HistoryFacade;
import entity.facade.BuyerrFacade;
import entity.facade.UserFacade;

/**
 *
 * @author JKTVR19Library
 */
public class FacadeFactory {
    public static FurniteFacade getFurnitureFacade(){
        return new FurniteFacade();
    }
    public static UserFacade getUserFacade(){
        return new UserFacade();
    }
    public static BuyerrFacade getBuyerFacade(){
        return new BuyerrFacade();
    }
    public static HistoryFacade getHistoryFacade(){
        return new HistoryFacade();
    }
}
