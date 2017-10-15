/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author Sami
 */
public class User {

    private int id;

    public User() {
    }

    public User(int id) {
        this.id = id;
    }

    public void setId(int id) {
        this.id = id;

    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "User{ id" + id + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        if (o == this) {
            return true;
        }
        if (o instanceof User) {
            final User u = (User) o;
            if (u.id == this.id) {
                return true;
            }
        }
        return false;
    }
}
