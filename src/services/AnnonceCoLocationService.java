/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.IAddressService;
import java.util.List;
import models.AnnonceCoLocation;
import interfaces.IAnnonceCoLocationService;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import models.User;
import technique.DataSource;

/**
 *
 * @author kadhem
 */
public class AnnonceCoLocationService implements IAnnonceCoLocationService {

    private DataSource dataSource = DataSource.getInstance();

    @Override
    public void add(AnnonceCoLocation t) {

        try {
            String req = "insert into AnnonceCoLocation(address_id,dimensions,maxCoLocataire, loyer,name,description,owner_id,creationDate,expirationDate) values(?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = dataSource.getConnection().prepareStatement(req, PreparedStatement.RETURN_GENERATED_KEYS);

            IAddressService addressService = new AddressService();
            addressService.add(t.getAddress());

            ps.setInt(1, t.getAddress().getId());
            ps.setString(2, t.getDimensions());
            ps.setInt(3, t.getMaxCoLocataire());
            ps.setFloat(4, t.getLoyer());

            ps.setString(5, t.getName());
            ps.setString(6, t.getDescription());
            ps.setInt(7, t.getOwner().getId());
            ps.setDate(8, t.getCreationDate());
            ps.setDate(9, t.getExpirationDate());

            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();

            t.setId(rs.getInt((1)));
            // adding the Images
            String reqImageTable = "insert into ImageAnnonce(annonceCoLocation_id,imageUrl) values(?,?)";
            PreparedStatement psImages = dataSource.getConnection().prepareStatement(reqImageTable);
            for (String photo : t.getPhotosUrls()) {
                psImages.setInt(1, t.getId());
                psImages.setString(2,photo);
                psImages.executeUpdate();
            }
            //adding "les Colocataires"
            String reqCoLocatairesTable = "insert into AnnonceCoLocataire_R(annonceCoLocation_id,User_id) values(?,?)";
            PreparedStatement psCoLocataires = dataSource.getConnection().prepareStatement(reqCoLocatairesTable);
            for (User u : t.getCoLocataires()) {
                psCoLocataires.setInt(1, t.getId());
                psCoLocataires.setInt(2,u.getId());
                psCoLocataires.executeUpdate();
            }

        } catch (SQLException ex) {
            System.out.println("Error " + ex);
        }

    }

    @Override
    public void update(AnnonceCoLocation t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Integer r) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<AnnonceCoLocation> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AnnonceCoLocation getById(Integer r) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public AnnonceCoLocation search(AnnonceCoLocation t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
