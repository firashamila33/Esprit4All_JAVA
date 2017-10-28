/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.InoteRevision;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Commande;
import models.Revision;
import models.User;
import models.note_revision;
import technique.DataSource;

/**
 *
 * @author asus
 */
public class NoteRevision implements InoteRevision{
      Connection connection;

    public NoteRevision() {
        connection = DataSource.getInstance().getConnection();
    }

    @Override
    public void add(note_revision t) {
         String req = "insert into note_revision (revision_id,user_id,note) values (?,?,?)";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, t.getRevision().getId());
            preparedStatement.setInt(2, t.getUser().getId());
            preparedStatement.setFloat(3, t.getNote());
          
             preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
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
        }    }

    @Override
    public note_revision getById(Integer r) {
   note_revision re = null;
        String req = "select * from  note_revision where user_id=?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, r);
            java.sql.ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                re = new note_revision(resultSet.getInt("id"), new Revision(resultSet.getInt("revision_id")), new User(resultSet.getInt("user_id")),resultSet.getInt("note"));
  
                
                
            System.out.println(re);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return re ;    }

    @Override
    public List<note_revision> getAll() {
 
        List<note_revision> revision = new ArrayList<>();
note_revision x= null;

        String req = "select * from  note_revision";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
      
            java.sql.ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
               x = new note_revision(resultSet.getInt("id"), new Revision(resultSet.getInt("revision_id")),new User (resultSet.getInt("user_id")),resultSet.getInt("note"));
                               revision.add(x);

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return revision;
    }
    @Override
    public note_revision search(note_revision t) {
          return null;

 
    }

    @Override
    public void update(note_revision t) {
 String req = "update  note_revision set revision_id=?, user_id =?, note=? where id = ?";
       PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, t.getRevision().getId());
            preparedStatement.setInt(2, t.getUser().getId());
            preparedStatement.setFloat(3, t.getNote());
          
             preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }    }
    
}
