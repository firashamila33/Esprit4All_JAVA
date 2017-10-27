/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.util.Objects;

/**
 *
 * @author YACINE
 */
public class HasCovoiturage {
    private int id;
    private Covoiturage covoiturage;
    private User u;

    public HasCovoiturage(int id, Covoiturage covoiturage, User u) {
        this.id = id;
        this.covoiturage = covoiturage;
        this.u = u;
    }
    
        public HasCovoiturage(Covoiturage covoiturage, User u) {
        this.covoiturage = covoiturage;
        this.u = u;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Covoiturage getCovoiturage() {
        return covoiturage;
    }

    public void setCovoiturage(Covoiturage covoiturage) {
        this.covoiturage = covoiturage;
    }

    public User getU() {
        return u;
    }

    public void setU(User u) {
        this.u = u;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final HasCovoiturage other = (HasCovoiturage) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.covoiturage, other.covoiturage)) {
            return false;
        }
        if (!Objects.equals(this.u, other.u)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "HasCovoiturage{" + "id=" + id + ", covoiturage=" + covoiturage + ", u=" + u + '}';
    }
}
