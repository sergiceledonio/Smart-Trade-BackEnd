package codebusters.smarttradebackend.Factory;

public class Food implements Product {
    private int id;
    private String name;
    private String kilogram;
    private String type;
    private String description;

    public Food(String id, String name, String kilogram, String type, String description) {
        this.id = Integer.parseInt(id);
        this.name = name;
        this.kilogram = kilogram;
        this.type = type;
        this.description = description;
    }

    @Override
    public String getProductType(){
        return "Food";
    }

    public int getId() {
        return id;
    }

    // no deberia de poder cambiarse nunca, lo dejo por si acaso
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getKilogram() {
        return kilogram;
    }

    public void setKilogram(String kilogram) {
        this.kilogram = kilogram;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public void showInfo() {
        System.out.println("Name: " + name);
        System.out.println("Size: " + kilogram);
        System.out.println("Type: " + type);
        System.out.println("Description: " + description);
    }
}