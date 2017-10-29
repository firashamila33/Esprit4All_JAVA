/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.util.List;
import models.User;

/**
 *
 * @author YACINE
 */
public interface IUserService{
    void register(User u);
    boolean Login(String username,String password);
    void disable(User u);
    void enable(User u);
    User search(User u);
    List<User> getAll();
    User getUserById(Integer i);
                    public  float  noteUSer(Integer r);

}
