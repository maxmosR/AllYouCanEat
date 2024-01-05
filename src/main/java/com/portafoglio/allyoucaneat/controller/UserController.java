package com.portafoglio.allyoucaneat.controller;

import com.portafoglio.allyoucaneat.model.User;
import com.portafoglio.allyoucaneat.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        try {
            User registeredUser = userService.registerUser(user);
            return new ResponseEntity<>("User registration initiated. Check your email for OTP.", HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/verifyOtp")
    public ResponseEntity<String> verifyOtp(@RequestParam String email, @RequestParam String otp) {
        try {
            userService.verifyOtp(email, otp);
            return new ResponseEntity<>("OTP verification successful. You can now set your password.", HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/completeRegistration")
    public ResponseEntity<String> completeRegistration(@RequestParam String email, @RequestParam String password, @RequestParam(required = false) String name, @RequestParam(required = false) String username, @RequestParam(required = false) String tel, @RequestParam(required = false) String address) {
        try {
            userService.completeRegistration(email, password, name, username, tel);
            return new ResponseEntity<>("Registration completed successfully.", HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findByEmail")
    public ResponseEntity<User> findByEmail(@RequestParam String email) {
        Optional<User> user = userService.findByEmail(email);
        return user.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}

