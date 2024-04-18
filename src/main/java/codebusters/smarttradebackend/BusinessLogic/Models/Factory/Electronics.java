package codebusters.smarttradebackend.BusinessLogic.Models.Factory;

public class Electronics {
    private int id;
    private String name;
    private String material;
    private String type;
    private String description;

    public Electronics(String id, String name, String material, String type, String description) {
        this.id = Integer.parseInt(id);
        this.name = name;
        this.material = material;
        this.type = type;
        this.description = description;
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

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
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


}