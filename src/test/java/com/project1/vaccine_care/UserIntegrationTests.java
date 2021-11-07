/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project1.vaccine_care;

import com.project1.vaccine_care.models.User;
import com.project1.vaccine_care.repositories.UserRepository;
import com.project1.vaccine_care.services.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author user
 */
@SpringBootTest 
public class UserIntegrationTests {

    @InjectMocks
    @Autowired
    UserService service;

    @Mock
    UserRepository repository;

    @Test
    public void createUserTest() throws Exception {
        User user = new User();
        user.setNik(66721446);
        user.setName("Ana");
        user.setHome_address("Depok");
        user.setPhone_number(85789995);
        user.setVaccine_type("Pfizer");

        when(repository.save(user)).thenReturn(user);
        service.register(user);

        when(repository.findByName("Ana")).thenReturn(user);

        User checkUser = this.repository.findByName("Ana");

        Assertions.assertEquals(user, checkUser);
    }

    @Test
    public void createUserTestWithEmptyName() throws Exception {
        Throwable e = null;
        String message = null;
        
        try {
        User user = new User();
        user.setNik(66721446);
        user.setName("");
        user.setHome_address("Depok");
        user.setPhone_number(85789995);
        user.setVaccine_type("Pfizer");

            when(repository.save(user))
                    .thenThrow(new Exception("Name cannot be null"));
            service.register(user);
        } catch (Exception ex) {
            e = ex;
            message = ex.getMessage();
        }
        
        Assertions.assertTrue(e instanceof Exception);
    }
    
    @Test
    public void createUserTestWithEmptyHomeaddress() throws Exception {
        Throwable e = null;
        String message = null;
  
        try {
             User user = new User();
        user.setNik(66721446);
        user.setName("Ana");
        user.setHome_address("");
        user.setPhone_number(85789995);
        user.setVaccine_type("Pfizer");

            when(repository.save(user))
                    .thenThrow(new Exception("Home address cannot be null"));
            service.register(user);
        } catch (Exception ex) {
            e = ex;
            message = ex.getMessage();
        }
        
        Assertions.assertTrue(e instanceof Exception);
    }
}