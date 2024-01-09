package com.portafoglio.allyoucaneat.service;

import com.portafoglio.allyoucaneat.model.User;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;


    public void sendEmail(User user) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(user.getEmail());
        message.setSubject("Registration Successful");
        message.setText("Thank you for registering. Your registration was successful.");

        mailSender.send(message);
    }
}
