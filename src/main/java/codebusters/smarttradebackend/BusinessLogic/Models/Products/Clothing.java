package codebusters.smarttradebackend.BusinessLogic.Models.Products;

import codebusters.smarttradebackend.BusinessLogic.Models.Products.Product;
import codebusters.smarttradebackend.BusinessLogic.Models.Users.Seller;
import jakarta.persistence.Entity;

@Entity
public class Clothing extends Product {

    private String Size;
    private String Color;
    private String Material;
    private String Type;
    private String Description;

    public Clothing(int Id, String Name, String Size, String Color, String Material, String Type, String Description, Seller cif, double price) {
        super(Id, cif, Name, price);
        this.Size = Size;
        this.Color = Color;
        this.Material = Material;
        this.Type = Type;
        this.Description = Description;
    }

    public Clothing() {

    }
    public String getSize() {
        return this.Size;
    }

    public void setSize(String Size) {
        this.Size = Size;
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
