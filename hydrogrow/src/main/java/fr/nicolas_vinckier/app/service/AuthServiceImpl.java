package fr.nicolas_vinckier.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import fr.nicolas_vinckier.app.config.JwtTokenProvider;
import fr.nicolas_vinckier.app.models.*;
import fr.nicolas_vinckier.app.repository.*;

/**
 * 
 * AuthServiceImpl
 * 
 * AuthServiceImpl is a class that implements AuthService
 * 
 */
@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenProvider JwtTokenProvider;

    @Autowired
    private TokenService tokenService;

    @Override
    public String login(String email, String password) {
        // Find the user by email
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // Check if the password matches
        if (passwordEncoder.matches(password, user.getPassword())) {
            return tokenService.generateToken(email);

        } else {
            throw new RuntimeException("Invalid password");
        }
    }

    @Override
    public String register(String email, String password) {
        // Check if the user already exists
        if (userRepository.findByEmail(email).isPresent()) {
            throw new RuntimeException("User already exists");
        }

        // Create a new user
        User user = new User();
        user.setEmail(email);
        user.setPassword(passwordEncoder.encode(password));
        user.setEnabled(true);

        // Save the user
        userRepository.save(user);

        return JwtTokenProvider.createToken(email);
    }

}
