/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project1.vaccine_care.controllers;

import com.project1.vaccine_care.interfaces.EmployeeInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author xFahlevi
 */
@Controller
public class EmployeeController {
    
    @Autowired
    private EmployeeInterface employeeInterface;
    
    @GetMapping("/homeemployee")
    public String employee() {   

        return "homeemployee";       
    
}
}
