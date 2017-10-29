/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import java.util.List;
import models.Address;
import interfaces.IAddressService;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import technique.DataSource;

/**
 *
 * @author kadhem
 */
public class AddressService implements IAddressService {

    private DataSource dataSource = DataSource.getInstance();

    @Override
    public void add(Address t) {

        try {
            String req = "insert into Address(lat,lng) values(?,?)";

            PreparedStatement ps = dataSource.getConnection().prepareStatement(req, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setDouble(1, t.getLat());
            ps.setDouble(2, t.getLng());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();

            t.setId(rs.getInt((1)));

        } catch (SQLException ex) {
            System.out.println("Error " + ex);
        }
    }

    @Override
    public void update(Address t) {
        try {
            String req = "Update  Address set lat=?, lng=? where id = ?;";

            PreparedStatement ps = dataSource.getConnection().prepareStatement(req);
            ps.setDouble(1, t.getLat());
            ps.setDouble(2, t.getLng());
            
            ps.setInt(3, t.getId());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex + "\n");
        }
    }

    @Override
    public void delete(Integer r) {
        try {
            String req = "delete from Address where id=?";
            PreparedStatement ps = dataSource.getConnection().prepareStatement(req);
            ps.setInt(1, r);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error " + ex);
        }
    }

    @Override
    public List<Address> getAll() {
        return null;

    }

    @Override
    public Address getById(Integer r) {
        try {
            String req = "select * from Address where id=?";

            PreparedStatement ps = dataSource.getConnection().prepareStatement(req);
            ps.setInt(1, r);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                
                 Address result = new Address(rs.getDouble("lat"),rs.getDouble("lng"));
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
    public Address search(Address t) {
        return getById(t.getId());
    }

}
