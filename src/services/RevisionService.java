/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.IServiceRevision;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Revision;
import models.User;
import technique.DataSource;

/**
 *
 * @author asus
 */
public class RevisionService implements IServiceRevision {

    Connection connection;

    public RevisionService() {
        connection = DataSource.getInstance().getConnection();

    }

    @Override
    public void add(Revision t) {
        String req = "insert into revision (user_id,matiere,date_debut,date_fin,description,nbremax,type) values (?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, t.getUser().getId());
            preparedStatement.setString(2, t.getMatiere());
            preparedStatement.setDate(3, t.getDate_debut());
            preparedStatement.setDate(4, t.getDate_fin());
            preparedStatement.setString(5, t.getDescription());
            preparedStatement.setInt(6, t.getNbrmax());
            preparedStatement.setString(7, t.getType());

            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Revision getById(Integer r) {
        Revision re = null;
        String req = "select * from  revision where user_id=?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, r);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                   User u = new User(resultSet.getInt("user_id"));
                re = new Revision(resultSet.getInt("id"), u, resultSet.getString("matiere"), resultSet.getDate("date_debut"), resultSet.getString("description"), resultSet.getInt("nbremax"), resultSet.getString("type"), resultSet.getDate("date_fin"));
                System.out.println(re);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return re;
    }

    @Override
    public List<Revision> getAll() {
        List<Revision> revision = new ArrayList<>();

        String req = "select * from  revision";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User u = new User(resultSet.getInt("user_id"));
                Revision r = new Revision(resultSet.getInt("id"), u, resultSet.getString("matiere"), resultSet.getDate("date_debut"), resultSet.getString("description"), resultSet.getInt("nbremax"), resultSet.getString("type"), resultSet.getDate("date_fin"));
                revision.add(r);
                System.out.println(r);

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return revision;
    }

    @Override
    public void delete(Integer r) {
        String req = "delete from  revision where user_id =?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, r);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void update(Revision t) {
        String req = "update  revision set matiere=?, date_debut =?,date_fin=?, description=?,nbremax=?,type=? where id = ?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, t.getMatiere());
            preparedStatement.setDate(2, t.getDate_debut());
            preparedStatement.setDate(3, t.getDate_fin());
            preparedStatement.setString(4, t.getDescription());
            preparedStatement.setInt(5, t.getNbrmax());
            preparedStatement.setString(6, t.getType());

            preparedStatement.setInt(7, t.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public Revision search2(Integer r) {
         Revision re = null;
        String req = "select * from  revision where id=?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, r);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User u = new User(resultSet.getInt(2));
                re = new Revision(resultSet.getInt("id"), u, resultSet.getString("matiere"), resultSet.getDate("date_debut"), resultSet.getString("description"), resultSet.getInt("nbremax"), resultSet.getString("type"), resultSet.getDate("date_fin"));
                System.out.println(re);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return re;
    }

    @Override
    public Revision search(Revision t) {
 Revision re = null;
        String req = "select * from  revision where type=?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, t.getType());
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User u = new User(resultSet.getInt(2));
                re = new Revision(resultSet.getInt("id"), u, resultSet.getString("matiere"), resultSet.getDate("date_debut"), resultSet.getString("description"), resultSet.getInt("nbremax"), resultSet.getString("type"), resultSet.getDate("date_fin"));
                System.out.println(re);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return re;    }

   
    }

   


