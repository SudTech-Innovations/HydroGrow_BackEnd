package fr.nicolasvinckier.hydrogrow_back.model;

public class Plant {

    public enum PlantType {
        FRUIT,
        VEGETABLE,
        HERB,
        FLOWER
    }

    private int id;
    private String name;
    private String description;
    private String image;
    private PlantType type;
    private int growTime;
    private int growTemp;
    private int growHumidity;
    private int growLight;
    private float growPh;
    private float growEc;

    public Plant(int id, String name, String description, String image, PlantType type, int growTime, int growTemp,
            int growHumidity, int growLight, float growPh, float growEc) {
        super();
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;
        this.type = type;
        this.growTime = growTime;
        this.growTemp = growTemp;
        this.growHumidity = growHumidity;
        this.growLight = growLight;
        this.growPh = growPh;
        this.growEc = growEc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public PlantType getType() {
        return type;
    }

    public void setType(PlantType type) {
        this.type = type;
    }

    public int getGrowTime() {
        return growTime;
    }

    public void setGrowTime(int growTime) {
        this.growTime = growTime;
    }

    public int getGrowTemp() {
        return growTemp;
    }

    public void setGrowTemp(int growTemp) {
        this.growTemp = growTemp;
    }

    public int getGrowHumidity() {
        return growHumidity;
    }

    public void setGrowHumidity(int growHumidity) {
        this.growHumidity = growHumidity;
    }

    public int getGrowLight() {
        return growLight;
    }

    public void setGrowLight(int growLight) {
        this.growLight = growLight;
    }

    public float getGrowPh() {
        return growPh;
    }

    public void setGrowPh(float growPh) {
        this.growPh = growPh;
    }

    public float getGrowEc() {
        return growEc;
    }

    public void setGrowEc(float growEc) {
        this.growEc = growEc;
    }

}
