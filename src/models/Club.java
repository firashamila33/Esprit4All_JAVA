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
    private String libelle;
    private String description;
    private String path_img;
    private String path_couverture;
    private User user;

    public Club() {
    }

    public Club(int id) {
        this.id = id;
    }

    public Club(int id, String libelle, String description, String path_img,String path_couverture, User user) {
        this.path_couverture= path_couverture;
        this.id = id;
        this.libelle = libelle;
        this.description = description;
        this.path_img = path_img;
        this.user = user;
    }

    public Club( String libelle, String description, String path_img,String path_couverture, User user) {
        this.path_couverture= path_couverture;
        this.libelle = libelle;
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

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
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

    public String getPath_couverture() {
        return path_couverture;
    }

    public void setPath_couverture(String path_couverture) {
        this.path_couverture = path_couverture;
    }

    @Override
    public String toString() {
        return "Club{" + "id=" + id + ", libelle=" + libelle + ", description=" + description + ", path_img=" + path_img + ", path_couverture=" + path_couverture + ", user=" + user + '}';
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