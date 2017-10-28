/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.iutilisateur_accept_revision;
import java.security.Provider;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import models.Revision;
import models.utilisateur_accept_revision;
import technique.DataSource;

/**
 *
 * @author asus
 */
public class Sutilisateur_accept_revision implements iutilisateur_accept_revision {
 Connection connection;

    public Sutilisateur_accept_revision() {
        connection = DataSource.getInstance().getConnection();

    }
    @Override
    public void add(utilisateur_accept_revision t) {
        String req = "insert into utilisateur_accept_revision (revision_id,user_id,acceptation) values (?,?,?)";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
                        preparedStatement.setInt(1, t.getId());

            preparedStatement.setInt(2,t.getId());
                        preparedStatement.setInt(3,t.getAcceptation());

           


            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void delete(Integer r) {
 String req = "delete from  utilisateur_accept_revision  where user_id =?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, r);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }    }

    @Override
    public void update(utilisateur_accept_revision t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<utilisateur_accept_revision> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public utilisateur_accept_revision getById(Integer r) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public utilisateur_accept_revision search(utilisateur_accept_revision t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}