package codebusters.smarttradebackend.BusinessLogic.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Column;

import java.awt.image.CropImageFilter;

@Entity
public class Electronic extends Product{
    private String Material;
    private String Type;
    private String Description;

    public Electronic(int Id, String Name, String Material, String Type, String Description, Seller cif, double price) {
            super(Id, cif, Name, price);
            this.Material = Material;
            this.Type = Type;
            this.Description = Description;
        }

    public Electronic() {

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
