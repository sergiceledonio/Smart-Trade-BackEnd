package codebusters.smarttradebackend.BusinessLogic.Models.Factory;

public class Toys implements Product {

    private int id;
    private String name;
    private String recAge;
    private String type;
    private String description;

    public Toys(String id, String name, String recAge, String type, String description) {

        this.id = Integer.parseInt(id);
        this.name = name;
        this.recAge = recAge;
        this.type = type;
        this.description = description;
    }

    @Override
    public String getProductType() {
        return "Toys";
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

    public String getRecAge() {
        return recAge;
    }

    public void setRecAge(String recAge) {
        this.recAge = recAge;
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
        System.out.println("Recomended Age: " + recAge);
        System.out.println("Type: " + type);
        System.out.println("Description: " + description);
    }
}
