package fr.nicolasvinckier.hydrogrow_back.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.nicolasvinckier.hydrogrow_back.model.Plant;

@RestController
public class PlantsController {

    @RequestMapping("/plant")
    public Plant getPlant() {
        Plant tomate = new Plant(1, "Tomato", "A red fruit", "tomato.jpg", Plant.PlantType.FRUIT, 60, 25, 60, 100, 6.5f,
                1.5f);
        return tomate;
    }
}
