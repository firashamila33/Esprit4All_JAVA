/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;
import java.sql.Date;
import models.AnnonceObjetPerdu;
import models.User;
import services.AnnonceObjetPerduService;

/**
 *
 * @author kadhem
 */
public class TestAnnonceObjetPerduService {
    
    public  static void testAdd()
    {
        User u = new User(4, "kadhem", "kadhem@gmail.com", 1, "mayhemekech", "kadhem", "kadhem", new Date(12545), "123456", "mourouj");
        /*UserService us = new UserService();
        us.add(u);*/
        AnnonceObjetPerdu aop = new AnnonceObjetPerdu("Iphone 6", new Date(1223546), "Bloc A", u, new Date(1) , new Date(1));
        AnnonceObjetPerduService annonceObjetPerduService = new AnnonceObjetPerduService();
        annonceObjetPerduService.add(aop);
    }
     public  static void testUpdate()
    {
        User u = new User(4, "kadhem", "kadhem@gmail.com", 1, "mayhemekech", "kadhem", "kadhem", new Date(12545), "123456", "mourouj");
        /*UserService us = new UserService();
        us.add(u);*/
        AnnonceObjetPerdu aop = new AnnonceObjetPerdu("Iphone 70", new Date(1223546), "Bloc A", u, new Date(1) , new Date(1));
        AnnonceObjetPerduService annonceObjetPerduService = new AnnonceObjetPerduService();
        annonceObjetPerduService.add(aop);
        aop.setObjetDescription("Iphone 7");
        annonceObjetPerduService.update(aop);
    }
    
    public static void main(String[] args) {
     testAdd();
     testUpdate();
    }
    
}
