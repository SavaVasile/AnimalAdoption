package com.sda.animal_adoption.controller;

import com.sda.animal_adoption.model.Adoption;
import com.sda.animal_adoption.model.Animal;
import com.sda.animal_adoption.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class AnimalController {
    private AnimalService animalService;

    @Autowired
    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @GetMapping("/hi/{hi}")
    @ResponseBody
    public String sayHi(@PathVariable String hi) {
        return "prefix_" + hi;
    }

    @GetMapping("/animals")
    @ResponseBody
    public List<Animal> findAll() {
        return animalService.findAll();
    }

    @GetMapping("/findAnimal/{id}")
    public Animal findById(@PathVariable Long id) {
        return animalService.findById(id);
    }

    @GetMapping("/animalsByRace/{breed}")
    @ResponseBody()
    public List<Animal> findByRace(@PathVariable String breed) {
        return animalService.findAnimalByBreed(breed);
    }

    @PostMapping("/saveAnimal")
    public void save(@RequestBody Animal animal) {
        animalService.save(animal);
    }

    @PutMapping("/updateAnimal/{id}")
    public Animal update(@PathVariable Long id, @RequestBody Animal animal) {
        return animalService.update(id, animal);
    }

    @DeleteMapping("/deleteAnimal/{id}")
    public List<Animal> delete(@PathVariable Long id) {
        animalService.delete(id);
        return animalService.findAll();
    }
    //return list of animals?

}
