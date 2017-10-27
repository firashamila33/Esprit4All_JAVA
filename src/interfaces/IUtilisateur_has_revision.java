/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import models.Revision;
import models.utilisateur_has_revision;

/**
 *
 * @author asus
 */
public interface IUtilisateur_has_revision extends IServices<utilisateur_has_revision,Integer> {

    @Override
    public void add(utilisateur_has_revision t);

    
    @Override
    public void delete(Integer r);

    
}
