/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author pupil
 */
public class Buyer {
    private String firstname;
    private String lastname;
    private String phone;
    private int cash;

    public Buyer() {
    }

    public Buyer(String firstname, String lastname, String phone, int cash) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.phone = phone;
        this.cash = cash;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getCash() {
        return cash;
    }

    public void setCash(int cash) {
        this.cash = cash;
    }

    @Override
    public String toString() {
        return "Buyer{" 
                + "firstname=" + firstname 
                + ", lastname=" + lastname 
                + ", phone=" + phone 
                + ", cash=" + cash 
                + '}';
    }
    
    
    
}
