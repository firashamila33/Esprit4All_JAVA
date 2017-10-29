/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Date;
import java.util.Objects;

/**
 *
 * @author YACINE
 */
public class Covoiturage {

    private int id;
    private User u;
    private double prix;
    private String depart;
    private String arrivé;
    private String description;
    private int nbrePlace;
    private Date heureDépart;
    private String Voiture;
    
    public Covoiturage(int id){
        this.id=id;
    }
    
    public Covoiturage(int id, User u,  double prix, String depart, String arrivé, String description, int nbrePlace, Date heureDépart) {
        this.id = id;
        this.u = u;
        this.prix = prix;
        this.depart = depart;
        this.arrivé = arrivé;
        this.description = description;
        this.nbrePlace = nbrePlace;
        this.heureDépart = heureDépart;
    }

    public Covoiturage(User u, double prix, String depart, String arrivé, String description, int nbrePlace, Date heureDépart) {
        this.u = u;
        this.prix = prix;
        this.depart = depart;
        this.arrivé = arrivé;
        this.description = description;
        this.nbrePlace = nbrePlace;
        this.heureDépart = heureDépart;
    }

    public Covoiturage(int id, User u, double prix, String depart, String arrivé, String description, int nbrePlace, Date heureDépart, String Voiture) {
        this.id = id;
        this.u = u;
        this.prix = prix;
        this.depart = depart;
        this.arrivé = arrivé;
        this.description = description;
        this.nbrePlace = nbrePlace;
        this.heureDépart = heureDépart;
        this.Voiture = Voiture;
    }

    public Covoiturage(User u, double prix, String depart, String arrivé, String description, int nbrePlace, Date heureDépart, String Voiture) {
        this.u = u;
        this.prix = prix;
        this.depart = depart;
        this.arrivé = arrivé;
        this.description = description;
        this.nbrePlace = nbrePlace;
        this.heureDépart = heureDépart;
        this.Voiture = Voiture;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Covoiturage{" + "id=" + id + ", User_id=" + u.getId() + ", prix=" + prix + ", depart=" + depart + ", arriv\u00e9=" + arrivé + ", nbrePlace=" + nbrePlace + ", heureD\u00e9part=" + heureDépart + '}';
    }

    public User getUserId() {
        return u;
    }

    public void setUserId(User u) {
        this.u = u;
    }


    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getDepart() {
        return depart;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }

    public String getArrivé() {
        return arrivé;
    }

    public void setArrivé(String arrivé) {
        this.arrivé = arrivé;
    }

    public int getNbrePlace() {
        return nbrePlace;
    }

    public void setNbrePlace(int nbrePlace) {
        this.nbrePlace = nbrePlace;
    }

    public Date getHeureDépart() {
        return heureDépart;
    }

    public void setHeureDépart(Date heureDépart) {
        this.heureDépart = heureDépart;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + this.id;
        hash = 53 * hash + this.u.hashCode();
        hash = 53 * hash + (int) (Double.doubleToLongBits(this.prix) ^ (Double.doubleToLongBits(this.prix) >>> 32));
        hash = 53 * hash + Objects.hashCode(this.depart);
        hash = 53 * hash + Objects.hashCode(this.arrivé);
        hash = 53 * hash + this.nbrePlace;
        hash = 53 * hash + Objects.hashCode(this.heureDépart);
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
        final Covoiturage other = (Covoiturage) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.u != other.u) {
            return false;
        }
        if (Double.doubleToLongBits(this.prix) != Double.doubleToLongBits(other.prix)) {
            return false;
        }
        if (this.nbrePlace != other.nbrePlace) {
            return false;
        }
        if (!Objects.equals(this.depart, other.depart)) {
            return false;
        }
        if (!Objects.equals(this.arrivé, other.arrivé)) {
            return false;
        }
        return Objects.equals(this.heureDépart, other.heureDépart);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getU() {
        return u;
    }

    public void setU(User u) {
        this.u = u;
    }

    public String getVoiture() {
        return Voiture;
    }

    public void setVoiture(String Voiture) {
        this.Voiture = Voiture;
    }

}
