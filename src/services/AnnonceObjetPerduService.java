/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.IAnnonceObjetPerduService;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import models.AnnonceObjetPerdu;
import technique.DataSource;

/**
 *
 * @author kadhem
 */
    public class AnnonceObjetPerduService implements IAnnonceObjetPerduService{
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
            ps.setString(6,t.getObjetDescription());
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
            ps.setString(6,t.getObjetDescription());
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AnnonceObjetPerdu getById(Integer r) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AnnonceObjetPerdu search(AnnonceObjetPerdu t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
