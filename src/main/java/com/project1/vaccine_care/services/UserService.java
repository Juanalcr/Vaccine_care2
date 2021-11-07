/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project1.vaccine_care.services;

import com.project1.vaccine_care.interfaces.UserInterface;
import com.project1.vaccine_care.models.User;
import com.project1.vaccine_care.repositories.UserRepository;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author user
 */
@Service
public class UserService implements UserInterface {

    @Autowired
    private UserRepository userRepository;
    private long nik;
    
    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public void store(User user) {
        this.userRepository.save(user);
    }
    
   

@Override
public void delete(long user_id) {
  this.userRepository.deleteById(user_id);
}

    @Override
    public User auth(String name, long phone_number) throws Exception {
        User user = userRepository.findByName(name);
    
        return user;
    
    }
    @Override
    public void register(User user) throws Exception {
        
         
        this.userRepository.save(user);
       
        
    }

    @Override
    public User getById(long user_id) {
       Optional < User > optional = userRepository.findById(user_id);

    if (!optional.isPresent()) {
    throw new RuntimeException(" User not found for user_id :: " + user_id);
     }

    User user = optional.get();
     return user;
    }
}
