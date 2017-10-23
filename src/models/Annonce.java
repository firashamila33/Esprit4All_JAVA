/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Collections;
import java.sql.Date;

/**
 *
 * @author kadhem
 */
public class Annonce {
    protected int id;
    protected String name;
    protected String description;
    protected User owner;
    protected Date creationDate;
    protected Date ExpirationDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getExpirationDate() {
        return ExpirationDate;
    }

    public void setExpirationDate(Date ExpirationDate) {
        this.ExpirationDate = ExpirationDate;
    }

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
