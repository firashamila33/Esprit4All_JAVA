/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import interfaces.IEvenementService;
import models.Club;
import models.Evenement;
import services.EvenementService;

/**
 *
 * @author majdi
 */
public class TestEvenement {
    public static void main(String []args){
    
    Evenement e=new Evenement(1,"kkkj","jljlkj","khhj",null,"SALAgyuhk",new Club(3));
        IEvenementService es =  new EvenementService();
        
        // es.add(e);
      //es.delete(3);
      
//      
//       for (Evenement ev : es.getAll()) {
//            System.out.println(ev);
//        }
         
       // es.update(e);
               System.out.println(es.getById(8));

        
    }
    
    
}
