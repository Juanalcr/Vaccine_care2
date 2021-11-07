/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project1.vaccine_care.services;

import com.project1.vaccine_care.interfaces.LocationInterface;
import com.project1.vaccine_care.models.Location;
import com.project1.vaccine_care.repositories.LocationRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author user
 */
@Service
public class LocationService implements LocationInterface {

    @Autowired
    private LocationRepository locationRepository;
    
    @Override
    public List<Location> getAll() {
        return locationRepository.findAll();
    }

    @Override
    public void store(Location location) {
        this.locationRepository.save(location);
    }
    
    @Override
public Location getById(long id) {
  Optional < Location > optional = locationRepository.findById(id);

  if (!optional.isPresent()) {
    throw new RuntimeException(" Location not found for id :: " + id);
  }

  Location location = optional.get();
  return location;
}

@Override
public void delete(long id) {
  this.locationRepository.deleteById(id);
}

}

