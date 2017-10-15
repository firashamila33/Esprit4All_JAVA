/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.IServiceRevision;
import tests.Esprit4All.technique.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import models.Revision;
import models.User;

/**
 *
 * @author asus
 */
public class RevisionService implements IServiceRevision {

    Connection connection;

    public RevisionService() {
        connection = DataSource.getInsatance().getConnection();

    }

    @Override
    public void add(Revision t) {
        String req = "insert into espritforall (user,matiere,datetime,description,nbrmax,type) values (?,?,?,?,?,?)";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, t.getUser().getId());
            preparedStatement.setString(2, t.getMatiere());
            preparedStatement.setDate(3, t.getDatetime());
            preparedStatement.setString(4, t.getDescription());
            preparedStatement.setInt(5, t.getNbrmax());
            preparedStatement.setString(6, t.getType());

            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Revision findById(Integer r) {
      Revision Revision = null;
        String req = "select * from espritforall where id=?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, r);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User u = new User(resultSet.getInt(2));
                Revision = new Revision(resultSet.getInt("id"), u, resultSet.getString(3), resultSet.getDate(4), resultSet.getString(5), resultSet.getInt(6), resultSet.getString(7));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return Revision;
    }

    @Override
    public List<Revision> getAll() {
String req = "select * from espritforall";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User u=new User(resultSet.getInt(2));
                Revision revision = new Revision(resultSet.getInt("id"),  u, resultSet.getString(3), resultSet.getDate(4), resultSet.getString(5), resultSet.getInt(6), resultSet.getString(7));
                employees.add(employee);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return employees;    }

    @Override
    public void delete(Integer r) {
        String req = "delete from espritforall where id =?";
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
        String req = "update espritforall set matiere=?, datetime =?, description=?,nbrmax=?,type=? where id = ?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, t.getMatiere());
            preparedStatement.setDate(2, t.getDatetime());
            preparedStatement.setString(3, t.getDescription());
            preparedStatement.setInt(4, t.getNbrmax());
            preparedStatement.setString(5, t.getType());

            preparedStatement.setInt(6, t.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

        
}
