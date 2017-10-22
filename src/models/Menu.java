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
 * @author plazma33
 */
public class Menu {
    
    private int id;
    private String libelle;
    private String type;
    private String endroit;
    private int disponibilite;
    private int quantite;
    private Double prix;
    private String path_img;
    
    public Menu(int id, String libelle,String type, String endroit, int disponibilite, int quantite, Double prix,String path_img ){
        this.id=id;
        
        this.libelle=libelle;
        this.endroit=endroit;
        this.disponibilite=disponibilite;
        this.quantite=quantite;
        this.prix=prix;
        this.path_img=path_img;
    }
    
    public Menu(String libelle,String type, String endroit, int disponibilite, int quantite, Double prix,String path_img ){
   
        this.libelle=libelle;
        this.endroit=endroit;
        this.disponibilite=disponibilite;
        this.quantite=quantite;
        this.prix=prix;
        this.path_img=path_img;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEndroit() {
        return endroit;
    }

    public void setEndroit(String endroit) {
        this.endroit = endroit;
    }

    public int getDisponibilite() {
        return disponibilite;
    }

    public void setDisponibilite(int disponibilite) {
        this.disponibilite = disponibilite;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public Double getPrix() {
        return prix;
    }

    public void setPrix(Double prix) {
        this.prix = prix;
    }

    public String getPath_img() {
        return path_img;
    }

    public void setPath_img(String path_img) {
        this.path_img = path_img;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + this.id;
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
        final Menu other = (Menu) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Menu{" + "id=" + id + ", user=" + ", libelle=" + libelle + ", type=" + type + ", endroit=" + endroit + ", disponibilite=" + disponibilite + ", quantite=" + quantite + ", prix=" + prix + ", path_img=" + path_img + '}';
    }
    
     
   

    
    
    

    
    
    
    
    
    
    
    
}
