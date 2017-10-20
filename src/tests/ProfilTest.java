/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import models.Profil;
import models.User;
import services.ProfilService;
import utils.BCrypt;

/**
 *
 * @author YACINE
 */
public class ProfilTest {

    public static void main(String[] args) {
        String originalPassword = "azerty";
        String generatedSecuredPasswordHash = BCrypt.hashpw(originalPassword, BCrypt.gensalt(12));
        User u = new User(2,"yacine", "yacine.farhat@esprit.tn", 1, generatedSecuredPasswordHash, "farhat", "yacine", null, "12345678", "cité olympique");
        Profil p = new Profil(4,u, "JAVA", "je suis très bon", "4infob", "j'ai pas", "j'ai pas", "j'ai pas", "j'ai pas", "j'ai pas", "j'ai pas", "50494671");
        ProfilService profilService = new ProfilService();
        //profilService.add(p);
        profilService.update(p);
    }
}
