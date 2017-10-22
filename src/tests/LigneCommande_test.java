/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import interfaces.ILigneCommandeService;
import models.LigneCommande;
import services.LigneCommandeService;

/**
 *
 * @author plazma33
 */
public class LigneCommande_test {
    
    public static void main(String[] args) {
        
        LigneCommande pizza =new LigneCommande(5, 13, 2);
        ILigneCommandeService meals_interface =new LigneCommandeService();
        meals_interface.add(pizza);
    }
    
}
