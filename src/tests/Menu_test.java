/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import interfaces.IMenuService;
import java.util.ArrayList;
import java.util.List;
import models.Menu;
import services.MenuService;

/**
 *
 * @author plazma33
 */
public class Menu_test {
    
    
    public static void main(String[] args) {
        
        IMenuService menu = new MenuService();
   //     System.out.println(menu.GetSubCategoriesbyCategory(1));
        
        
        
//        Menu repas0;
//        repas0 = new Menu("florida", "Snack", "Chwingum", "buvette2", 1, 10, 10.12, "src");
//        menu.add(repas0);
//        
        
        List<String> fast_food_list = new ArrayList<>(menu.GetSubCategoriesbyCategory().get("Snack"));
        
        System.out.println(fast_food_list);      
        
        System.out.println(menu.GetMealsFromSubMenuFilter("Hamburger"));
        
        
       
        
    }
    
}
