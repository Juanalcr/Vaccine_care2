/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project1.vaccine_care.services;

import com.project1.vaccine_care.interfaces.AdminInterface;
import com.project1.vaccine_care.models.Admin;
import com.project1.vaccine_care.repositories.AdminRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author user
 */
@Service
public class AdminService implements AdminInterface {

    @Autowired
    private AdminRepository adminRepository;
    
    @Override
    public List<Admin> getAll() {
        return adminRepository.findAll();
    }

    @Override
    public void store(Admin admin) {
        this.adminRepository.save(admin);
    }
    
    @Override
public Admin getById(long id) {
  Optional < Admin > optional = adminRepository.findById(id);

  if (!optional.isPresent()) {
    throw new RuntimeException(" Admin not found for id :: " + id);
  }

  Admin admin = optional.get();
  return admin;
}

@Override
public void delete(long id) {
  this.adminRepository.deleteById(id);
}

    @Override
    public List<Admin> getAdmin() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void login(Admin admin) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

}
