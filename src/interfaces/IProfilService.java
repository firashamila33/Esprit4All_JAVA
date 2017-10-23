/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import models.Profil;

/**
 *
 * @author YACINE
 */
public interface IProfilService extends IServices <Profil,Integer>{
    
    @Override
    void add(Profil p);
    
    @Override
    void update(Profil p);
    
    @Override
    void delete(Integer i);
    
    @Override
    List<Profil> getAll();
    
    @Override
    Profil getById(Integer i);
    
    @Override
    Profil search(Profil p);
    
}
