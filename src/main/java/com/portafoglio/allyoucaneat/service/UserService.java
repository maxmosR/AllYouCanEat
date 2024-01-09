package com.portafoglio.allyoucaneat.service;

import com.portafoglio.allyoucaneat.model.User;
import com.portafoglio.allyoucaneat.repository.UserRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmailService emailService;

    /*@Autowired
    private EmailService emailService;*/

    /*@Value("${password.min-length}")
    private int minPasswordLength;

    @Value("${otp.length}")
    private int otpLength;*/

    public User registerUser(User user) {

            validateUser(user);
            validateEmail(user.getEmail());
            /*validatePassword(user.getPassword());*/
            findByEmail(user.getEmail());

        // Generate and send OTP
        /*String otp = generateOtp();
        sendOtpByEmail(user.getEmail(), otp);
        user.setOtp(otp);*/

        User savedUser = userRepository.save(user);

        emailService.sendEmail(savedUser);
        return savedUser;

        }

    /*public void verifyOtp(String email, String otp) {
        Optional<User> optionalUser = userRepository.findByEmailAndOtp(email, otp);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setOtp(null); // Clear OTP after successful verification
            user.setEnabled(true); // Set user status to true (activated)
            user.setLastUpdate(LocalDateTime.now()); // Update last update timestamp
            userRepository.save(user);
        } else {
            throw new IllegalArgumentException("Invalid OTP");
        }
    }*/
    public User login(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }

    /*public void completeRegistration(String email, String password, String name, String surname, String tel) {
        Optional<User> optionalUser = userRepository.findByEmail(email);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setPassword(password);
            user.setName(name);
            user.setSurname(surname);
            user.setTel(tel);
            // Set additional information (optional)
            userRepository.save(user);
        } else {
            throw new IllegalArgumentException("User not found for email: " + email);
        }
    }*/

    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    private void validateUser(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }
    }

    private void validateEmail(String email) {
        if (StringUtils.isBlank(email)) {
            throw new IllegalArgumentException("Email cannot be null or empty");
        }

        // Check if the email format is valid (you can use more sophisticated checks)
        if (!email.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")) {
            throw new IllegalArgumentException("Invalid email format");
        }

        if (userRepository.findByEmail(email).isPresent()) {
            throw new IllegalArgumentException("Email is already registered");
        }
    }
    /*private void validatePassword(String password) {
        if (StringUtils.isBlank(password)) {
            throw new IllegalArgumentException("Password cannot be null or empty");
        }

        // Add additional password strength checks if needed
        // Example: Check if the password has a minimum length
        if (password.length() < minPasswordLength) {
            throw new IllegalArgumentException("Password must be at least 8 characters long");
        }
        if (!password.matches(".*[a-z].*") || !password.matches(".*[A-Z].*")) {
            throw new IllegalArgumentException("Password must contain both uppercase and lowercase letters");
        }
        if (!password.matches(".*\\d.*")) {
            throw new IllegalArgumentException("Password must contain at least one numeric digit");
        }
        if (!password.matches(".*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?].*")) {
            throw new IllegalArgumentException("Password must contain at least one special character");
        }
        if (password.contains(" ")) {
            throw new IllegalArgumentException("Password cannot contain spaces");
        }
    }
    private String generateOtp() {
        return UUID.randomUUID().toString().replaceAll("-", "").substring(0, otpLength);
    }

    private void sendOtpByEmail(String email, String otp) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Registration OTP");
        message.setText("Your OTP for registration: " + otp);
        mailSender.send(message);
    }*/

}
