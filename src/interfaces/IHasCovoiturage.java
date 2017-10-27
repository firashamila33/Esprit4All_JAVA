/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import models.HasCovoiturage;

/**
 *
 * @author YACINE
 */
public interface IHasCovoiturage extends IServices<HasCovoiturage, Integer>{

    @Override
    public HasCovoiturage search(HasCovoiturage t);

    @Override
    public HasCovoiturage getById(Integer r);

    @Override
    public List<HasCovoiturage> getAll();

    @Override
    public void delete(Integer r);

    @Override
    public void update(HasCovoiturage t);

    @Override
    public void add(HasCovoiturage t);
    
}
