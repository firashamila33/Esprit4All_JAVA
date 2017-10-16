/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import interfaces.IServiceDocumentAdministratif;
import models.DocumentAdministratif;
import models.User;
import services.DocumentAdministratifService;

/**
 *
 * @author asus
 */
public class Documentadmintest {
     public static void main(String[] args) {
        DocumentAdministratif R = new DocumentAdministratif(4,new User(1),"hihihih","5000",true);
         IServiceDocumentAdministratif s=new DocumentAdministratifService();
    
       
         System.out.println( s.getById(4));
}
}