/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.IEvenementService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Evenement;
import technique.DataSource;

/**
 *
 * @author majdi
 */
public class EvenementService implements IEvenementService {

    Connection connection;

    public EvenementService() {
        connection = DataSource.getInstance().getConnection();
    }

    @Override
    public void add(Evenement e) {

        String req;
        PreparedStatement preparedStatement;
        if (e.getClub() != null) {
            req = "insert into evenement (libelle,type,Description,date,path_img,club_id) values (?,?,?,?,?,?)";
        } else {
            req = "insert into evenement (libelle,type,Description,date,path_img) values (?,?,?,?,?)";
        }

        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, e.getLiblle());
            preparedStatement.setString(2, e.getType());
            preparedStatement.setString(3, e.getDescription());
            preparedStatement.setDate(4, e.getDate());
            preparedStatement.setString(5, e.getPath_img());
            if (e.getClub() != null) {
                preparedStatement.setInt(6, e.getClub().getId());
            }
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public void delete(Integer id
    ) {
        String req = "delete  from evenement where id=?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<Evenement> getAll() {
        List<Evenement> even = new ArrayList<>();
        String req = "select * from evenement";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Evenement e = new Evenement(resultSet.getInt("id"), resultSet.getString("libelle"), resultSet.getString("type"), resultSet.getString("description"), resultSet.getDate("date"), resultSet.getString("path_img"), new ClubService().getById(resultSet.getInt("Club_id")));
             
                even.add(e);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return even;
    }

    @Override
    public void update(Evenement e) {
        String req;
        PreparedStatement preparedStatement;
        if (e.getClub() != null) {
            req = "update evenement set libelle=? ,type=? ,description=? ,date=? ,path_img=? ,club_id=? where id=? ";
        } else {
            req = "update evenement set libelle=? ,type=? ,description=? ,date=? ,path_img=?  where id=? ";
        }

        try {
            preparedStatement = connection.prepareStatement(req);

            preparedStatement.setString(1, e.getLiblle());
            preparedStatement.setString(2, e.getType());
            preparedStatement.setString(3, e.getDescription());
            preparedStatement.setDate(4, e.getDate());
            preparedStatement.setString(5, e.getPath_img());
            if (e.getClub() != null) {
                preparedStatement.setInt(6, e.getClub().getId());
                preparedStatement.setInt(7, e.getId());
            } else {

                preparedStatement.setInt(6, e.getId());
            }

            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Evenement getById(Integer r
    ) {
        Evenement ev = null;
        String req = "select *from evenement where id=?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, r);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                ev = new Evenement(resultSet.getInt("id"), resultSet.getString("libelle"), resultSet.getString("type"), resultSet.getString("description"), resultSet.getDate("date"),
                        resultSet.getString("path_img"), new ClubService().getById(resultSet.getInt("club_id")));
                System.out.println(ev);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return ev;
    }
 
    public List<Evenement> getByGroupe(Integer r) {
        
         List<Evenement> events = new ArrayList<>();
        String req = "select *from evenement where club_id=?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, r);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
               
                Evenement ev = new Evenement(resultSet.getInt("id"),resultSet.getString("libelle"), resultSet.getString("type"), resultSet.getString("description"), resultSet.getDate("date"),
                        resultSet.getString("path_img"), new ClubService().getById(resultSet.getInt("club_id")));
                events.add(ev);
                
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return events;
    }

    @Override
    public Evenement search(Evenement t
    ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
