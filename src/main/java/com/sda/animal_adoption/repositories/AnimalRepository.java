package com.sda.animal_adoption.repositories;

import com.sda.animal_adoption.model.Animal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepository extends CrudRepository<Animal, Long> {
    List<Animal> findAll();

    Animal findByName(String name);

    List<Animal> findAllByBreed(String race);

    List<Animal> findAllByAge(int age);

    List<Animal> findAllBySex(String sex);
}
