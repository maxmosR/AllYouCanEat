package com.portafoglio.allyoucaneat.controller;

import com.portafoglio.allyoucaneat.model.User;
import com.portafoglio.allyoucaneat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;
    @PostMapping("/registration")
    public User registration(@RequestParam String email, @RequestParam String password){
        return userService.registration(email, password);
    }

    @PostMapping("/login")
    public User login(@RequestParam String email, @RequestParam String password){
        return userService.login(email, password);
    }

}
