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
public class DocumentAdministratif {

    private int id;
    private User user;
    private String type;
    private String quantite;
    private Boolean confirmation;

    public DocumentAdministratif(int id, User user, String type, String quantite, boolean confirmation) {
        this.id = id;
        this.user = user;
        this.type = type;
        this.quantite = quantite;
        this.confirmation = confirmation;
    }

    public DocumentAdministratif(User user, String type, String quantite, boolean confirmation) {
        this.user = user;
        this.type = type;
        this.quantite = quantite;
        this.confirmation = confirmation;
    }

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public String getType() {
        return type;
    }

    public String getQuantite() {
        return quantite;
    }

    public boolean isConfirmation() {
        return confirmation;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setQuantite(String quantite) {
        this.quantite = quantite;
    }

    public void setConfirmation(boolean confirmation) {
        this.confirmation = confirmation;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final DocumentAdministratif other = (DocumentAdministratif) obj;
        if (this.id != other.id) {
            return false;
        }
        if (this.confirmation != other.confirmation) {
            return false;
        }
        if (!Objects.equals(this.type, other.type)) {
            return false;
        }
        if (!Objects.equals(this.quantite, other.quantite)) {
            return false;
        }
        if (!Objects.equals(this.user, other.user)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DocumentAdministratif{" + "id=" + id + ", user=" + user + ", type=" + type + ", quantite=" + quantite + ", confirmation=" + confirmation + '}';
    }

}
