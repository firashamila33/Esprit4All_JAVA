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
 * @author asus
 */
public class Revision {
  private  int id ;
  private User user;
  private  String  matiere ;
  private  Date date_debut;
  private String  description ;
  private int nbrmax;
  private String type ;
    private  Date date_fin
            ;


   

    public Revision(int id, User user, String matiere, Date date_debut, String description, int nbrmax, String type, Date date_fin) {
        this.id = id;
        this.user = user;
        this.matiere = matiere;
        this.date_debut = date_debut;
        this.description = description;
        this.nbrmax = nbrmax;
        this.type = type;
        this.date_fin = date_fin;
    }

    public Revision(User user, String matiere, Date date_debut, String description, int nbrmax, String type, Date date_fin) {
        this.user = user;
        this.matiere = matiere;
        this.date_debut = date_debut;
        this.description = description;
        this.nbrmax = nbrmax;
        this.type = type;
        this.date_fin = date_fin;
    }
    
    

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public String getMatiere() {
        return matiere;
    }

    public Date getDate_fin() {
        return date_fin;
    }

    public Date getDate_debut() {
        return date_debut;
    }

  

    public String getDescription() {
        return description;
    }

    public int getNbrmax() {
        return nbrmax;
    }

    public String getType() {
        return type;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }

   

    public void setDescription(String description) {
        this.description = description;
    }

    public void setNbrmax(int nbrmax) {
        this.nbrmax = nbrmax;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Revision{" + "id=" + id + ", user=" + user + ", matiere=" + matiere + ", date_debut=" + date_debut + ", description=" + description + ", nbrmax=" + nbrmax + ", type=" + type + ", date_fin=" + date_fin + '}';
    }

    

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    public void setDate_debut(Date date_debut) {
        this.date_debut = date_debut;
    }

    public void setDate_fin(Date date_fin) {
        this.date_fin = date_fin;
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
        final Revision other = (Revision) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.nbrmax != other.nbrmax) {
            return false;
        }
        if (!Objects.equals(this.matiere, other.matiere)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        if (!Objects.equals(this.user, other.user)) {
            return false;
        }
        if (!Objects.equals(this.date_debut, other.date_debut)) {
            return false;
        }
        if (!Objects.equals(this.date_fin, other.date_fin)) {
            return false;
        }
        return true;
    }

    
  
    
}
