/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project1.vaccine_care.controllers;

import com.project1.vaccine_care.interfaces.UserInterface;
import com.project1.vaccine_care.models.User;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author xFahlevi
 */
@Controller
public class RegisterController {

    @Autowired
    private UserInterface userInterface;

    @GetMapping("/register")
    public String index(Model model) {

        User user = new User();
        model.addAttribute("user", user);

        return "register";
    }

@PostMapping("/register")
    public String store(@ModelAttribute("user") User user, RedirectAttributes ra) throws Exception {
        
        if (user.getName().equals("")) {
            ra.addFlashAttribute("danger", "Name cannot be null!");
            return "redirect:/login";
        }
        
        if (user.getHome_address().equals("")) {
            ra.addFlashAttribute("danger", "Home address cannot be null!");
            return "redirect:/login";
        }
        if (user.getVaccine_type().equals("")) {
            ra.addFlashAttribute("danger", "Vaccine type cannot be null!");
            return "redirect:/login";
        }
        
        userInterface.register(user);
        return "redirect:/login";
    }
}

