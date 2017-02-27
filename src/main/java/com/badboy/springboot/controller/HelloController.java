package com.badboy.springboot.controller;

import com.badboy.springboot.dao.UserRepository;
import com.badboy.springboot.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class HelloController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/")
    public String home() {
        return "Hello World!aaa";
    }

    @GetMapping("/getUsers")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping("/addUser")
    public void getUserById(@RequestParam(value = "name") String name,@RequestParam(value = "age") Integer age) {
        User user = new User();
        user.setName(name);
        user.setAge(age);
        userRepository.save(user);
    }

    @DeleteMapping("/deleteUser/{id}")
    public void deleteUserById(@PathVariable Integer id) {
        userRepository.delete(id);
    }

    @PutMapping("/putUser/{id}/{name}")
    public void updateUserById(@PathVariable Integer id, @PathVariable String name) {
        User user = userRepository.findOne(id);
        user.setName(name);
        userRepository.save(user);
    }


}
