/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Club;
import models.Membre;
import models.User;
import technique.DataSource;

/**
 *
 * @author Sami
 */
public class MembreService {
    
     Connection connection;

    public MembreService() {
        connection = DataSource.getInstance().getConnection();
    }

    public void add(Membre m) {
        String req = "insert into membre (club_id,user_id,role) values (?,?,?)";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, m.getClub().getId());
            preparedStatement.setInt(2, m.getUser().getId());
            preparedStatement.setString(3, m.getRole());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void delete(Membre m) {
        String req = "DELETE FROM `membre` WHERE club_id=? and user_id=?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, m.getClub().getId());
            preparedStatement.setInt(2, m.getUser().getId());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public List<Membre> getByClub(Club c) {
        List<Membre> membres = new ArrayList<>();
        
        String req = "select * from membre where club_id=?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, c.getId());
            java.sql.ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {    
              Membre  membre = new Membre(new ClubService().getById(resultSet.getInt("club_id")),new UserService().getUserById(resultSet.getInt("user_id")),resultSet.getString("role"));
                membres.add(membre);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return membres;
    }
    
       public List<Membre> getAll() {
        List<Membre> membre = new ArrayList<>();
        String req = "select * from membre";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            java.sql.ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                 Membre m = new Membre(new ClubService().getById(resultSet.getInt("club_id")),new UserService().getUserById(resultSet.getInt("user_id")),resultSet.getString("role"));
               
                membre.add(m);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return membre;
    }

    
    
}
