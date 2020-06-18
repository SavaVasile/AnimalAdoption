package com.sda.animal_adoption.service;

import com.sda.animal_adoption.model.Adoption;
import com.sda.animal_adoption.model.Animal;
import com.sda.animal_adoption.model.Meeting;
import com.sda.animal_adoption.model.User;
import com.sda.animal_adoption.repositories.MeetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeetingService {

    private MeetingRepository meetingRepository;

    @Autowired
    public MeetingService(MeetingRepository meetingRepository) {
        this.meetingRepository = meetingRepository;
    }

    public void save(Meeting meeting) {
        meetingRepository.save(meeting);
    }

    public List<Meeting>findAll(){
        return meetingRepository.findAll();
    }

    public Meeting findById(Long id) {
        return meetingRepository.findById(id)
                .orElseThrow(() -> new NullPointerException("Meeting with id: " + id + " not found"));
    }

    public void delete(Long id) {
        Meeting meeting = meetingRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid meeting Id:" + id));
        meetingRepository.delete(meeting);
    }

    public void update(Long id, Meeting newMeeting) {
        meetingRepository.findById(id)
                .map(meeting -> {
                    meeting.setDetails(newMeeting.getDetails());
                    meeting.setDate(newMeeting.getDate());
                    meeting.setAnimal(newMeeting.getAnimal());
                    meeting.setUser(newMeeting.getUser());
                    return meetingRepository.save(meeting);
                }).orElseThrow(() -> new NullPointerException("Meeting with id: " + id + " not found"));
    }
}
