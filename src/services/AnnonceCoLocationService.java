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
import interfaces.IServices;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.User;
import technique.DataSource;

/**
 *
 * @author kadhem
 */
public class AnnonceCoLocationService implements IAnnonceCoLocationService {

    private DataSource dataSource = DataSource.getInstance();

    class ImageService {

        private String insertReq = "insert into ImageAnnonce(annonceCoLocation_id,imageUrl) values(?,?)";
        private PreparedStatement insertPs;
        private String deleteReq = "delete from ImageAnnonce where annonceCoLocation_id=? ,imageUrl=?";
        private PreparedStatement deletePs;
        private String selectReq = "select imageUrl from ImageAnnonce where annonceCoLocation_id=?";
        private PreparedStatement selectPs;

        public ImageService() {

            try {
                insertPs = dataSource.getConnection().prepareStatement(insertReq);
                deletePs = dataSource.getConnection().prepareStatement(deleteReq);
                selectPs = dataSource.getConnection().prepareStatement(selectReq);
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }

        void add(String url, int annonceCoLocationId) {

            try {
                insertPs.setInt(1, annonceCoLocationId);
                insertPs.setString(2, url);
                insertPs.executeUpdate();
            } catch (SQLException ex) {
                System.out.println(ex);
            }

        }

        void remove(String url, int annonceCoLocationId) {
            try {
                deletePs.setInt(1, annonceCoLocationId);
                deletePs.setString(2, url);
                deletePs.executeUpdate();
            } catch (SQLException ex) {
                System.err.println(ex);
            }

        }

        List<String> getAllPhotos(int annonceCoLocationId) {
            List result = new ArrayList();
            try {

                selectPs.setInt(1, annonceCoLocationId);
                ResultSet rs = selectPs.executeQuery();
                while (rs.next()) {
                    result.add(rs.getString("imageUrl"));
                }

            } catch (SQLException ex) {
                System.err.println(ex);
            }
            return result;
        }

    }

    class CoLocataire {

        private String insertReq = "insert into AnnonceCoLocataire_R(annonceCoLocation_id,User_id) values(?,?)";
        private PreparedStatement insertPS;
        private String deleteReq = "delete from AnnonceCoLocataire_R where annonceCoLocation_id=? User_id=?";
        private PreparedStatement deletePS;
        private String selectReq = "select User_id from AnnonceCoLocataire_R where annonceCoLocation_id=?";
        private PreparedStatement selectPS;
        public CoLocataire(){
            try {
                insertPS = dataSource.getConnection().prepareStatement(insertReq);
                deletePS = dataSource.getConnection().prepareStatement(deleteReq);
                selectPS =  dataSource.getConnection().prepareStatement(selectReq);
            } catch (SQLException ex) {
                System.err.println(ex);
            }
            
        }
        public void add(int annonceCoLocationId,int userId){
            try {
                insertPS.setInt(1, annonceCoLocationId);
                insertPS.setInt(2, userId);
                insertPS.executeUpdate();
            } catch (SQLException ex) {
                  System.out.println(ex);
            }
        }
        public void remove(int annonceCoLocationId,int userId)
        {
            try {
                deletePS.setInt(1, annonceCoLocationId);
                deletePS.setInt(2,userId);
                deletePS.executeUpdate();
            } catch (SQLException e) {
                System.out.println(e);
            }
        
        }
        public List<User>  getAllUsers(int annonceCoLocationId ){
            List<User> result = new ArrayList();
            try {
                selectPS.setInt(0,annonceCoLocationId);
                ResultSet rs = selectPS.executeQuery();
                while(rs.next())
                    result.add(new User(rs.getInt(1)));
            } catch (SQLException ex) {
                System.out.println(ex);
            }
            return result;
        }

    }

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
            ImageService imageService = new ImageService();
            for (String photo : t.getPhotosUrls()) {
                imageService.add(photo,t.getId());
                
            }
            //adding "les Colocataires"
            CoLocataire coLocataireService = new CoLocataire();
            for (User u : t.getCoLocataires()) {
                coLocataireService.add(t.getId(),u.getId());
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
