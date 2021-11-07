/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project1.vaccine_care.controllers;

import com.project1.vaccine_care.interfaces.AdminInterface;
import com.project1.vaccine_care.models.Admin;
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
public class LoginAdminController {
    
    @Autowired
    private AdminInterface adminInterface;
    
    @GetMapping("/loginadmin")
    public String index(Model model){
    
        Admin admin = new Admin();
        model.addAttribute("admin", admin);

        return "loginadmin";
    }
    
    @PostMapping("/loginadmin")
    public String store(@ModelAttribute("user") Admin admin) throws Exception {
        adminInterface.login(admin);
        return "redirect:/homeadmin";
    }
    
    
}
