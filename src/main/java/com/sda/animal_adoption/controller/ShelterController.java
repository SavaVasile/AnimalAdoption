package com.sda.animal_adoption.controller;

import com.sda.animal_adoption.model.Adoption;
import com.sda.animal_adoption.model.Donation;
import com.sda.animal_adoption.model.Shelter;
import com.sda.animal_adoption.model.User;
import com.sda.animal_adoption.service.ShelterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class ShelterController {

    private ShelterService shelterService;

    @Autowired
    public ShelterController(ShelterService shelterService) {
        this.shelterService = shelterService;
    }

    @PostMapping("/saveShelter")
    public void save(@RequestBody Shelter shelter) {
        shelterService.save(shelter);
    }

    @GetMapping("/shelters")
    public List<Shelter> findAll() {
        return shelterService.findAll();
    }

    @GetMapping("/findShelter/{id}")
    public Shelter findById(@PathVariable Long id) {
        return shelterService.findById(id);
    }

    @PutMapping("/updateShelter/{id}")
    public void update(@PathVariable Long id, @RequestBody Shelter shelter) {
        shelterService.update(id, shelter);
    }

    @DeleteMapping("/deleteShelter/{id}")
    public void delete(@PathVariable Long id) {
        shelterService.delete(id);
    }
}
