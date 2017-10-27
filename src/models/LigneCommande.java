/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import technique.DataSource;

/**
 *
 * @author plazma33
 */
public class LigneCommande {
    private int commande_id;
    private int menu_id;
    private int quantite;

    
    
    Connection connection = DataSource.getInstance().getConnection();    
    
    public LigneCommande() {
    }
    
    public LigneCommande(int commande_id, int menu_id, int quantite) {
        this.commande_id = commande_id;
        this.menu_id = menu_id;
        this.quantite = quantite;
    }

    public int getCommande_id() {
        return commande_id;
    }

    public void setCommande_id(int commande_id) {
        this.commande_id = commande_id;
    }

    public int getMenu_id() {
        return menu_id;
    }

    public void setMenu_id(int menu_id) {
        this.menu_id = menu_id;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    @Override
    public String toString() {
        return "LigneCommande{" + "commande_id=" + commande_id + ", menu_id=" + menu_id + ", quantite=" + quantite + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + this.commande_id;
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
        final LigneCommande other = (LigneCommande) obj;
        if (this.commande_id != other.commande_id) {
            return false;
        }
        return true;
    }
    
    
//    public Menu GetLigneCommandeMeal() {
//        Menu meal= null;
//        String req = "select * from menu where id=?";
//        PreparedStatement preparedStatement;
//        try {
//            preparedStatement = connection.prepareStatement(req);
//
//            preparedStatement.setInt(1,menu_id);
//
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()) {
//                
//                meal = new Menu(resultSet.getString("libelle"), resultSet.getString("type"), resultSet.getDouble("prix"), resultSet.getString("path_img"));
//            }
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//
//        return meal;
//
//    }
    
    
    
    
    
}
