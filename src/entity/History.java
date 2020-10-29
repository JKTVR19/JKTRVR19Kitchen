/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Juri
 */
public class History implements Serializable{
    private Furniture furniture;
    private Buyer buyer;
    private Date takeOnDate;
    private Date returnDate;

    public History() {
}

    public History(Furniture furniture, Buyer buyer, Date takeOnDate, Date returnDate) {
        this.furniture = furniture;
        this.buyer = buyer;
        this.takeOnDate = takeOnDate;
        this.returnDate = returnDate;
    }

    public Furniture getFurniture() {
        return furniture;
    }

    public void setFurniture(Furniture furniture) {
        this.furniture = furniture;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public Date getTakeOnDate() {
        return takeOnDate;
    }

    public void setTakeOnDate(Date takeOnDate) {
        this.takeOnDate = takeOnDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    @Override
    public String toString() {
        return "History{" 
                + "furniture=" + furniture.getName()
                + ", buyer=" + buyer.getFirstname()+" "+buyer.getLastname()
                + ", takeOnDate=" + takeOnDate 
                + ", returnDate=" + returnDate 
                + '}';
    }
}