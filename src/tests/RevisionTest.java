/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import interfaces.IServiceRevision;
import java.util.List;
import models.Revision;
import models.User;
import services.RevisionService;
import services.UserService;

/**
 *
 * @author asus
 */
public class RevisionTest {

    public static void main(String[] args) {
//        RevisionService objet = new RevisionService();
//        List<Revision> l;
//        l = objet.getAll();
//        for (Revision r : l) {
//            System.out.println("testGetAll : " + r);
//        }
//        
UserService us =new UserService();
            RevisionService rs = new RevisionService();
       // User u = UserService.userStatic;
     //  User u=new User(3);
         //   Revision r = new Revision(u," math", null, "description", 0, "nnnd", null);
            
            rs.delete(3);
        

    }
}
