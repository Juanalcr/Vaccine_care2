/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project1.vaccine_care.interfaces;

import com.project1.vaccine_care.models.Employee;
import java.util.List;

/**
 *
 * @author user
 */
public interface EmployeeInterface {
    List<Employee> getAll();
    void store(Employee employee);
    Employee getById(long id);
    void delete(long id);
    List<Employee> getEmployee();

    public void login(Employee employee);
}
