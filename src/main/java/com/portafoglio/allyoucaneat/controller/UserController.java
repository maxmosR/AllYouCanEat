package com.portafoglio.allyoucaneat.controller;

import com.portafoglio.allyoucaneat.model.User;
import com.portafoglio.allyoucaneat.service.GMailer;
import com.portafoglio.allyoucaneat.service.UserService;
import com.portafoglio.allyoucaneat.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.*;

import java.util.Optional;

@RestController
@RequestMapping("user")
@Api(value = "User Registration API")
public class UserController {

    @Autowired
    private UserService userService;


    @ApiOperation(value = "Preregister a user", notes = "Initiates user registration and sends OTP to the provided email.")
    /*@ApiResponses(value = {
            @ApiResponse(code = 200, message = "User registration initiated. Check your email for OTP."),
            @ApiResponse(code = 400, message = "Bad request. Invalid email format or email already registered."),
            @ApiResponse(code = 500, message = "Internal server error. Something went wrong.")
    })*/
    @PostMapping("preregister")
    public ResponseEntity<String> preregisterUser(@RequestParam String email) {
        try {
            userService.preregisterUser(email);
            return new ResponseEntity<>("User registration initiated. Check your email for OTP.", HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>("Internal server error. Something went wrong.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
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

