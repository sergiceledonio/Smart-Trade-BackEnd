package codebusters.smarttradebackend.BusinessLogic.Models.Products;

import codebusters.smarttradebackend.BusinessLogic.Models.Products.Product;
import codebusters.smarttradebackend.BusinessLogic.Models.Users.Seller;
import jakarta.persistence.Entity;

@Entity
public class Food extends Product {

    private double Kilogram;
    private String Type;
    private String Description;

    public Food(int Id, String Name, double Kilogram, String Type, String Description, Seller Cif, double Price) {
        super(Id, Cif, Name, Price);
        this.Kilogram = Kilogram;
        this.Type = Type;
        this.Description = Description;
    }

    public Food() {

    }

    public double getKilogram() {
        return this.Kilogram;
    }

    public void setKilogram(double Kilogram) {
        this.Kilogram = Kilogram;
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
