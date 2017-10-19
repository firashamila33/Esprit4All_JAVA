/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.ILigneCommandeService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.LigneCommande;
import models.User;

/**
 *
 * @author plazma33
 */
public class LigneCommandeService implements ILigneCommandeService{
    
    Connection connection;
    
    @Override
    public void add(LigneCommande t) {
        String req = "insert into ligne_commande (Command_id,menu_id,quantite) values (?,?,?)";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, t.getCommande_id());
            preparedStatement.setInt(1, t.getMenu_id());
            preparedStatement.setInt(1, t.getQuantite());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void delete(LigneCommande t) {
        String req="delete from ligne_commande where commande_id = ? and menu_id= ?";
       PreparedStatement preparedStatement;
       try{
           preparedStatement= connection.prepareStatement(req);
            preparedStatement.setInt(1, t.getCommande_id());
            preparedStatement.setInt(2, t.getMenu_id());
            preparedStatement.executeUpdate();
       }catch(SQLException ex)
       {
       ex.printStackTrace();}
    }

    @Override
    public List<LigneCommande> GetCommandMeals(User u) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<LigneCommande> getAll() {
        List<LigneCommande> meals = new ArrayList<>();
        String req = "select * from ligne_commande";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                LigneCommande m = new LigneCommande(resultSet.getInt("commande_id"), resultSet.getInt("menu_id"),resultSet.getInt("quantite"));
                //System.out.println(m);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return meals;
    }

    public LigneCommande getByIds(LigneCommande t) {
        LigneCommande meals = null;
        String req = "select * from ligne_commande where commande_id = ? and menu_id= ?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, t.getCommande_id());
            preparedStatement.setInt(2, t.getMenu_id());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                 LigneCommande m = new LigneCommande(resultSet.getInt("commande_id"), resultSet.getInt("menu_id"),resultSet.getInt("quantite"));
                 }
         } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return meals;
    }

    public void update(LigneCommande t1,LigneCommande t2) {
        String req = "update ligne_commande set commande_id=?, menu_id=?, quantite=? where commande_id = ? and menu_id= ?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, t1.getCommande_id());
            preparedStatement.setInt(2, t1.getMenu_id());
            preparedStatement.setInt(3, t1.getQuantite());
            preparedStatement.setInt(4, t2.getCommande_id());
            preparedStatement.setInt(5, t2.getMenu_id());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public LigneCommande search(LigneCommande t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(LigneCommande t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LigneCommande getById(Integer r) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Integer r) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    

    
    
}
