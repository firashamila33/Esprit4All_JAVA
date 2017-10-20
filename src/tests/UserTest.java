/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import java.util.Scanner;
import models.User;
import services.UserService;
import utils.BCrypt;

/**
 *
 * @author YACINE
 */
public class UserTest {

    public static void main(String[] args) {
        String originalPassword = "azerty";
        String generatedSecuredPasswordHash = BCrypt.hashpw(originalPassword, BCrypt.gensalt(12));
        User u = new User("yacine", "yacine.farhat@esprit.tn", 1, generatedSecuredPasswordHash, "farhat", "yacine", null, "12345678", "cité olympique");
        UserService userService = new UserService();
        /*System.out.println("Enter your username: ");
        Scanner scanner = new Scanner(System.in);
        String username = scanner.nextLine();
        System.out.println("Enter your password: ");
        String password = scanner.nextLine();
        userService.Login(username, password);*/
        //userService.enable(u);
        /*userService.getAll().forEach((user) -> {
            System.out.println(user);
        });*/
        User use=new User();
        use=userService.getUserById(1);
        System.out.println(use);
        
    }

}
