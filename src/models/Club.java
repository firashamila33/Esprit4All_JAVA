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
public class Club {

    private int id;
    private String labelle;
    private String description;
    private String path_img;
    private User user;

    public Club() {
    }

    public Club(int id) {
        this.id = id;
    }

    public Club(int id, String labelle, String description, String path_img, User user) {
        this.id = id;
        this.labelle = labelle;
        this.description = description;
        this.path_img = path_img;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLabelle() {
        return labelle;
    }

    public void setLabelle(String labelle) {
        this.labelle = labelle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPath_img() {
        return path_img;
    }

    public void setPath_img(String path_img) {
        this.path_img = path_img;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Club{" + "id=" + id
                + ", labelle=" + labelle
                + ", description=" + description
                + ", path_img=" + path_img
                + ", user=" + user + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (o instanceof Club) {
            final Club c = (Club) o;
            if (c.id == this.id) {
                return true;
            }
        }

        return false;
    }

}