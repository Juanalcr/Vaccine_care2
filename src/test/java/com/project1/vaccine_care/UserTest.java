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
import org.springframework.test.web.servlet.MockMvc;

public class UserTest {
    @InjectMocks
    @Autowired
    UserService service;

    @Mock
    UserRepository repository;
     @Autowired
    private MockMvc mockMvc;
    
   
    @Test
    public void createUserWithEmptyName() throws Exception {
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
                    .thenThrow(new Exception("Please enter your name"));
            service.store(user);
        } catch (Exception ex) {
            e = ex;
            message = ex.getMessage();
        }
               Assertions.assertTrue(e instanceof Exception);
    }
    
     @Test
    public void createUserWithEmptyHomeaddress() throws Exception {
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
                    .thenThrow(new Exception("please input you home address"));
            service.store(user);
        } catch (Exception ex) {
            e = ex;
            message = ex.getMessage();
        }
               Assertions.assertTrue(e instanceof Exception);
    }
    
     @Test
    public void createUserWithEmptyVaccinetype() throws Exception {
        Throwable e = null;
        String message = null;
        
        try {
        User user = new User();
        user.setNik(66721446);
        user.setName("Ana");
        user.setHome_address("Depok");
        user.setPhone_number(85789995);
        user.setVaccine_type("");
           
            when(repository.save(user))
                    .thenThrow(new Exception("please input your vaccine type"));
            service.store(user);
        } catch (Exception ex) {
            e = ex;
            message = ex.getMessage();
        }
               Assertions.assertTrue(e instanceof Exception);
    }
}
