package com.example.MyLibraryBackendSpringBoot.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.MyLibraryBackendSpringBoot.model.User;
import com.example.MyLibraryBackendSpringBoot.service.UserService;

@RequestMapping("/api")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public User login(@RequestBody User loginPayload) {
        return userService.login(loginPayload.getEmail());
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public User register(@RequestBody User registerPayload) {
        User newUser = new User(registerPayload.getName(), registerPayload.getLastname(),
                registerPayload.getEmail());
        return userService.register(newUser);

    }
}
