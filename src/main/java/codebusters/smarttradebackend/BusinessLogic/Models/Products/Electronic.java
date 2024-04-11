package codebusters.smarttradebackend.BusinessLogic.Models.Products;

import codebusters.smarttradebackend.BusinessLogic.Models.Products.Product;
import codebusters.smarttradebackend.BusinessLogic.Models.Users.Seller;
import jakarta.persistence.Entity;

@Entity
public class Electronic extends Product {
    private String Material;
    private String Type;
    private String Description;

    public Electronic(int Id, String Name, String Material, String Type, String Description, Seller Cif, double Price,
                        int StarsNum, int ShippingDuration) {
        super(Id, Cif, Name, Price, StarsNum, ShippingDuration);
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
