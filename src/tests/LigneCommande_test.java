/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import interfaces.ILigneCommandeService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import models.LigneCommande;
import services.LigneCommandeService;

/**
 *
 * @author plazma33
 */
public class LigneCommande_test {

    public static void main(String[] args) {

        
        ILigneCommandeService ligne_commande = new LigneCommandeService();

        
        
       
//        meals_interface.getAll().forEach(System.out::println);
//        System.out.println(meals_interface.getAll());
//        System.out.println("haaaaa");
//        LigneCommande pizza = new LigneCommande(5, 12, 9);
//        LigneCommande pizza1 = new LigneCommande(5, 12, 9);
//        meals_interface.delete(pizza);
//        meals_interface.add(pizza);

            
//System.out.println(ligne_commande.getByCommande(5));





             TreeSet<String> fast_food= new TreeSet<>();
             Map<String,TreeSet<String>> categs = new HashMap();
             
             fast_food.add("pizza");
             fast_food.add("hamburger");
             fast_food.add("mlewi");
             fast_food.add("crepe");
             fast_food.add("crepooo");
             fast_food.add("crepooo");
             fast_food.add("mewi");
            
//             System.out.println(fast_food);
             
            categs.put("Fast_Food", fast_food);
            System.out.println(categs.get("Fast_Food"));
//            List<String> listaaa = new ArrayList<>(categs.get("Fast_Food"));
//            System.out.println(listaaa.get(0));
//           System.out.println(categs.get("Fast_Food").get(0));
            
        

        
    }

}
