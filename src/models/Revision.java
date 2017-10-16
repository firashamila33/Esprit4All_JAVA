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
  private  Date datetime;
  private String  description ;
  private int nbrmax;
  private String type ;

    public Revision(int id, User user, String matiere, Date datetime, String description, int nbrmax, String type) {
        this.id = id;
        this.user = user;
        this.matiere = matiere;
        this.datetime = datetime;
        this.description = description;
        this.nbrmax = nbrmax;
        this.type = type;
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

    public Date getDatetime() {
        return datetime;
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

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
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
        return "Revision{" + "id=" + id + ", user=" + user + ", matiere=" + matiere + ", datetime=" + datetime + ", description=" + description + ", nbrmax=" + nbrmax + ", type=" + type + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
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
        if (!Objects.equals(this.datetime, other.datetime)) {
            return false;
        }
        return true;
    }
  
    
}
