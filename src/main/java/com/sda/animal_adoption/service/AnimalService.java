package com.sda.animal_adoption.service;

import com.sda.animal_adoption.exceptions.AnimalNotFoundException;
import com.sda.animal_adoption.model.Animal;
import com.sda.animal_adoption.model.User;
import com.sda.animal_adoption.repositories.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AnimalService {

    private AnimalRepository animalRepository;

    @Autowired
    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }

    public void save(Animal animal) {
        animalRepository.save(animal);
    }

    public List<Animal> findAll() {
        return animalRepository.findAll();
    }

    public Animal findById(Long id) {
        return animalRepository.findById(id).orElseThrow(() -> new AnimalNotFoundException("Animal not found"));

    }

    public List<Animal> findAnimalByBreed(String breed) {
        List<Animal> animals = animalRepository.findAll();
        return animals.stream()
                .filter(a -> a.getBreed().equalsIgnoreCase(breed))
                .collect(Collectors.toList());
        //todo throw exception if not found
    }

    public List<Animal> delete(Long id) {
        Animal animal = animalRepository.findById(id)
                .orElseThrow(() -> new AnimalNotFoundException("Invalid animal Id:" + id));
        animalRepository.delete(animal);
        return animalRepository.findAll();
    }

    public Animal update(Long id, Animal newAnimal) {
        Animal animal = animalRepository.findById(id).orElseThrow(() -> new AnimalNotFoundException("Animal with id: " + id + " not found"));

        animal.setName(newAnimal.getName());
        animal.setAge(newAnimal.getAge());
        animal.setSex(newAnimal.getSex());
        animal.setBreed(newAnimal.getBreed());
        animal.setDescription(newAnimal.getDescription());
        animal.setPhoto(newAnimal.getPhoto());
        animal.setMeeting(newAnimal.getMeeting());
        animal.setShelter(newAnimal.getShelter());
        final Animal savedAnimal = animalRepository.save(animal);
        return savedAnimal;
    }

}
