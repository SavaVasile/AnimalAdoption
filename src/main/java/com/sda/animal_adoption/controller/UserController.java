package com.sda.animal_adoption.controller;

import com.sda.animal_adoption.model.User;
import com.sda.animal_adoption.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

@RestController
@CrossOrigin("*")
public class UserController {

    private UserService userService;



    @Autowired
    public UserController(UserService userService) {

        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/findUser/{id}")
    @ResponseBody()
    public User findById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @GetMapping("/findAllWithInit/{init}")
    @ResponseBody()
    public List<User> findAllWithGivenInitial(@PathVariable String init) {
        return userService.findAllWithGivenInitial(init);
    }

    @PostMapping("/saveUser")
    public void saveUser(@RequestBody User user) {
        userService.save(user);
    }

    @DeleteMapping("/deleteUser/{id}")
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }

    @PutMapping("/updateUser/{id}")
    public void update(@PathVariable Long id, @RequestBody User user) {
         userService.update(id, user);
    }

}
