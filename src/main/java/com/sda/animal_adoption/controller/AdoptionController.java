package com.sda.animal_adoption.controller;

import com.sda.animal_adoption.model.Adoption;

import com.sda.animal_adoption.service.AdoptionService;
import com.sda.animal_adoption.service.AnimalService;
import com.sda.animal_adoption.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.List;

@RestController
@CrossOrigin("*")
public class AdoptionController {

    private AdoptionService adoptionService;
    private UserService userService;
    private AnimalService animalService;

    @Autowired
    public AdoptionController(AdoptionService adoptionService, UserService userService, AnimalService animalService) {
        this.adoptionService = adoptionService;
        this.userService = userService;
        this.animalService = animalService;
    }


    @GetMapping("/adoptions")
    @ResponseBody
    public List<Adoption> findAll() {
        return adoptionService.findAll();
    }

    @GetMapping("/findAdoption/{id}")
    public Adoption findById(@PathVariable Long id){
        return  adoptionService.findById(id);
    }

    @PostMapping("/saveAdoption")
    public void save(@RequestBody Adoption adoption) {
        adoptionService.save(adoption);
    }

    @DeleteMapping("/deleteAdoption/{id}")
    public void delete(@PathVariable Long id) {
        adoptionService.delete(id);
    }

    @PostMapping("/createAdoption")
    //RequestParam cand sunt multe variabile, @PathVariable cand e o variabila
    public void createAdoption(@RequestParam(name = "idUser") Long idUser,
                               @RequestParam(name = "idAnimal") Long idAnimal) {
        Adoption adoption = new Adoption();
        adoption.setDate(Timestamp.valueOf(LocalDateTime.now()));
        adoption.setUser(userService.findById(idUser));
        adoption.setAnimal(animalService.findById(idAnimal));

        adoptionService.save(adoption);
    }

    @PutMapping("/updateAdoption/{id}")
    public void update(@PathVariable Long id, @RequestBody Adoption adoption) {
        adoptionService.update(id, adoption);
    }

}
