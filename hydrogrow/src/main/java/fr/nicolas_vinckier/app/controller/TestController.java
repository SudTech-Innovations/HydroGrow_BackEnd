package fr.nicolas_vinckier.app.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestController {

    // -------- Get

    @GetMapping
    public Map<String, String> string() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Hello String!");
        return response;
    }

    // -------- Post
    @PostMapping
    public Map<String, String> string(@RequestBody Map<String, String> request) {
        Map<String, String> response = new HashMap<>();
        response.put("outputpost", request.get("inputpost") + "-post");
        System.out.println("inputpost: " + request.get("inputpost"));
        return response;
    }

}
