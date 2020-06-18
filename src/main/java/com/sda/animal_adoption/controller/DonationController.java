package com.sda.animal_adoption.controller;
import com.sda.animal_adoption.model.Donation;
import com.sda.animal_adoption.service.DonationService;
import com.sda.animal_adoption.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class DonationController {

    private DonationService donationService;
    private UserService userService;

    @Autowired
    public DonationController(DonationService donationService, UserService userService) {
        this.donationService = donationService;
        this.userService = userService;
    }

    @GetMapping("/donations")
    public List<Donation> findAll() {
        return donationService.findAll();
    }

    @GetMapping("/findDonation/{id}")
    public Donation findById(@PathVariable Long id) {
        return donationService.findById(id);
    }

    @PostMapping("/saveDonation")
    public void save(@RequestBody Donation donation) {
        donationService.save(donation);
    }

    @PutMapping("/updateDonation/{id}")
    public void update(@PathVariable Long id, @RequestBody Donation donation) {
        donationService.update(id, donation);
    }

    @DeleteMapping("/deleteDonation/{id}")
    public void delete(@PathVariable Long id) {
        donationService.delete(id);
    }


    @PostMapping("/createDonation")
    public void createDonation(@RequestParam(name = "idUser") Long idUser, @RequestBody Donation donation1) {
        Donation donation = new Donation();
        donation.setSum(donation1.getSum());
        donation.setDetails(donation1.getDetails());
        donation.setUser(userService.findById(idUser));
        donationService.save(donation);
    }
}
