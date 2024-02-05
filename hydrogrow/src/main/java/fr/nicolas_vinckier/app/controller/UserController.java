package fr.nicolas_vinckier.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.nicolas_vinckier.app.models.User;
import fr.nicolas_vinckier.app.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @RequestParam String firstname, @RequestParam String lastname) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
        user.setFirstname(firstname);
        user.setLastname(lastname);
        return userRepository.save(user);
    }
}
