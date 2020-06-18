package com.sda.animal_adoption.controller;

import com.sda.animal_adoption.model.Adoption;
import com.sda.animal_adoption.model.Contract;
import com.sda.animal_adoption.model.User;
import com.sda.animal_adoption.service.AdoptionService;
import com.sda.animal_adoption.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;

@RestController
@CrossOrigin("*")
public class ContractController {

    private ContractService contractService;
    private AdoptionService adoptionService;

    @Autowired
    public ContractController(ContractService contractService, AdoptionService adoptionService) {
        this.contractService = contractService;
        this.adoptionService = adoptionService;
    }

    @PostMapping("/saveContract")
    public void save(@RequestBody Contract contract) {
        contractService.save(contract);
    }

    @GetMapping("/contracts")
    public List<Contract> findAll() {
        return contractService.findAll();
    }

    @GetMapping("/findContract/{id}")
    public Contract findById(@PathVariable Long id) {
        return contractService.findById(id);
    }

    @PutMapping("/updateContract/{id}")
    public void update(@PathVariable Long id, @RequestBody Contract contract) {
        contractService.update(id, contract);
    }

    @DeleteMapping("/deleteContract/{id}")
    public void delete(@PathVariable Long id) {
        contractService.delete(id);
    }

    @PostMapping("/createContract")
    public void createContract(@RequestParam(name = "idAdoption") Long idAdoption, @RequestBody Contract contract1) {
        Contract contract = new Contract();
        contract.setDate(new java.sql.Date(Calendar.getInstance().getTime().getTime()));
        contract.setComments(contract1.getComments());
        contract.setAdoption(adoptionService.findById(idAdoption));

        contractService.save(contract);
    }
}
