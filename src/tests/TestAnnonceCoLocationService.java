/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import interfaces.IAnnonceCoLocationService;
import java.sql.Date;
import java.util.ArrayList;
import models.Address;
import models.AnnonceCoLocation;
import models.User;
import services.AnnonceCoLocationService;

/**
 *
 * @author kadhem
 */
public class TestAnnonceCoLocationService {
    public static void testAdd()
    {
        User u = new User(4, "kadhem", "kadhem@gmail.com", 1, "mayhemekech", "kadhem", "kadhem", new Date(12545), "123456", "mourouj");
        User u1 = new User(1, "ahmed", "kadhem@gmail.com", 1, "mayhemekech", "kadhem", "kadhem", new Date(12545), "123456", "mourouj");
        IAnnonceCoLocationService annonceCoLocationService = new AnnonceCoLocationService();
        AnnonceCoLocationService cs = new AnnonceCoLocationService();
        
        
        ArrayList<String> photoList = new ArrayList<>();
        photoList.add("photo1.png");
        photoList.add("photo2.png");
        ArrayList<User> l = new ArrayList<>();
        l.add(u);
        l.add(u1);
        AnnonceCoLocation annonceCoLocation = new AnnonceCoLocation(new Address("NouvelleAriana", "Principale", "404", "baa7dha el pole"), "s++2", l, 3, 12.5f, photoList, u, new Date(99999), new Date(99999));
        annonceCoLocationService.add(annonceCoLocation);
    }
    public static void main(String[] args) {
        testAdd();
    }
    
}
