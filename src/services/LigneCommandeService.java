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
import models.Menu;
import models.User;
import technique.DataSource;

/**
 *
 * @author plazma33
 */
public class LigneCommandeService implements ILigneCommandeService {

    Connection connection = DataSource.getInstance().getConnection();

    public int TestExist(LigneCommande t) {

        int var = 0;

        List<LigneCommande> meals = new ArrayList<>();
        String req = "select * from ligne_commande where commande_id = ? and menu_id= ?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, t.getCommande_id());
            preparedStatement.setInt(2, t.getMenu_id());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                var = resultSet.getInt("quantite");

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        if (var == 0) {
            return var;
        }
        return var;
    }

    @Override
    public void add(LigneCommande t) {

        if (TestExist(t) == 0) {
            String req = "insert into ligne_commande (commande_id,menu_id,quantite) values (?,?,?)";
            PreparedStatement preparedStatement;
            try {
                preparedStatement = connection.prepareStatement(req);
                preparedStatement.setInt(1, t.getCommande_id());
                preparedStatement.setInt(2, t.getMenu_id());
                preparedStatement.setInt(3, t.getQuantite());
                preparedStatement.executeUpdate();
                System.out.println("---------------------------------------------------Ligne commande ADDED");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else {

            String req = "UPDATE ligne_commande SET quantite =? where commande_id = ? and menu_id= ?";
            PreparedStatement preparedStatement;
            try {
                preparedStatement = connection.prepareStatement(req);
                preparedStatement.setInt(2, t.getCommande_id());
                preparedStatement.setInt(3, t.getMenu_id());
                preparedStatement.setInt(1, TestExist(t) + 1);

                preparedStatement.executeUpdate();
                System.out.println("---------------------------------------------------Ligne commande UPDAAATED");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        }

    }

    public void delete(LigneCommande t) {
        String req = "delete from ligne_commande where commande_id = ? and menu_id= ?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, t.getCommande_id());
            preparedStatement.setInt(2, t.getMenu_id());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void delete_by_commandeId(Integer r) {
        String req = "delete from ligne_commande where commande_id = ?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, r);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void update(LigneCommande t) {
        if ((TestExist(t) == 0)||(TestExist(t) == 1)) {
            delete(t);
        } else {
            String req = "update ligne_commande set quantite=? where commande_id = ? and menu_id= ?";
            PreparedStatement preparedStatement;

            try {
                preparedStatement = connection.prepareStatement(req);
                preparedStatement.setInt(2, t.getCommande_id());
                preparedStatement.setInt(3, t.getMenu_id());
                preparedStatement.setInt(1, TestExist(t) - 1);
                preparedStatement.executeUpdate();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

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
                LigneCommande m = new LigneCommande(resultSet.getInt("commande_id"), resultSet.getInt("menu_id"), resultSet.getInt("quantite"));
                meals.add(m);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return meals;
    }

    @Override
    public List<LigneCommande> GetCommandMeals(User u) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<LigneCommande> getByCommande(Integer t) {
        List<LigneCommande> meals = new ArrayList<>();
        String req = "select * from ligne_commande where commande_id=?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);

            preparedStatement.setInt(1, t);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                LigneCommande m = new LigneCommande(resultSet.getInt("commande_id"), resultSet.getInt("menu_id"), resultSet.getInt("quantite"));
                meals.add(m);

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return meals;
    }

    public List<LigneCommande> getByMenuId(Integer t) {
        List<LigneCommande> meals = null;
        String req = "select * from ligne_commande where menu_id=?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);

            preparedStatement.setInt(1, t);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                LigneCommande m = new LigneCommande(resultSet.getInt("commande_id"), resultSet.getInt("menu_id"), resultSet.getInt("quantite"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return meals;
    }

    @Override
    public LigneCommande search(LigneCommande t) {
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
