/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.IClubService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Club;
import models.User;
import technique.DataSource;

/**
 *
 * @author Sami
 */
public class ClubService implements IClubService {

    Connection connection;

    public ClubService() {
        connection = DataSource.getInstance().getConnection();
    }

    @Override
    public void add(Club club) {
        String req = "insert into club (Libelle,Description,path_img,path_couverture,user_id) values (?,?,?,?,?)";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, club.getLibelle());
            preparedStatement.setString(2, club.getDescription());
            preparedStatement.setString(3, club.getPath_img());
            preparedStatement.setString(4, club.getPath_couverture());
            preparedStatement.setInt(5, 1);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void update(Club c) {
        String req = "update club set libelle=? ,description=? ,path_img=?,path_couverture=? ,user_id=? where id=? ";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);

            preparedStatement.setString(1, c.getLibelle());
            preparedStatement.setString(2, c.getDescription());
            preparedStatement.setString(3, c.getPath_img());
            preparedStatement.setString(4, c.getPath_couverture());
            preparedStatement.setInt(5, c.getUser().getId());
            preparedStatement.setInt(6, c.getId());
            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void delete(Integer r) {
        String req = "DELETE FROM `club` WHERE id=? ";
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
    public List<Club> getAll() {
        List<Club> club = new ArrayList<>();
        String req = "select * from club";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Club c = new Club(resultSet.getInt("id"), resultSet.getString("libelle"), resultSet.getString("description"), resultSet.getString("path_img"), resultSet.getString("path_couverture"), new User(resultSet.getInt("user_id")));
                club.add(c);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return club;
    }

    @Override
    public Club getById(Integer r) {
        Club club = null;
        String req = "select *from club where id=?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, r);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                club = new Club(resultSet.getInt("id"), resultSet.getString("libelle"), resultSet.getString("description"),
                        resultSet.getString("path_img"), resultSet.getString("path_couverture"), new User(resultSet.getInt("user_id")));
                //System.out.println(club);

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return club;
    }

    @Override
    public Club search(Club c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
