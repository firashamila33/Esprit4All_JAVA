/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author kadhem
 */
public class AnnonceCoLocation extends Annonce{
private int id;
private Address address;
private String dimensions;
private ArrayList<User> coLocataires;
private int maxCoLocataire;
private float loyer;
private ArrayList<String> photosUrls;

    public AnnonceCoLocation(Address address, String dimensions, ArrayList<User> coLocataires, int maxCoLocataire, float loyer, ArrayList<String> photosUrls, String name, String description, User owner, Date creationDate, Date ExpirationDate) {
        super(name, description, owner, creationDate, ExpirationDate);
        this.address = address;
        this.dimensions = dimensions;
        this.coLocataires = coLocataires;
        this.maxCoLocataire = maxCoLocataire;
        this.loyer = loyer;
        this.photosUrls = photosUrls;
    }
     
public AnnonceCoLocation(Address address, String dimensions, ArrayList<User> coLocataires, int maxCoLocataire, float loyer, ArrayList<String> photosUrls, User owner, Date creationDate, Date ExpirationDate) {
        super("Annonce CoLocation","", owner, creationDate, ExpirationDate);
        this.address = address;
        this.dimensions = dimensions;
        this.coLocataires = coLocataires;
        this.maxCoLocataire = maxCoLocataire;
        this.loyer = loyer;
        this.photosUrls = photosUrls;
    }
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + this.id;
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
        final AnnonceCoLocation other = (AnnonceCoLocation) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    

    
}
