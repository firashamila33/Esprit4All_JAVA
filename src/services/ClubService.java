/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import interfaces.IClubService;
import java.sql.SQLException;
import java.util.List;
import models.Club;

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
        String req="insert into club (id,user_id,type,description,date,path_img)values(?,?,?,?,?,?)";
        PreparedStatement preparedStatement;
        try{
        preparedStatement ;
        
        }catch(SQLException ex){
            ex.printStackTrace();
        }
       
    }

    @Override
    public void delete(Club t) {
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
    
}
