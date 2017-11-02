/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.IMenuService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import models.Menu;
import technique.DataSource;

/**
 *
 *@author plazma33
 */
public class MenuService implements IMenuService {

    Connection connection;

    public MenuService() {
        connection = DataSource.getInstance().getConnection();

    }

    public void add(Menu t) {
        String req = "insert into Menu (libelle,type,categorie,endroit,disponibilite,quantite,prix,path_img) values (?,?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            
            preparedStatement.setString(1, t.getLibelle());
            preparedStatement.setString(2, t.getType());
            preparedStatement.setString(3, t.getCategorie());
            preparedStatement.setString(4, t.getEndroit());
            preparedStatement.setInt(5, t.getDisponibilite());
            preparedStatement.setInt(6, t.getQuantite());
            preparedStatement.setDouble(7, t.getPrix());
            preparedStatement.setString(8, t.getPath_img());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void delete(Integer id) {
        String req = "delete from Menu where id=?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void update(Menu t) {
        String req = "update Menu set libelle=?, type=?,categorie=? endroit=?, disponibilite=?, quantite=?, prix=?, path_img=? where id = ?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, t.getLibelle());
            preparedStatement.setString(2, t.getType());
            preparedStatement.setString(3, t.getCategorie());
            preparedStatement.setString(4, t.getEndroit());
            preparedStatement.setInt(5, t.getDisponibilite());
            preparedStatement.setInt(6, t.getQuantite());
            preparedStatement.setDouble(7, t.getPrix());
            preparedStatement.setString(8, t.getPath_img());
            preparedStatement.setInt(9, t.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<Menu> getAll() {
        List<Menu> meals = new ArrayList<>();
        String req = "select * from Menu";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Menu m;
                m = new Menu(resultSet.getInt("id"), resultSet.getString("libelle"), resultSet.getString("type"),resultSet.getString("categorie"), resultSet.getString("endroit"), resultSet.getInt("disponibilite"), resultSet.getInt("quantite"), resultSet.getDouble("prix"), resultSet.getString("path_img"));
                meals.add(m);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return meals;
    }

    @Override
    public Menu getById(Integer r) {
        Menu menu = null;
        String req = "select * from Menu where id=?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, r);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                menu = new Menu(resultSet.getInt("id"), resultSet.getString("libelle"), resultSet.getString("type"),resultSet.getString("categorie"), resultSet.getString("endroit"), resultSet.getInt("disponibilite"), resultSet.getInt("quantite"), resultSet.getDouble("prix"), resultSet.getString("path_img"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return menu;
    }

    @Override
    public Menu search(Menu t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  

    
    @Override
    public Map<String,TreeSet<String>> GetSubCategoriesbyCategory() {
           
        Map<String,TreeSet<String>> Categs = new HashMap<>();
        
        TreeSet<String> fast_food= new TreeSet<>();
        TreeSet<String> meals= new TreeSet<>();
        TreeSet<String> drinks= new TreeSet<>();
        TreeSet<String> snacks= new TreeSet<>();
        
        String req = "select * from Menu";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {                
                switch(resultSet.getString("type")){
                    
                    case("Fast_Food"):
                        fast_food.add(resultSet.getString("categorie"));
                        break;
                    case("meals"):
                        meals.add(resultSet.getString("categorie"));
                        break;
                    case("drinks"):
                        drinks.add(resultSet.getString("categorie"));
                        break;
                    case("Snack"):
                        snacks.add(resultSet.getString("categorie"));
                        break; 
                    default:
                        break;
                }
                     
            }                        
        } catch (SQLException ex) {
            ex.printStackTrace();
        }        
        Categs.put("Fast_Food", fast_food);
        Categs.put("meals", meals);
        Categs.put("drinks", drinks);
        Categs.put("Snack", snacks);
 
        return Categs;
    
    }

    
    public List<Menu> GetMealsFromSubMenuFilter(String s){
        
        List<Menu> meals = new ArrayList<>();
        Menu menu;
        String req = "select * from Menu where categorie=?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, s);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                menu = new Menu(resultSet.getInt("id"), resultSet.getString("libelle"), resultSet.getString("type"),resultSet.getString("categorie"), resultSet.getString("endroit"), resultSet.getInt("disponibilite"), resultSet.getInt("quantite"), resultSet.getDouble("prix"), resultSet.getString("path_img"));
                meals.add(menu);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return meals;
        
        
    
    
    
    
    
    }

    
    

}
