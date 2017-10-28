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
public class note_revision {
    private int id;
    private Revision revision ;
    private User user;
    private float note;

    public note_revision(int id, Revision revision, User user, float note) {
        this.id = id;
        this.revision = revision;
        this.user = user;
        this.note = note;
    }

    public note_revision(int aInt, User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    public float getNote() {
        return note;
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

    public void setNote(float note) {
        this.note = note;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + this.id;
        hash = 79 * hash + Objects.hashCode(this.revision);
        hash = 79 * hash + Objects.hashCode(this.user);
        hash = 79 * hash + Float.floatToIntBits(this.note);
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
        final note_revision other = (note_revision) obj;
        if (this.id != other.id) {
            return false;
        }
        if (Float.floatToIntBits(this.note) != Float.floatToIntBits(other.note)) {
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
        return "note_revision{" + "id=" + id + ", revision=" + revision + ", user=" + user + ", note=" + note + '}';
    }
    
}
