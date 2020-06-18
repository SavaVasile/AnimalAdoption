package com.sda.animal_adoption.controller;

import com.sda.animal_adoption.model.Adoption;
import com.sda.animal_adoption.model.Donation;
import com.sda.animal_adoption.model.Meeting;
import com.sda.animal_adoption.model.User;
import com.sda.animal_adoption.service.AnimalService;
import com.sda.animal_adoption.service.MeetingService;
import com.sda.animal_adoption.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

@RestController
@CrossOrigin("*")
public class MeetingController {

    private MeetingService meetingService;
    private UserService userService;
    private AnimalService animalService;

    @Autowired
    public MeetingController(MeetingService meetingService, UserService userService, AnimalService animalService) {
        this.meetingService = meetingService;
        this.userService = userService;
        this.animalService = animalService;
    }


    @PostMapping("/saveMeeting")
    public void save(@RequestBody Meeting meeting) {
        meetingService.save(meeting);
    }

    @GetMapping("/meetings")
    public List<Meeting> findAll() {
        return meetingService.findAll();
    }

    @GetMapping("/findMeeting/{id}")
    public Meeting findById(@PathVariable Long id) {
        return meetingService.findById(id);
    }

    @DeleteMapping("/deleteMeeting/{id}")
    public void delete(@PathVariable Long id) {
        meetingService.delete(id);
    }

    @PutMapping("/updateMeeting/{id}")
    @CrossOrigin("*")
    public void update(@PathVariable Long id, @RequestBody Meeting meeting) {
        meetingService.update(id, meeting);
    }

    @PostMapping("/createMeeting")
    //RequestParam cand sunt multe variabile, @PathVariable cand e o variabila
    public void createMeeting(@RequestParam(name = "idUser") Long idUser,
                              @RequestParam(name = "idAnimal") Long idAnimal, @RequestBody Meeting meeting1) {
        Meeting meeting = new Meeting();
        meeting.setDate(new Date(Calendar.getInstance().getTime().getTime()));
        meeting.setDetails(meeting1.getDetails());
        meeting.setUser(userService.findById(idUser));
        meeting.setAnimal(animalService.findById(idAnimal));
        meetingService.save(meeting);
    }
}
