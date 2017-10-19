/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;


import interfaces.ICommandeService;
import interfaces.IUserService;
import models.Commande;
import models.User;
import services.CommandeService;
import services.UserService;

/**
 *
 * @author plazma33
 */
public class Commande_test {
    
        public static void main(String[] args) {
            
//            User plazma = new User(2);
//            IUserService users= new UserService();
//            users.register(plazma);
            
//            Commande commande0= new Commande(new User(1),null,95822.21);
//            Commande commande1= new Commande(new User(1),null,757575.3);
//            Commande commande2= new Commande(new User(1),null,75576.21);
            
            
            ICommandeService orders_interface=new CommandeService();
//            orders_interface.add(commande0);
//            orders_interface.add(commande1);
//            orders_interface.add(commande2);
            orders_interface.delete(9);
            Commande commande0= new Commande(7,new User(1),null,999.9);
            orders_interface.update(commande0);
            //System.out.println(orders_interface.getAll());
            
            orders_interface.getAll().forEach(System.out::println);
            System.out.println("---------------------------------------------------------------------------");
            System.out.println(orders_interface.getById(6));
            
        }

    
}
