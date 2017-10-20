/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.IProfilService;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Profil;
import models.User;
import technique.DataSource;

/**
 *
 * @author YACINE
 */
public class ProfilService implements IProfilService {

    Connection connection;

    public ProfilService() {
        connection = DataSource.getInstance().getConnection();
    }

    @Override
    public void add(Profil p) {
        String req = "insert into profil (user_id,matiere_c,description,classe,path_img,path_cv,link_fb,link_ld,link_g,link_web,tel) values (?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, p.getU().getId());
            preparedStatement.setString(2, p.getMatiereC());
            preparedStatement.setString(3, p.getDescription());
            preparedStatement.setString(4, p.getClasse());
            preparedStatement.setString(5, p.getPathImg());
            preparedStatement.setString(6, p.getPathCv());
            preparedStatement.setString(7, p.getLinkFb());
            preparedStatement.setString(8, p.getLinkId());
            preparedStatement.setString(9, p.getLinkG());
            preparedStatement.setString(10, p.getLinkWeb());
            preparedStatement.setString(11, p.getTel());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void update(Profil p) {
        String req = "update profil set user_id=?,matiere_c=?,description=?,classe=?,path_img=?,path_cv=?,link_fb=?,link_ld=?,link_g=?,link_web=?,tel=? where id=?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, p.getU().getId());
            preparedStatement.setString(2, p.getMatiereC());
            preparedStatement.setString(3, p.getDescription());
            preparedStatement.setString(4, p.getClasse());
            preparedStatement.setString(5, p.getPathImg());
            preparedStatement.setString(6, p.getPathCv());
            preparedStatement.setString(7, p.getLinkFb());
            preparedStatement.setString(8, p.getLinkId());
            preparedStatement.setString(9, p.getLinkG());
            preparedStatement.setString(10, p.getLinkWeb());
            preparedStatement.setString(11, p.getTel());
            preparedStatement.setInt(12, p.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void delete(Integer i) {
        String req = "delete from profil where id=?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, i);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public List<Profil> getAll() {
        List<Profil> profils = new ArrayList<>();
        String req = "select * from profil";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Profil p = new Profil(resultSet.getInt("id"), new User(resultSet.getInt("user_id")), resultSet.getString("matiere_c"), resultSet.getString("description"), resultSet.getString("classe"), resultSet.getString("path_img"), resultSet.getString("path_cv"), resultSet.getString("link_fb"), resultSet.getString("link_ld"), resultSet.getString("link_g"), resultSet.getString("link_web"), resultSet.getString("tel"));
                profils.add(p);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return profils;
    }

    @Override
    public Profil getById(Integer i) {
        String req = "select * from profil where id=?";
        Profil p = null;
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, i);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                p = new Profil(resultSet.getInt("id"), new User(resultSet.getInt("user_id")), resultSet.getString("matiere_c"), resultSet.getString("description"), resultSet.getString("classe"), resultSet.getString("path_img"), resultSet.getString("path_cv"), resultSet.getString("link_fb"), resultSet.getString("link_ld"), resultSet.getString("link_g"), resultSet.getString("link_web"), resultSet.getString("tel"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return p;
    }

    @Override
    public Profil search(Profil p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
