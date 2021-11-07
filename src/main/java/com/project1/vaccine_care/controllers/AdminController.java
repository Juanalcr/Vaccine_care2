/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project1.vaccine_care.controllers;

import com.project1.vaccine_care.interfaces.AdminInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author xFahlevi
 */
@Controller
public class AdminController {
    
    @Autowired
    private AdminInterface adminInterface;
    
    @GetMapping("/homeadmin")
    public String admin() {
        
        return"homeadmin";
    }
    
}
