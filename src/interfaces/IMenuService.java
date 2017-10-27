/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import models.Menu;

/**
 *
 * @author plazma33
 */
public interface IMenuService extends IServices<Menu, Integer> {
    
    @Override
    public void add(Menu t);

    @Override
    public void delete(Integer r);

    @Override
    public List<Menu> getAll();

    @Override
    public Menu getById(Integer r);
 
    @Override
    public void update(Menu t);
    
    
    public Map<String,TreeSet<String>> GetSubCategoriesbyCategory();
    
    public List<Menu> GetMealsFromSubMenuFilter(String s);
    
    
    
}