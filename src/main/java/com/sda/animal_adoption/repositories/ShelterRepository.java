package com.sda.animal_adoption.repositories;

import com.sda.animal_adoption.model.Shelter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShelterRepository extends CrudRepository<Shelter, Long> {
    List<Shelter>findAll();
}
