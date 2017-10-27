/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Objects;

/**
 *
 * @author asus
 */
public class utilisateur_accept_revision {
    private int id ;
    private Revision revision;
    private User user;
    int acceptation ;

    public utilisateur_accept_revision(int id, Revision revision, User user, int acceptation) {
        this.id = id;
        this.revision = revision;
        this.user = user;
        this.acceptation = acceptation;
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

    public int getAcceptation() {
        return acceptation;
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

    public void setAcceptation(int acceptation) {
        this.acceptation = acceptation;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + this.id;
        hash = 29 * hash + Objects.hashCode(this.revision);
        hash = 29 * hash + Objects.hashCode(this.user);
        hash = 29 * hash + this.acceptation;
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
        final utilisateur_accept_revision other = (utilisateur_accept_revision) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.acceptation != other.acceptation) {
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
        return "utilisateur_accept_revision{" + "id=" + id + ", revision=" + revision + ", user=" + user + ", acceptation=" + acceptation + '}';
    }
    
    
}
