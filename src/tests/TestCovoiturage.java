/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import models.Covoiturage;
import models.User;
import services.CovoiturageService;
import utils.BCrypt;

/**
 *
 * @author YACINE
 */
public class TestCovoiturage {

    public static void main(String[] args) {
        String originalPassword = "azerty";
        String generatedSecuredPasswordHash = BCrypt.hashpw(originalPassword, BCrypt.gensalt(12));
        User u = new User(2,"yacine", "yacine.farhat@esprit.tn", 1, generatedSecuredPasswordHash, "farhat", "yacine", null, "12345678", "cité olympique");
//        Covoiturage c = new Covoiturage(3,u, "Opel", 12, "cité olympique", "esprit it", "pas d'objet lourd", 3, null);
//        CovoiturageService covoiturageService = new CovoiturageService();
//        //covoiturageService.add(c);
//        covoiturageService.getAll().forEach((cov) -> {
//            System.out.println(cov);
//        });
        //covoiturageService.delete(1);
        //System.out.println(covoiturageService.getById(2));
        //covoiturageService.update(c);
    }
}
