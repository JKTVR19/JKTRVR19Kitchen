/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;

/**
 *
  * @author pupil
 */
public class Furniture implements Serializable {
    private String name;
    private String color;
    private String size;
    private int price;

    public Furniture() {
    }

    public Furniture(String name, String color, String size, int price) {
        this.name = name;
        this.color = color;
        this.size = size;
        this.price = price;
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

    public void setSize(String size) {
        this.size = size;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
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
    
    
    
}
