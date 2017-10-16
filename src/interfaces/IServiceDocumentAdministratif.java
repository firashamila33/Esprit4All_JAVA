/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import models.DocumentAdministratif;

/**
 *
 * @author asus
 */
public interface IServiceDocumentAdministratif extends IServices<DocumentAdministratif, Integer> {

    @Override
    public void add(DocumentAdministratif t);

    @Override
    public boolean equals(Object o);

    @Override
    public DocumentAdministratif getById(Integer r);

    @Override
    public List<DocumentAdministratif> getAll();

    @Override
    public int hashCode();

    @Override
    public void delete(Integer r);

    @Override
    public String toString();

    @Override
    public void update(DocumentAdministratif t);
    
}
