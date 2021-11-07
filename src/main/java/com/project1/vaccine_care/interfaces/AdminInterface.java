/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project1.vaccine_care.interfaces;

import com.project1.vaccine_care.models.Admin;
import java.util.List;

/**
 *
 * @author user
 */
public interface AdminInterface {
    List<Admin> getAll();
    void store(Admin admin);
    Admin getById(long id);
    void delete(long id);
    List<Admin> getAdmin();

    
   
    
    public void login(Admin admin);
    
    
}
