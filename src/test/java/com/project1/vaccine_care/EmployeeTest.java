/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project1.vaccine_care;

import com.project1.vaccine_care.models.Employee;
import com.project1.vaccine_care.repositories.EmployeeRepository;
import com.project1.vaccine_care.services.EmployeeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;

/**
 *
 * @author employee
 */
public class EmployeeTest {
    @InjectMocks
    @Autowired
    EmployeeService service;

    @Mock
    EmployeeRepository repository;
     @Autowired
    private MockMvc mockMvc;
    
   
    @Test
    public void createEmployeeWithEmptyName() throws Exception {
        Throwable e = null;
        String message = null;
        
        try {
        Employee employee = new Employee();
        employee.setName("");
        employee.setJob_desk("Doctor");
        employee.setPhone_number(85789995); 
           
            when(repository.save(employee))
                    .thenThrow(new Exception("please enter your name"));
            service.store(employee);
        } catch (Exception ex) {
            e = ex;
            message = ex.getMessage();
        }
               Assertions.assertTrue(e instanceof Exception);
    }
    
     @Test
    public void createEmployeeWithEmptyJobdesk() throws Exception {
        Throwable e = null;
        String message = null;
        
        try {
        Employee employee = new Employee();
        employee.setName("Ziva");
        employee.setJob_desk("");
        employee.setPhone_number(85789995); 
           
            when(repository.save(employee))
                    .thenThrow(new Exception("please input your jobdesk"));
            service.store(employee);
        } catch (Exception ex) {
            e = ex;
            message = ex.getMessage();
        }
               Assertions.assertTrue(e instanceof Exception);
    }
    
}
