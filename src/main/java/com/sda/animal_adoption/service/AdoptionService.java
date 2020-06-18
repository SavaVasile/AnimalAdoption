package com.sda.animal_adoption.service;

import com.sda.animal_adoption.model.Adoption;

import com.sda.animal_adoption.model.Animal;
import com.sda.animal_adoption.model.User;
import com.sda.animal_adoption.repositories.AdoptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AdoptionService {
    private AdoptionRepository adoptionRepository;

    @Autowired
    public AdoptionService(AdoptionRepository adoptionRepository) {
        this.adoptionRepository = adoptionRepository;
    }

    public void save(Adoption adoption) {
        adoptionRepository.save(adoption);
    }

    public List<Adoption> findAll() {
        return adoptionRepository.findAll();
    }

    public Adoption findById(Long id) {
        return adoptionRepository.findById(id)
                .orElseThrow(() -> new NullPointerException("Adoption with id: " + id + " not found"));
    }

    public void delete(Long id) {
        Adoption adoption = adoptionRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid adoption Id:" + id));
        adoptionRepository.delete(adoption);
    }

    public void update(Long id, Adoption newAdoption) {
        adoptionRepository.findById(id)
                .map(adoption -> {
                    adoption.setDate(newAdoption.getDate());
                    adoption.setUser(newAdoption.getUser());
                    adoption.setAnimal(newAdoption.getAnimal());
                    adoption.setContract(newAdoption.getContract());
                    return adoptionRepository.save(adoption);
                }).orElseThrow(() -> new NullPointerException("Adoption with id: " + id + " not found"));
    }
}
