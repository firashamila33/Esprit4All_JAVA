/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import models.note_revision;

/**
 *
 * @author asus
 */
public interface InoteRevision extends  IServices <note_revision,Integer>{

    @Override
    public void add(note_revision t);

    @Override
    public void delete(Integer r);

    @Override
    public note_revision getById(Integer r);

    @Override
    public List<note_revision> getAll();

    @Override
    public note_revision search(note_revision t);

    @Override
    public void update(note_revision t);

}
