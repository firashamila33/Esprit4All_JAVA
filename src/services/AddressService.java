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
            String req = "insert into Address(city,street,homeNumber,furtherAddressDescription) values(?,?,?,?)";

            PreparedStatement ps = dataSource.getConnection().prepareStatement(req, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, t.getCity());
            ps.setString(2, t.getStreet());
            ps.setString(3, t.getHomeNumber());
            ps.setString(4, t.getFurtherAddressDescription());
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
            String req = "Update  Address set city = ? , street = ? ,homeNumber = ?,furtherAddressDescription = ?  where id = ?";

            PreparedStatement ps = dataSource.getConnection().prepareStatement(req);
            ps.setString(1, t.getCity());
            ps.setString(2, t.getStreet());
            ps.setString(3, t.getHomeNumber());
            ps.setString(4, t.getFurtherAddressDescription());
            ps.setInt(5, t.getId());
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
        List<Address> result = new ArrayList<>();
        try {
            String req = "select * from Address";

            PreparedStatement ps = dataSource.getConnection().prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Address element = new Address(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
                element.setId(rs.getInt(1));
                result.add(element);
            }

        } catch (SQLException ex) {
            System.out.println("Error" + ex);
        }
        return result;

    }

    @Override
    public Address getById(Integer r) {
        try {
            String req = "select * from Address where id=?";

            PreparedStatement ps = dataSource.getConnection().prepareStatement(req);
            ps.setInt(1, r);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                
                 Address result = new Address(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
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
