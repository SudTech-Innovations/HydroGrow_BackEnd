package fr.nicolas_vinckier.app.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.nicolas_vinckier.app.config.JwtTokenProvider;
import fr.nicolas_vinckier.app.dto.LoginRequest;
import fr.nicolas_vinckier.app.dto.RegisterRequest;
import fr.nicolas_vinckier.app.service.AuthService;

/**
 * 
 * AuthController
 * 
 * AuthController is a class that contains the login method.
 * 
 */
@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @GetMapping("/test")
    public Map<String, String> string() {
        Map<String, String> response = new HashMap<>();
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String formatDateTime = now.format(formatter);
        response.put("test", "OK");
        response.put("time", formatDateTime);
        return response;
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody LoginRequest loginRequest) {
        // Génération des données de réponse
        String token = authService.login(loginRequest.getEmail(), loginRequest.getPassword());

        // Création de la réponse
        Map<String, String> response = new HashMap<>();
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String formatDateTime = now.format(formatter);

        // Ajout des données à la réponse
        response.put("token", token);
        response.put("time", formatDateTime);

        // Retourner la réponse
        return response;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest registerRequest) {
        authService.register(registerRequest.getEmail(), registerRequest.getPassword());
        return new ResponseEntity<>("User Registered Successfully", HttpStatus.OK);
    }

    // Vérifier si le token est valide
    @PostMapping("/validate")
    public Map<String, String> validate(@RequestBody Map<String, String> token) {
        Map<String, String> response = new HashMap<>();
        if (jwtTokenProvider.validateToken(token.get("token"))) {
            response.put("valid", "true");
        } else {
            response.put("valid", "false");
        }
        return response;
    }

    // Donne le mail de l'utilisateur à partir du token
    @PostMapping("/email")
    public Map<String, String> email(@RequestBody Map<String, String> token) {
        Map<String, String> response = new HashMap<>();
        String email = jwtTokenProvider.getEmailFromToken(token.get("token"));
        response.put("email", email);
        return response;
    }

}
