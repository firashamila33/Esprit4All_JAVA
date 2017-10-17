/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import models.Covoiturage;
import services.CovoiturageService;

/**
 *
 * @author YACINE
 */
public class TestCovoiturage {

    public static void main(String[] args) {
        Covoiturage c = new Covoiturage(2, "Peugeot", 12, "cité olympique", "esprit it", "pas d'objet lourd", 3, "8h15");
        CovoiturageService covoiturageService = new CovoiturageService();
        //covoiturageService.add(c);
        /*covoiturageService.getAll().forEach((cov) -> {
            System.out.println(cov);
        });*/
        //covoiturageService.delete(1);
        //System.out.println(covoiturageService.getById(2));
        //covoiturageService.update(c);
    }
}
