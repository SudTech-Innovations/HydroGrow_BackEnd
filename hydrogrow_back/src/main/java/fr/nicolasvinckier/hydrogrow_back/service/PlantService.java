package fr.nicolasvinckier.hydrogrow_back.service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Service;

import fr.nicolasvinckier.hydrogrow_back.model.Plant;
import fr.nicolasvinckier.hydrogrow_back.model.Plant.PlantType;

@Service
public class PlantService {

    /**
     * Paramètre d'une plante
     * id, name, description, image, type, growTime, growTemp, growHumidity,
     * growLight, growPh, growEc
     */
    static private ArrayList<Plant> plants = new ArrayList<>(Arrays.asList(
            new Plant(1, "Tomate", "A red fruit", "tomato.jpg", PlantType.FRUIT, 60, 25, 60, 100, 6.5f, 1.5f),
            new Plant(2, "Salade", "A green vegetable", "salad.jpg", PlantType.VEGETABLE, 30, 20, 70, 100, 6.5f, 1.5f),
            new Plant(3, "Basilic", "A green herb", "basil.jpg", PlantType.HERB, 30, 20, 70, 100, 6.5f, 1.5f),
            new Plant(4, "Rose", "A red flower", "rose.jpg", PlantType.FLOWER, 30, 20, 70, 100, 6.5f, 1.5f)));

    public ArrayList<Plant> getPlants() {
        return plants;
    }

    public Plant getPlant(int id) {
        return plants.stream().filter(t -> t.getId() == id).findFirst().get();
    }

}
