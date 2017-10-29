/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import models.Evenement;

/**
 *
 * @author Sami
 */
public interface IEvenementService extends IServices<Evenement, Integer> {

    @Override
    public void add(Evenement t);

   @Override
   public  void delete(Integer r);

    @Override
    public Evenement search(Evenement t);
  
  
    @Override
    public List<Evenement> getAll();

    @Override
    public void update(Evenement t);

    @Override
    public Evenement getById(Integer r);
    
    
    
    
    
}
