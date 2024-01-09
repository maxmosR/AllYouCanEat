package com.portafoglio.allyoucaneat.service;

import com.portafoglio.allyoucaneat.model.User;
import com.portafoglio.allyoucaneat.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public User registration(String email, String password){
        User createUser = new User();
        createUser.setEmail(email);
        createUser.setPassword(password);
        return userRepository.save(createUser);
    }

    public User login(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }



}
