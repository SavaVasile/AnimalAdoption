package com.sda.animal_adoption.service;

import com.sda.animal_adoption.exceptions.UserNotFoundException;
import com.sda.animal_adoption.repositories.UserRepository;
import com.sda.animal_adoption.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public List<User> findAll() {
        return userRepository.findAll();
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public User findById(Long id) throws UserNotFoundException {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User with id: " + id + " not found"));

    }

    public List<User> findAllWithGivenInitial(String initial) {
        List<User> users = userRepository.findAll();
        /*List<User> usersResult = new ArrayList<>();
        for (User user : users) {
            if (user.getName().startsWith(initial)) {
                usersResult.add(user);
            }
        }
        return usersResult;*/
        List<User> result = users.stream()
                .filter(u -> u.getName().startsWith(initial))
                .collect(Collectors.toList());
        if (result.isEmpty()) {
            throw new UserNotFoundException("Users not found");
        }
        return result;
    }

    public void delete(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("Invalid user Id:" + id));
        userRepository.delete(user);
    }

    public void update(Long id, User newUser) {
        userRepository.findById(id)
                .map(user -> {
                    user.setName(newUser.getName());
                    user.setPhone(newUser.getPhone());
                    user.setEmail(newUser.getEmail());
                    user.setAddress(newUser.getAddress());
                    user.setUserType(newUser.getUserType());
                    return userRepository.save(user);
                }).orElseThrow(() -> new UserNotFoundException("User with id: " + id + "not found"));
    }

}
