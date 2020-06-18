package com.sda.animal_adoption.repositories;

import com.sda.animal_adoption.model.Meeting;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MeetingRepository extends CrudRepository<Meeting, Long> {
    List<Meeting> findAll();
}
