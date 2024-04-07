package codebusters.smarttradebackend.BusinessLogic.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Column;

@Entity
public class Toy extends Product {

    private int RecAge;
    private String Type;
    private String Description;

    public Toy(int Id, String Name, int RecAge, String Type, String Description, Seller cif, double price) {
        super(Id, cif, Name, price);
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
