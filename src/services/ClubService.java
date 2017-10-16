/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import interfaces.IClubService;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import models.Club;
import technique.DataSource;

/**
 *
 * @author Sami
 */
public class ClubService implements IClubService{
    
    Connection connection;

    public ClubService() {
        connection = DataSource.getInstance().getConnection();
    }
    

    @Override
    public void add(Club club) {
       
       
    }

    @Override
    public void delete(Integer t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Club> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Club getById(Integer r) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Club t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Club search(Club t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
