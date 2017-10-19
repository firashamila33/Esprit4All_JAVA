/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
import java.sql.Date;
import java.util.List;
/**
 *
 * @author plazma33
 */
public class Commande {
    
    private int id;
    private User user;
    private Date Dateajout;
    private Double prix;
    



    public Commande(int id, User user, Date Dateajout, Double prix) {
        this.id = id;
        this.user = user;
        this.Dateajout = Dateajout;
        this.prix = prix;
        
    }

    public Commande(User user, Date Dateajout, Double prix) {
        this.user = user;
        this.Dateajout = Dateajout;
        this.prix = prix;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDateajout() {
        return Dateajout;
    }

    public void setDateajout(Date Dateajout) {
        this.Dateajout = Dateajout;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + this.id;
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
        final Commande other = (Commande) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Commande{" + "id=" + id + ", user=" + user.getCin() + ", Dateajout=" + Dateajout + ", prix=" + prix + '}';
    }
    
    
    
    
    
    
    
    
    
    
}
