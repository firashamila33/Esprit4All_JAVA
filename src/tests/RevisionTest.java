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

            IServiceRevision revision = new RevisionService();
            System.out.println(revision.getAll());
            
        

    }
}
