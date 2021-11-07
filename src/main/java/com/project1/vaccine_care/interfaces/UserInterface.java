/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project1.vaccine_care.interfaces;

import com.project1.vaccine_care.models.User;
import java.util.List;

/**
 *
 * @author user
 */
public interface UserInterface {
    List<User> getAll();
    void store(User user);
    void delete(long user_id);

   

     void register(User user) throws Exception;

     User auth(String name, long phone_number) throws Exception;

     public User getById(long user_id);
}
