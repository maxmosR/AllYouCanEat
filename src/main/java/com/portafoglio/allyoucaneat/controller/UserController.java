package com.portafoglio.allyoucaneat.controller;

import com.portafoglio.allyoucaneat.model.User;
import com.portafoglio.allyoucaneat.service.GMailer;
import com.portafoglio.allyoucaneat.service.UserService;
import com.portafoglio.allyoucaneat.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;


    @PostMapping("register")
    public ResponseEntity<String> registerUser(@RequestParam String email) throws Exception {
            new GMailer().sendMail(Constants.SUBJECT_CONFERMATION_EMAIL, Constants.CONFERMATION_EMAIL, email);
            return new ResponseEntity<>("User registration initiated. Check your email for OTP.", HttpStatus.OK);
    }

    @PostMapping("/login")
    public Optional<User> login(@RequestParam String email, @RequestParam String password){
        return userService.login(email, password);
    }

    @GetMapping("/findByEmail")
    public ResponseEntity<User> findByEmail(@RequestParam String email) {
        Optional<User> user = userService.findByEmail(email);
        return user.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}

