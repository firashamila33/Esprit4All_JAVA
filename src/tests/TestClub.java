/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import interfaces.IClubService;
import models.Club;
import models.User;
import services.ClubService;

/**
 *
 * @author majdi
 */
public class TestClub {

    public static void main(String[] args) {

        Club club = new Club("AIESEC", "DESC5", "path_iMG5","Couverture5", new User(1));
        IClubService cs = new ClubService();

        //cs.add(club);
       
        //cs.delete(4);
       
//        for (Club c : cs.getAll()) {
//            System.out.println(c);
//        }
         
        
        //cs.update(club);
        
        //System.out.println(cs.getById(3));
        
    }

}
