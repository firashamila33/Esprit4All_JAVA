/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import models.Club;

/**
 *
 * @author Sami
 */
public interface IClubService extends IServices<Club, Integer>{

    @Override
    public void add(Club t);

    @Override
    public void delete(Integer r);


    @Override
    public List<Club> getAll();

    @Override
    public Club getById(Integer r);

    @Override
    public void update(Club t);
    
 
    
}
