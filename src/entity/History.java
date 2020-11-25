/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Melnikov
 */
@Entity
public class History implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private Furniture furniture;
    @OneToOne
    private Buyer buyer;
    @Temporal(TemporalType.TIMESTAMP)
    private Date takeOnDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date returnDate;

    public History() {
    }

    public History(Furniture book, Buyer reader, Date takeOnDate, Date returnDate) {
        this.furniture = book;
        this.buyer = reader;
        this.takeOnDate = takeOnDate;
        this.returnDate = returnDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
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

    @Override
    public String toString() {
        return "History{" 
                + "furniture=" + furniture.getName()
                + ", buyer=" + buyer.getFirstname()+" "+buyer.getLastname()
                + ", takeOnDate=" + takeOnDate 
                + ", returnDate=" + returnDate 
                + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.furniture);
        hash = 37 * hash + Objects.hashCode(this.buyer);
        hash = 37 * hash + Objects.hashCode(this.takeOnDate);
        hash = 37 * hash + Objects.hashCode(this.returnDate);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final History other = (History) obj;
        if (!Objects.equals(this.furniture, other.furniture)) {
            return false;
        }
        if (!Objects.equals(this.buyer, other.buyer)) {
            return false;
        }
        if (!Objects.equals(this.takeOnDate, other.takeOnDate)) {
            return false;
        }
        if (!Objects.equals(this.returnDate, other.returnDate)) {
            return false;
        }
        return true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
}
