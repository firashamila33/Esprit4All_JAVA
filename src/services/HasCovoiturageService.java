/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.IHasCovoiturage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Covoiturage;
import models.HasCovoiturage;
import models.User;
import technique.DataSource;

/**
 *
 * @author YACINE
 */
public class HasCovoiturageService implements IHasCovoiturage {

    Connection connection;

    public HasCovoiturageService() {
        connection = DataSource.getInstance().getConnection();
    }

    @Override
    public HasCovoiturage search(HasCovoiturage t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public HasCovoiturage getById(Integer r) {
        String req = "select * from  utilisateur_has_covoiturage where id=?";
        HasCovoiturage hasCovoiturage = null;
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, r);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                hasCovoiturage = new HasCovoiturage(resultSet.getInt("id"), new Covoiturage(resultSet.getInt("covoiturage_id")), new User(resultSet.getInt("user_id")));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return hasCovoiturage;
    }

    @Override
    public List<HasCovoiturage> getAll() {
        List<HasCovoiturage> hasCovoiturages = new ArrayList<>();
        String req = "select * from utilisateur_has_covoiturage";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                HasCovoiturage hasCovoiturage = new HasCovoiturage(resultSet.getInt("id"), new Covoiturage(resultSet.getInt("covoiturage_id")), new User(resultSet.getInt("user_id")));
                hasCovoiturages.add(hasCovoiturage);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return hasCovoiturages;
    }

    @Override
    public void delete(Integer r) {
        String req = "delete from utilisateur_has_covoituragewhere id=?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareCall(req);
            preparedStatement.setInt(1, r);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void update(HasCovoiturage t) {
        String req = "update utilisateur_has_covoiturage set covoiturage_id=?,user_id=? where id=?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareCall(req);
            preparedStatement.setInt(1, t.getCovoiturage().getId());
            preparedStatement.setInt(2, t.getU().getId());
            preparedStatement.setInt(3, t.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void add(HasCovoiturage t) {
        String req = "insert into utilisateur_has_covoiturage (covoiturage_id,user_id) values (?,?)";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareCall(req);
            preparedStatement.setInt(1, t.getCovoiturage().getId());
            preparedStatement.setInt(2, t.getU().getId());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
