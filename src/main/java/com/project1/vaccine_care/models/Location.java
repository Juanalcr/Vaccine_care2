/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project1.vaccine_care.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author user
 */
@Entity
@Table(name="location")
public class Location {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private long location_id;
    
    @Column(name="city")
    private String city;
    
    @Column(name="districts")
    private String districts;
    
    @Column(name="ward")
    private String ward;
    
    @Column(name="service_place")
    private String service_place;

    public long getLocation_id() {
        return location_id;
    }

    public void setLocation_id(long location_id) {
        this.location_id = location_id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistricts() {
        return districts;
    }

    public void setDistricts(String districts) {
        this.districts = districts;
    }

    public String getWard() {
        return ward;
    }

    public void setWard(String ward) {
        this.ward = ward;
    }

    public String getService_place() {
        return service_place;
    }

    public void setService_place(String service_place) {
        this.service_place = service_place;
    }

}
