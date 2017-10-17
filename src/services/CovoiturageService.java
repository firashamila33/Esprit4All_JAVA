/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.ICovoiturageService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Covoiturage;
import technique.DataSource;

/**
 *
 * @author YACINE
 */
public class CovoiturageService implements ICovoiturageService {

    Connection connection;

    public CovoiturageService() {
        connection = DataSource.getInstance().getConnection();
    }

    @Override
    public void delete(Integer r) {
        String req = "delete from covoiturage where id=?";
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
    public List<Covoiturage> getAll() {
        List<Covoiturage> emp = new ArrayList<>();
        String req = "select * from covoiturage";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Covoiturage c = new Covoiturage(resultSet.getInt("id"), resultSet.getInt("user_id"), resultSet.getString("type"), resultSet.getDouble("prix"), resultSet.getString("depart"), resultSet.getString("arrive"), resultSet.getString("description"), resultSet.getInt("nbreplace"), resultSet.getString("heure_depart"));
                emp.add(c);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return emp;
    }

    @Override
    public Covoiturage getById(Integer r) {
        String req = "select * from covoiturage where id=?";
        Covoiturage c = null;
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, r);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                c = new Covoiturage(resultSet.getInt("id"), resultSet.getInt("user_id"), resultSet.getString("type"), resultSet.getDouble("prix"), resultSet.getString("depart"), resultSet.getString("arrive"), resultSet.getString("description"), resultSet.getInt("nbreplace"), resultSet.getString("heure_depart"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return c;
    }

    @Override
    public void update(Covoiturage t) {
        String req = "update covoiturage set user_id=?,type=?,prix=?,depart=?,arrive=?,description=?,nbreplace=?,heure_depart=? where id=?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, t.getUserId());
            preparedStatement.setString(2, t.getType());
            preparedStatement.setDouble(3, t.getPrix());
            preparedStatement.setString(4, t.getDepart());
            preparedStatement.setString(5, t.getArrivé());
            preparedStatement.setString(6, t.getDescription());
            preparedStatement.setInt(7, t.getNbrePlace());
            preparedStatement.setString(8, t.getHeureDépart());
            preparedStatement.setInt(9, t.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void add(Covoiturage t) {
        String req = "insert into covoiturage(user_id,type,prix,depart,arrive,description,nbreplace,heure_depart) values (?,?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, t.getUserId());
            preparedStatement.setString(2, t.getType());
            preparedStatement.setDouble(3, t.getPrix());
            preparedStatement.setString(4, t.getDepart());
            preparedStatement.setString(5, t.getArrivé());
            preparedStatement.setString(6, t.getDescription());
            preparedStatement.setInt(7, t.getNbrePlace());
            preparedStatement.setString(8, t.getHeureDépart());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Covoiturage search(Covoiturage t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
