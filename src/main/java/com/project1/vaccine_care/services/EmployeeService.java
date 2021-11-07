/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project1.vaccine_care.services;

import com.project1.vaccine_care.interfaces.EmployeeInterface;
import com.project1.vaccine_care.models.Employee;
import com.project1.vaccine_care.repositories.EmployeeRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author user
 */
@Service
public class EmployeeService implements EmployeeInterface {

    @Autowired
    private EmployeeRepository employeeRepository;
    
    @Override
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    @Override
    public void store(Employee employee) {
        this.employeeRepository.save(employee);
    }
    
    @Override
public Employee getById(long id) {
  Optional < Employee > optional = employeeRepository.findById(id);

  if (!optional.isPresent()) {
    throw new RuntimeException(" Employee not found for id :: " + id);
  }

  Employee employee = optional.get();
  return employee;
}

@Override
public void delete(long id) {
  this.employeeRepository.deleteById(id);
}

    @Override
    public List<Employee> getEmployee() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void login(Employee employee) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void registeremployee(Employee employee) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void homeemployee(Employee employee) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
