package fr.nicolas_vinckier.app.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import fr.nicolas_vinckier.app.config.JwtTokenProvider;
import fr.nicolas_vinckier.app.models.Jwt;
import fr.nicolas_vinckier.app.models.User;
import fr.nicolas_vinckier.app.repository.JwtRepository;
import fr.nicolas_vinckier.app.repository.UserRepository;

@Service
public class TokenServiceImpl implements TokenService {

    @Autowired
    private JwtRepository jwtRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Value("${jwt.expiration}")
    private int expiration;

    @Override
    public String generateToken(String email) {
        // Générer un token JWT
        String token = jwtTokenProvider.createToken(email);

        // Récupérer l'utilisateur associé à l'email
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Date now = new Date();

        // Créer un nouvel objet Jwt
        Jwt jwt = new Jwt();
        jwt.setToken(token);
        jwt.setUser(user);
        jwt.setCreatedAt(now);
        jwt.setExpiredAt(new Date(now.getTime() + expiration));

        // Enregistrer le Jwt en base de données
        jwtRepository.save(jwt);

        return token;
    }
}