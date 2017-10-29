/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.IAnnonceObjetPerduService;
import interfaces.IUserService;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import models.AnnonceObjetPerdu;
import models.User;
import technique.DataSource;
import java.util.ArrayList;

/**
 *
 * @author kadhem
 */
public class AnnonceObjetPerduService implements IAnnonceObjetPerduService {

    DataSource dataSource = DataSource.getInstance();

 
    @Override
    public void add(AnnonceObjetPerdu t) {

        try {
            String req = "insert into AnnonceObjetPerdu(name,description,owner_id,creationDate,expirationDate,objectDescription,lossDate,lossLocation) values(?,?,?,?,?,?,?,?)";

            PreparedStatement ps = dataSource.getConnection().prepareStatement(req, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, t.getName());
            ps.setString(2, t.getDescription());
            ps.setInt(3, t.getOwner().getId());
            ps.setDate(4, t.getCreationDate());
            ps.setDate(5, t.getExpirationDate());
            ps.setString(6, t.getObjetDescription());
            ps.setDate(7, t.getLossDate());
            ps.setString(8, t.getLossLocation());

            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();

            t.setId(rs.getInt((1)));

        } catch (SQLException ex) {
            System.out.println("Error " + ex);
        }
    }

    @Override
    public void update(AnnonceObjetPerdu t) {

        try {
            String req = "update  AnnonceObjetPerdu set name=? ,description =?,owner_id=?,creationDate=?,expirationDate=?,objectDescription=?,lossDate=?,lossLocation=? where id=?";

            PreparedStatement ps = dataSource.getConnection().prepareStatement(req);
            ps.setString(1, t.getName());
            ps.setString(2, t.getDescription());
            ps.setInt(3, t.getOwner().getId());
            ps.setDate(4, t.getCreationDate());
            ps.setDate(5, t.getExpirationDate());
            ps.setString(6, t.getObjetDescription());
            ps.setDate(7, t.getLossDate());
            ps.setString(8, t.getLossLocation());

            ps.setInt(9, t.getId());
            ps.executeUpdate();

        } catch (SQLException ex) {
            System.out.println("Error " + ex);
        }
    }

    @Override
    public void delete(Integer r) {
        try {
            String req = "delete from AnnonceObjetPerdu where id=?";
            PreparedStatement ps = dataSource.getConnection().prepareStatement(req);
            ps.setInt(1, r);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error " + ex);
        }
    }

    @Override
    public List<AnnonceObjetPerdu> getAll() {
        List<AnnonceObjetPerdu> result = new ArrayList<>();
        IUserService userService = new UserService();
        try {
            String req = "select * from AnnonceObjetPerdu";

            PreparedStatement ps = dataSource.getConnection().prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                AnnonceObjetPerdu element = new AnnonceObjetPerdu(rs.getString("objectDescription"),
                        rs.getDate("lossDate"), rs.getString("lossLocation"), rs.getString("name"),
                        rs.getString("description"), userService.getUserById(rs.getInt("owner_id")), rs.getDate("creationDate"), rs.getDate("expirationDate"));
                //AnnonceObjetPerdu element = new AnnonceObjetPerdu(rs.getString("objectDescription"),
                //        rs.getDate("lossDate"), rs.getString("lossLocation"), rs.getString("name"),
                //        rs.getString("description"), new User(rs.getInt("owner_id")), rs.getDate("creationDate"), rs.getDate("expirationDate"));

                element.setId(rs.getInt(1));
                result.add(element);
            }

        } catch (SQLException ex) {
            System.out.println("Error" + ex);
        }
        return result;
    }

    @Override
    public AnnonceObjetPerdu getById(Integer r) {
        try {
            String req = "select * from AnnonceObjetPerdu where id=?";

            PreparedStatement ps = dataSource.getConnection().prepareStatement(req);
            ps.setInt(1, r);
             IUserService userService = new UserService();
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                AnnonceObjetPerdu result = new AnnonceObjetPerdu(rs.getString("objectDescription"),
                        rs.getDate("lossDate"), rs.getString("lossLocation"), rs.getString("name"),
                        rs.getString("description"), userService.getUserById(rs.getInt("owner_id")), rs.getDate("creationDate"), rs.getDate("expirationDate"));
                //AnnonceObjetPerdu result = new AnnonceObjetPerdu(rs.getString("objectDescription"),
                //        rs.getDate("lossDate"), rs.getString("lossLocation"), rs.getString("name"),
                //        rs.getString("description"), new User(rs.getInt("owner_id")), rs.getDate("creationDate"), rs.getDate("expirationDate"));

                result.setId(rs.getInt(1));
                return result;
            } else {
                return null;
            }

        } catch (SQLException ex) {
            System.out.println("Error" + ex);
        }
        return null;
    }

    @Override
    public AnnonceObjetPerdu search(AnnonceObjetPerdu t) {
        return getById(t.getId());
    }

}
