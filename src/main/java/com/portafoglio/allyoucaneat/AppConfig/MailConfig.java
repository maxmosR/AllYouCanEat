package com.portafoglio.allyoucaneat.AppConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class MailConfig {

    @Bean
    public JavaMailSender javaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("your-smtp-host");
        mailSender.setPort(587); // Set the appropriate port
        mailSender.setUsername("your-username");
        mailSender.setPassword("your-password");

        // Additional properties and configurations

        return mailSender;
    }
}
