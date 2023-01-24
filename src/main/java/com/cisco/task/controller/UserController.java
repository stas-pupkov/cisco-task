package com.cisco.task.controller;

import com.cisco.task.dto.User;
import com.cisco.task.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class UserController {

    private UserService userService;

    @GetMapping("/users/{id}")
    User getUser(@PathVariable int id) {
        return userService.getUserById(id);
    }

}
