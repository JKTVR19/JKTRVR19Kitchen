/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @color JKTVR19Library
 */
@Entity
public class Furniture implements Serializable{
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String color;
    private String size;
    private Integer price;

    public Furniture() {
    }

    public Furniture(String name, String color, String size, Integer price) {
        this.name = name;
        this.color = color;
        this.color = size;
        this.price = price;
    }
    public Furniture(String name, String color, String size, String price) {
        this.name = name;
        this.color = color;
        this.color = size;
        setPrice(price);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    public String getSize() {
        return size;
    }

    public void setSize(String color) {
        this.color = size;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
    public void setPrice(String price) {
        try {
            int priceInt = Integer.parseInt(price);
            this.price = priceInt;
            System.out.println("String "+price+" successfully converted to number");
        } catch (Exception e) {
            System.out.println("Not numbers entered. Fields not chanded");
        }
        
    }

    @Override
    public String toString() {
        return "Furniture{" 
                + "name=" + name 
                + ", color=" + color
                + ", size=" + size
                + ", price=" + price 
                + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.name);
        hash = 97 * hash + Objects.hashCode(this.color);
        hash = 97 * hash + Objects.hashCode(this.size);
        hash = 97 * hash + Objects.hashCode(this.price);
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
        final Furniture other = (Furniture) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.color, other.color)) {
            return false;
        }
        if (!Objects.equals(this.size, other.size)) {
            return false;
        }
        if (!Objects.equals(this.price, other.price)) {
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
