/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import technique.DataSource;
import interfaces.IUserService;
import java.sql.Connection;
import models.User;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import technique.DataSource;
import utils.BCrypt;

/**
 *
 * @author YACINE
 */
public class UserService implements IUserService {

    Connection connection;

    public UserService() {
        connection = DataSource.getInstance().getConnection();
    }

    @Override
    public void register(User u) {
        String req = "insert into user (username,username_canonical,email,email_canonical,enabled,password,nom,prenom,date_naissance,cin,adress,roles) values (?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, u.getUsername());
            preparedStatement.setString(2, u.getUsername());
            preparedStatement.setString(3, u.getEmail());
            preparedStatement.setString(4, u.getEmail());
            preparedStatement.setInt(5, u.getEnabled());
            preparedStatement.setString(6, u.getPassword());
            //preparedStatement.setArray(5, u.getRoles());
            preparedStatement.setString(7, u.getNom());
            preparedStatement.setString(8, u.getPrenom());
            preparedStatement.setDate(9, u.getDateNaissance());
            preparedStatement.setString(10, u.getCin());
            preparedStatement.setString(11, u.getAdresse());
            preparedStatement.setString(12, "a:0:{}");
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public void Login(String username, String password) {
        String req = "select * from user where username=?";

        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next() == false) {
                System.out.println("Mot de passe ou username incorrecte");
            } else {
                while (resultSet.next()) {

                    String psw = resultSet.getString("password");
                    boolean matched = BCrypt.checkpw(password, psw);
                    if (matched) {
                        System.out.println("Bienvenue");
                    } else {
                        System.out.println("Mot de passe ou username incorrecte");
                    }
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public void disable(User u) {
        String req = "update user set enabled=? where username=?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, 0);
            preparedStatement.setString(2, u.getUsername());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void enable(User u) {
        String req = "update user set enabled=? where username=?";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, 1);
            preparedStatement.setString(2, u.getUsername());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public User search(User u) {
        return u;
    }

    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        String req = "select * from user";
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                User user;
                user = new User(resultSet.getInt("id"), resultSet.getString("username"), resultSet.getString("email"), resultSet.getInt("enabled"), resultSet.getString("password"), resultSet.getString("nom"), resultSet.getString("prenom"), resultSet.getDate("date_naissance"), resultSet.getString("cin"), resultSet.getString("adress"));
                users.add(user);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return users;
    }

    @Override
    public User getUserById(Integer i) {
        String req = "select * from user where id=?";
        User u = null;
        PreparedStatement preparedStatement;
        try {
            preparedStatement = connection.prepareStatement(req);
            preparedStatement.setInt(1, i);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                u = new User(resultSet.getInt("id"), resultSet.getString("username"), resultSet.getString("email"), resultSet.getInt("enabled"), resultSet.getString("password"), resultSet.getString("nom"), resultSet.getString("prenom"), resultSet.getDate("date_naissance"), resultSet.getString("cin"), resultSet.getString("adress"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return u;
    }
}
