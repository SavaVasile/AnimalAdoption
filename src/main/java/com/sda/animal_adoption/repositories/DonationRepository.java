package com.sda.animal_adoption.repositories;

import com.sda.animal_adoption.model.Donation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DonationRepository extends CrudRepository<Donation, Long> {
    List<Donation> findAll();
}
