package fr.nicolas_vinckier.app.service;

/**
 * 
 * AuthService
 * 
 * AuthService is an interface that contains the login method.
 * 
 */
public interface AuthService {
    String login(String email, String password);

    String register(String email, String password);

}
