/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author kadhem
 */
public class Address {
    private int id;
    private String city;

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
    private String street;
    private String homeNumber;
    private String furtherAddressDescription;

    public Address(String city, String street, String homeNumber, String furtherAddressDescription) {
        this.city = city;
        this.street = street;
        this.homeNumber = homeNumber;
        this.furtherAddressDescription = furtherAddressDescription;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHomeNumber() {
        return homeNumber;
    }

    public void setHomeNumber(String homeNumber) {
        this.homeNumber = homeNumber;
    }

    public String getFurtherAddressDescription() {
        return furtherAddressDescription;
    }

    public void setFurtherAddressDescription(String furtherAddressDescription) {
        this.furtherAddressDescription = furtherAddressDescription;
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
        final Address other = (Address) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Address{" + "city=" + city + ", street=" + street + ", homeNumber=" + homeNumber + ", furtherAddressDescription=" + furtherAddressDescription + '}';
    }
    
}
