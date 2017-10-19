/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.ICommandeService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Commande;
import models.User;
import technique.DataSource;

/**
 *
 * @author plazma33
 */
public class CommandeService implements ICommandeService {
    
    Connection connection;
    
    public CommandeService() {
        connection = DataSource.getInstance().getConnection();
    }
    
    public void add(Commande t) {
        String req = "insert into Commande (user_id,heure,prix) values (?,?,?)";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, t.getUser().getId());
            preparedStatement.setDate(2, t.getDateajout());
            preparedStatement.setDouble(3, t.getPrix());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    
    public void delete(Integer r) {
       String req="delete from commande where id=?";
       PreparedStatement preparedStatement;
       try{
           preparedStatement= connection.prepareStatement(req);
            preparedStatement.setInt(1, r);
            preparedStatement.executeUpdate();
       }catch(SQLException ex)
       {
       ex.printStackTrace();}
    }
    
    public void update(Commande t) {
        String req = "update commande set  heure =?, prix=? where id = ?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);         
            preparedStatement.setDate(1, t.getDateajout());
            preparedStatement.setDouble(2, t.getPrix());
            preparedStatement.setInt(3, t.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    
    public List<Commande> getAll() {
        List<Commande> orders = new ArrayList<>();
        String req = "select * from commande";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Commande c = new Commande(resultSet.getInt("id"), new User(resultSet.getInt("user_id")), resultSet.getDate("heure"),resultSet.getDouble("prix"));
                orders.add(c);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return orders;
    }
    
    
    
    public Commande getById(Integer r) {
        Commande commande = null;
        String req = "select * from Commande where id=?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, r);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                 commande = new Commande(resultSet.getInt("id"), new User(resultSet.getInt("user_id")), resultSet.getDate("heure"),resultSet.getDouble("prix"));
                 }
         } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return commande;
    }
    


    public Commande getByUserId(Integer r) {
        Commande commande = null;
        String req = "select * from Commande where user_id=?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, r);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                 commande = new Commande(resultSet.getInt("id"), new User(resultSet.getInt("user_id")), resultSet.getDate("heure"),resultSet.getDouble("prix"));
                 }
         } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return commande;
    }
    
    
    @Override
    public Commande search(Commande t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //@Override
    public List<Commande> GetUserCommands(User u) {
        List<Commande> orders = new ArrayList<>();
        String req = "select * from commande where user_id=?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Commande c = new Commande(resultSet.getInt("id"), new User(resultSet.getInt("user_id")), resultSet.getDate("heure"),resultSet.getDouble("prix"));
                orders.add(c);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return orders;
    }
    
    

    

    
    
    
    
    
    
    
    
    
    
}
