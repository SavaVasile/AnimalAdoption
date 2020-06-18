package com.sda.animal_adoption.service;

import com.sda.animal_adoption.model.Shelter;
import com.sda.animal_adoption.repositories.ShelterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShelterService {
    private ShelterRepository shelterRepository;

    @Autowired
    public ShelterService(ShelterRepository shelterRepository) {
        this.shelterRepository = shelterRepository;
    }

    public void save(Shelter shelter) {
        shelterRepository.save(shelter);
    }

    public List<Shelter> findAll() {
       return shelterRepository.findAll();
    }

    public Shelter findById(Long id) {
        return shelterRepository.findById(id)
                .orElseThrow(() -> new NullPointerException("Shelter with id: " + id + " not found"));
    }

    public void delete(Long id) {
        Shelter shelter = shelterRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid shelter Id:" + id));
        shelterRepository.delete(shelter);
    }

    //todo
    public void update(Long id, Shelter newShelter) {
        shelterRepository.findById(id)
                .map(shelter -> {
                    shelter.setName(newShelter.getName());
                    shelter.setAnimals(newShelter.getAnimals());
                    shelter.setUsers(newShelter.getUsers());
                    shelter.setAddress(newShelter.getAddress());
                    return shelterRepository.save(shelter);
                }).orElseThrow(() -> new NullPointerException("Shelter with id: " + id + " not found"));
    }
}
