package fr.nicolas_vinckier.app.service;

/**
 * 
 * TokenService
 * 
 * TokenService is an interface that contains the generateToken method.
 * 
 */
public interface TokenService {
    String generateToken(String email);

}
