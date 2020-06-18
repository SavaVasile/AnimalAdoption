package com.sda.animal_adoption.service;

import com.sda.animal_adoption.model.Adoption;
import com.sda.animal_adoption.model.Animal;
import com.sda.animal_adoption.model.Contract;
import com.sda.animal_adoption.model.User;
import com.sda.animal_adoption.repositories.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService {

    private ContractRepository contractRepository;

    @Autowired
    public ContractService(ContractRepository contractRepository) {
        this.contractRepository = contractRepository;
    }

    public void save(Contract contract) {
        contractRepository.save(contract);
    }

    public List<Contract> findAll(){
        return contractRepository.findAll();
    }

    public Contract findById(Long id) {
        return contractRepository.findById(id)
                .orElseThrow(() -> new NullPointerException("Contract with id:" + id + " not found"));
    }

    public void delete(Long id) {
        Contract contract = contractRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid contract Id:" + id));
        contractRepository.delete(contract);
    }

    public void update(Long id, Contract newContract) {
        contractRepository.findById(id)
                .map(contract -> {
                    contract.setDate(newContract.getDate());
                    contract.setComments(newContract.getComments());
                    contract.setAdoption(newContract.getAdoption());
                    return contractRepository.save(contract);
                }).orElseThrow(() -> new NullPointerException("Contract with id: " + id + " not found"));
    }
}
