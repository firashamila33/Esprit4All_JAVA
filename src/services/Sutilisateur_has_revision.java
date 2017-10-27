/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.IServiceRevision;
import interfaces.IUtilisateur_has_revision;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import models.Revision;
import models.utilisateur_has_revision;
import technique.DataSource;

/**
 *
 * @author asus
 */
public class Sutilisateur_has_revision implements IUtilisateur_has_revision {

    Connection connection;

    public Sutilisateur_has_revision() {
        connection = DataSource.getInstance().getConnection();

    }

    @Override
    public void delete(Integer r) {
        String req = "delete from  utilisateur_has_revision where user_id =?";
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
    public void add(utilisateur_has_revision t) {
        String req = "insert into utilisateur_has_revision (revision_id,user_id) values (?,?)";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, t.getRevision().getId());

            preparedStatement.setInt(2, t.getUser().getId());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void update(utilisateur_has_revision t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<models.utilisateur_has_revision> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public models.utilisateur_has_revision getById(Integer r) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public models.utilisateur_has_revision search(models.utilisateur_has_revision t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
