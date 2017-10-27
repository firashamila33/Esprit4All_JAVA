/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Objects;
import javafx.scene.input.KeyCode;

/**
 *
 * @author asus
 */
public class utilisateur_has_revision {
    private int id ;
    private Revision revision ;
    private User user;

    public utilisateur_has_revision(int id, Revision revision, User user) {
        this.id = id;
        this.revision = revision;
        this.user = user;
    }

    public utilisateur_has_revision(Revision revision, User user) {
        this.revision = revision;
        this.user = user;
    }

    

  

   
    public int getId() {
        return id;
    }

    public Revision getRevision() {
        return revision;
    }

    public User getUser() {
        return user;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRevision(Revision revision) {
        this.revision = revision;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + this.id;
        hash = 79 * hash + Objects.hashCode(this.revision);
        hash = 79 * hash + Objects.hashCode(this.user);
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
        final utilisateur_has_revision other = (utilisateur_has_revision) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.revision, other.revision)) {
            return false;
        }
        if (!Objects.equals(this.user, other.user)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "utilisateur_has_revision{" + "id=" + id + ", revision=" + revision + ", user=" + user + '}';
    }
    
}
