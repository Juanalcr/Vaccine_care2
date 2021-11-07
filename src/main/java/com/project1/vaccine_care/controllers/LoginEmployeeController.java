/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project1.vaccine_care.controllers;

import com.project1.vaccine_care.interfaces.EmployeeInterface;
import com.project1.vaccine_care.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author xFahlevi
 */
@Controller
public class LoginEmployeeController {
    
    @Autowired
    private EmployeeInterface employeeInterface;
    
    @GetMapping("/loginemployee")
    public String index(Model model){
    
        Employee employee = new Employee();
        model.addAttribute("employee", employee);

        return "loginemployee";
    }
    
    @PostMapping("/loginemployee")
    public String store(@ModelAttribute("employee") Employee employee) throws Exception {
        employeeInterface.login(employee);
        return "redirect:/homeemployee";
    }
}
