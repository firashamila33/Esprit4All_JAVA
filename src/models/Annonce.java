/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Collections;
import java.util.Date;

/**
 *
 * @author kadhem
 */
public class Annonce {
    private int id;
    private String name;
    private String description;
    private User owner;
    private Date creationDate;
    private Date ExpirationDate;

    public Annonce(String name, String description, User owner, Date creationDate, Date ExpirationDate) {
        this.name = name;
        this.description = description;
        this.owner = owner;
        this.creationDate = creationDate;
        this.ExpirationDate = ExpirationDate;
    }

    @Override
    public String toString() {
        return "Annonce{" + "id=" + id + ", name=" + name + ", description=" + description + ", owner=" + owner + ", creationDate=" + creationDate + ", ExpirationDate=" + ExpirationDate + '}';
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
        final Annonce other = (Annonce) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }
    
    
}
