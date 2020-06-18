package com.sda.animal_adoption.service;

import com.sda.animal_adoption.model.Adoption;
import com.sda.animal_adoption.model.Animal;
import com.sda.animal_adoption.model.Donation;
import com.sda.animal_adoption.model.User;
import com.sda.animal_adoption.repositories.DonationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DonationService {

    private DonationRepository donationRepository;

    @Autowired
    public DonationService(DonationRepository donationRepository) {
        this.donationRepository = donationRepository;
    }

    public void save(Donation donation) {
        donationRepository.save(donation);
    }

    public List<Donation> findAll() {
        return donationRepository.findAll();
    }

    public Donation findById(Long id) {
        return donationRepository.findById(id)
                .orElseThrow(() -> new NullPointerException("Donation with id: " + id + " not found"));
    }

    public void delete(Long id) {
        Donation donation = donationRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid donation Id:" + id));
        donationRepository.delete(donation);
    }

    public void update(Long id, Donation newDonation) {
        donationRepository.findById(id)
                .map(donation -> {
                    donation.setDetails(newDonation.getDetails());
                    donation.setSum(newDonation.getSum());
                    donation.setUser(newDonation.getUser());
                    return donationRepository.save(donation);
                }).orElseThrow(() -> new NullPointerException("Donation with id: " + id + " not found"));
    }
}
