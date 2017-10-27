/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.security.Provider.Service;
import models.Revision;
import models.utilisateur_accept_revision;

/**
 *
 * @author asus
 */
public interface iutilisateur_accept_revision extends IServices <utilisateur_accept_revision,Integer> {

    @Override
    public default void add(utilisateur_accept_revision t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

   

    @Override
    public void delete(Integer r);
    
}
