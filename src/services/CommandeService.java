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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import models.Commande;
import models.LigneCommande;
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
        String req = "insert into commande (user_id,heure,prix) values (?,?,?)";
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
        String req = "delete from commande where id=?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, r);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void update(Commande t) {
        String req = "update commande set prix=? where id = ?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setDouble(1, t.getPrix());
            preparedStatement.setInt(2, t.getId());
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
                Commande c = new Commande(resultSet.getInt("id"), new User(resultSet.getInt("user_id")), resultSet.getDate("heure"), resultSet.getDouble("prix"));
                orders.add(c);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return orders;
    }

    public Commande getById(Integer r) {
        Commande commande = null;
        String req = "select * from commande where id=?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, r);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                commande = new Commande(resultSet.getInt("id"), new User(resultSet.getInt("user_id")), resultSet.getDate("heure"), resultSet.getDouble("prix"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return commande;
    }

    public Commande getByUserId(Integer r) {
        Commande commande = null;
        String req = "select * from commande where user_id=?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, r);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                commande = new Commande(resultSet.getInt("id"), new User(resultSet.getInt("user_id")), resultSet.getDate("heure"), resultSet.getDouble("prix"));
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
                Commande c = new Commande(resultSet.getInt("id"), new User(resultSet.getInt("user_id")), resultSet.getDate("heure"), resultSet.getDouble("prix"));
                orders.add(c);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return orders;
    }

    public int getPriceById(Integer r) {
        int sum = 0;
        List<LigneCommande> list = new ArrayList<>();
        String req = "select * from ligne_commande where cammande_id=?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, r);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                LigneCommande commande = new LigneCommande(resultSet.getInt("commande_id"), resultSet.getInt("menu_id"), resultSet.getInt("quantite"));
                list.add(commande);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return sum;
    }

    public Commande ReturnLastOrderByUser(Integer r) {
            
        Commande c = null;
        String req = "select * from commande where user_id=?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, r);
            ResultSet resultSet = preparedStatement.executeQuery();
            System.out.println("I am in ReturnLastOrderByUser");
            while (resultSet.next()) {
                c = new Commande(resultSet.getInt("id"), new User(resultSet.getInt("user_id")), resultSet.getDate("heure"), resultSet.getDouble("prix"));
                System.out.println("hey I found orders for this user");
                c.toString();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return c;

    }



    public Double GetCommandePriceById(Integer r) {
        double price = 0.0;
        String req = "select * from commande where id=?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, r);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                price = resultSet.getInt("prix");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return price;

    }
    
    @Override
    public double UpdateCommandePricce(Commande t) {
        double sum=0;
        String req = "SELECT * FROM `ligne_commande`l join menu m where m.id=l.menu_id && commande_id=?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, t.getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                sum+=(resultSet.getDouble("prix")*resultSet.getInt("quantite"));
                System.out.println("SUM COMMAND PRICE -----> "+sum );
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
       return sum;
    }

    
    
    
    
    
    
    
    
    
    
    
    //    public double UpdateCommandePricce(Commande t) {
//
//        String req = "update commande set prix=? where id = ?";
//        PreparedStatement preparedStatement;
//        try {
//            preparedStatement = connection.prepareStatement(req);
//            preparedStatement.setDouble(1, NewPrice(t));
//            preparedStatement.setInt(2, t.getId());
//            preparedStatement.executeUpdate();
//
//            System.out.println("111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111   NEW PRICE " + NewPrice(t));
//            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@   NEW PRICE " + t.getId());
//            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@   NEW PRICE " + NewPrice(t));
//
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//        return NewPrice(t);
//    }
//
//    public double NewPrice(Commande t) {
//        //getting a map containing "ligne de commande" that below to this user and the quantity
//        Map<Integer, Integer> Calculate = new HashMap<>();
//        int id = 0;
//        String req = "select * from ligne_commande where commande_id= ?";
//        PreparedStatement preparedStatement;
//        try {
//            preparedStatement = connection.prepareStatement(req);
//            preparedStatement.setInt(1, t.getId());
//            ResultSet resultSet = preparedStatement.executeQuery();
//           
//            while (resultSet.next()) {
//                
//                Calculate.put(resultSet.getInt("menu_id"), resultSet.getInt("quantite"));
//
//                System.out.println("|+|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||| Y3ABBI FEL MAP   " + resultSet.getInt("menu_id") + "_____" + resultSet.getDouble("quantite"));
//            }
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//        double sum =0;
//
//        //calculating the new price
//        for (Map.Entry<Integer, Integer> entry : Calculate.entrySet()) {
//
//            sum = sum + ((entry.getValue()) * GetCommandePriceById(entry.getKey()));
//            System.out.println("key, " + entry.getKey() + " value " +  entry.getValue());
//            System.out.println("TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT"+(entry.getValue()) * GetCommandePriceById(entry.getKey()));
//            System.out.println("|+||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||| SUM : " + sum);
//
//        }
//
//        System.out.println("|+||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||| SUM FINAL : " + sum);
//        
//        
//        return sum;
//
//    }

    
}




