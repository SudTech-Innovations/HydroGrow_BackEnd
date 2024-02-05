package fr.nicolas_vinckier.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.nicolas_vinckier.app.models.User;

/**
 * UserRepository
 * 
 * UserRepository is an interface that extends JpaRepository to perform CRUD
 * 
 */
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

}