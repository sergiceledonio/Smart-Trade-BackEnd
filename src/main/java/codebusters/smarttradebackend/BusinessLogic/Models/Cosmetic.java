package codebusters.smarttradebackend.BusinessLogic.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Column;

@Entity
public class Cosmetic extends Product {

    private String Color;
    private String Material;
    private String Type;
    private String Description;

    public Cosmetic(int Id, String Name, String Color, String Material, String Type, String Description, Seller cif, double price) {
        super(Id, cif, Name, price);
        this.Color = Color;
        this.Material = Material;
        this.Type = Type;
        this.Description = Description;
    }

    public Cosmetic() {

    }

    public String getColor() {
        return this.Color;
    }

    public void setColor(String Color) {
        this.Color = Color;
    }

    public String getMaterial() {
        return this.Material;
    }

    public void setMaterial(String Material) {
        this.Material = Material;
    }

    public String getType() {
        return this.Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public String getDescription() {
        return this.Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }
}
