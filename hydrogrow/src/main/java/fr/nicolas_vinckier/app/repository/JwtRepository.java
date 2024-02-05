package fr.nicolas_vinckier.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.nicolas_vinckier.app.models.Jwt;

public interface JwtRepository extends JpaRepository<Jwt, Long> {
    Optional<Jwt> findByToken(String token);

}