/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import models.Covoiturage;

/**
 *
 * @author YACINE
 */
public interface ICovoiturageService extends IServices<Covoiturage,Integer>{
    @Override
    public void delete(Integer r);

    @Override
    public List<Covoiturage> getAll();

    @Override
    public Covoiturage getById(Integer r);

    @Override
    public void update(Covoiturage t);

    @Override
    public void add(Covoiturage t);

    @Override
    public Covoiturage search(Covoiturage t);
}
