package com.devmaster.Lesson2.annotation_controller;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private final UserService userService;
    public UserController(UserService userService){
        this.userService = userService;
    }
    @GetMapping("/user")
    public String getUser(){
        return userService.getUserDetails();
    }
    @GetMapping("/users")
    public String getUsers() {
        return "<h1>Get all users";
    }
    @PostMapping("/users")
    public String createUser() {
        return "<h1>Create user";
    }
    @PutMapping("/users/{id}")
    public String updateUser(@PathVariable int id) {
        return "<h1>User with ID "+ id +"updated";
    }
    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable int id) {
        return "<h1>User with ID "+ id +"deleted";
    }
}
