/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;
import interfaces.IAnnonceObjetPerduService;
import java.sql.Date;
import java.util.List;
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
     public  static void testDelete()
     {
        User u = new User(4, "kadhem", "kadhem@gmail.com", 1, "mayhemekech", "kadhem", "kadhem", new Date(12545), "123456", "mourouj");
        AnnonceObjetPerdu aop = new AnnonceObjetPerdu("YOU SHOULD NEVER SEE THIS", new Date(1223546), "Bloc A", u, new Date(1) , new Date(1));
        AnnonceObjetPerduService annonceObjetPerduService = new AnnonceObjetPerduService();
        annonceObjetPerduService.add(aop);
        annonceObjetPerduService.delete(aop.getId());
     }
     public static void testGetAll()
     {
         IAnnonceObjetPerduService objetPerduService = new AnnonceObjetPerduService();
         List<AnnonceObjetPerdu> l = objetPerduService.getAll();
         for(AnnonceObjetPerdu a : l)
             System.out.println("testGetAll : " + a );
         System.out.println("there are " + l.size() + " elements");
         
     }
     public static void testGetById()
     {
         User u = new User(4, "kadhem", "kadhem@gmail.com", 1, "mayhemekech", "kadhem", "kadhem", new Date(12545), "123456", "mourouj");
        /*UserService us = new UserService();
        us.add(u);*/
        AnnonceObjetPerdu aop = new AnnonceObjetPerdu("BMW Z4 Sport", new Date(1223546), "Bloc A", u, new Date(1) , new Date(1));
        AnnonceObjetPerduService annonceObjetPerduService = new AnnonceObjetPerduService();
        annonceObjetPerduService.add(aop);
        AnnonceObjetPerdu returnedStuff = annonceObjetPerduService.getById(aop.getId());
         System.out.println("testGetById : " + returnedStuff);
         
         if(annonceObjetPerduService.getById(99999) == null)
             System.out.println("testGetById : retrned null as expedcted");
         
     }
    
    public static void main(String[] args) {
     testAdd();
     testUpdate();
     testDelete();
     testGetAll();
     testGetById();
    }
    
}

