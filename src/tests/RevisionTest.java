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
        Revision R= new Revision(4,new User(1),"hahaha",null,"hhhhhhhhhhhhhhhhhpouvoir me reviser math",8,"yezi");
              Revision h= new Revision(new User(1),"vvvvvvvvvvvvvvvvvvv",null,"hhhhhhhhhhhhhhhhhpouvoir me reviser math",8,"yezi");
        IServiceRevision cs = new RevisionService();
cs.delete(5);

        }
}