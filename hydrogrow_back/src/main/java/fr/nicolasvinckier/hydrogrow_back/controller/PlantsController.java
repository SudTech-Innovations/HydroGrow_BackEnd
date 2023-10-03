package fr.nicolasvinckier.hydrogrow_back.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.nicolasvinckier.hydrogrow_back.model.Plant;
import fr.nicolasvinckier.hydrogrow_back.service.PlantService;

@RestController
public class PlantsController {

    @Autowired
    private PlantService plantService;

    @RequestMapping("/plant")
    public List<Plant> getPlants() {
        return plantService.getPlants();
    }

    @RequestMapping("/plant/{id}")
    public Plant getPlant(@PathVariable int id) {
        return plantService.getPlant(id);
    }

}
