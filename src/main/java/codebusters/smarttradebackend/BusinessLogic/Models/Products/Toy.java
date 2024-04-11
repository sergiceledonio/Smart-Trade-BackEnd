package codebusters.smarttradebackend.BusinessLogic.Models.Products;

import codebusters.smarttradebackend.BusinessLogic.Models.Products.Product;
import codebusters.smarttradebackend.BusinessLogic.Models.Users.Seller;
import jakarta.persistence.Entity;

@Entity
public class Toy extends Product {

    private int RecAge;
    private String Type;
    private String Description;

    public Toy(int Id, String Name, int RecAge, String Type, String Description, Seller Cif, double Price, int StarsNum,
                    int ShippingDuration) {
        super(Id, Cif, Name, Price, StarsNum, ShippingDuration);
        this.RecAge = RecAge;
        this.Type = Type;
        this.Description = Description;
    }

    public Toy() {

    }

    public int getRecAge() {
        return this.RecAge;
    }

    public void setRecAge(int RecAge) {
        this.RecAge = RecAge;
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
