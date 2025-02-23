package com.devmaster.Lesson2.annotation_controller;

import org.springframework.stereotype.Service;

@Service
public class UserService {
    public String getUserDetails() {
        return "<h1>User details ";
    }

}
