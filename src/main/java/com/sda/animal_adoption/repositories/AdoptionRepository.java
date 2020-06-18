package com.sda.animal_adoption.repositories;

import com.sda.animal_adoption.model.Adoption;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdoptionRepository extends CrudRepository<Adoption,Long>  {
        List<Adoption> findAll();
}
