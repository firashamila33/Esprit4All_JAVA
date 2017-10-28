/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.sql.PreparedStatement;
import interfaces.IServiceDocumentAdministratif;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.User;
import models.DocumentAdministratif;
import technique.DataSource;

/**
 *
 * @author asus
 */
public class DocumentAdministratifService implements IServiceDocumentAdministratif {

    Connection connection;

    public DocumentAdministratifService() {
        connection = DataSource.getInstance().getConnection();

    }

    @Override
    public void add(DocumentAdministratif t) {
        String req = "insert into documentadministratif (user_id,type,quantite,confirmation) values (?,?,?,?)";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);

            preparedStatement.setInt(1, t.getUser().getId());
            preparedStatement.setString(2, t.getType());
            preparedStatement.setString(3, t.getQuantite());
            preparedStatement.setBoolean(4, t.isConfirmation());

            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /**
     *
     * @param r
     * @return
     */
    @Override
    public DocumentAdministratif getById(Integer r) {
        DocumentAdministratif documentAdministratif = null;
        String req = "select * from  documentadministratif where id=?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, r);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User u = new User(resultSet.getInt(2));
                documentAdministratif = new DocumentAdministratif(resultSet.getInt("id"), u, resultSet.getString(3), resultSet.getString(4), resultSet.getBoolean(5));

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return documentAdministratif;
    }

    @Override
    public List<DocumentAdministratif> getAll() {
        List<DocumentAdministratif> documentAdministratifs = new ArrayList<>();

        String req = "select * from documentadministratif";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User u = new User(resultSet.getInt(1));
                DocumentAdministratif r = new DocumentAdministratif(resultSet.getInt("id"), u, resultSet.getString(3), resultSet.getString(4), resultSet.getBoolean(5));

                documentAdministratifs.add(r);

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return documentAdministratifs;
    }

    @Override
    public void delete(Integer r) {
        String req = "delete from  documentadministratif where id =?";
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
    public void update(DocumentAdministratif t) {
        String req = "update  documentadministratif  set  type=?,quantite=?,confirmation=? where id = ?";
        java.sql.PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, t.getType());
            preparedStatement.setString(2, t.getQuantite());
            preparedStatement.setBoolean(3, t.isConfirmation());

            preparedStatement.setInt(4, t.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public DocumentAdministratif search(DocumentAdministratif t) {
        DocumentAdministratif x = null;
        String req = "select * from documentadministratif where type=?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, t.getType());
            ResultSet resultSet = preparedStatement.executeQuery();
            User u = new User(resultSet.getInt(1));
            x = new DocumentAdministratif(resultSet.getInt("id"), u, resultSet.getString(3), resultSet.getString(4), resultSet.getBoolean(5));
        } catch (SQLException ex) {
            Logger.getLogger(RevisionService.class.getName()).log(Level.SEVERE, null, ex);
        }

        return x;
    }
}
