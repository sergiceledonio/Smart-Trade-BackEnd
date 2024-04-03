package src.main.java.codebusters.smarttradebackend.BusinessLogic.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Column;

@Entity
public class Food extends Product {

    @Id
    private int Id;

    @Column(unique = true)
    @ManyToOne(optional = true)
    private String Name;

    private double Kilogram;
    private String Type;
    private String Description;

    public Food(int Id, String Name, double Kilogram, String Type, String Description) {
        super(Id, Cif, Name, Price);
        this.Id = Id;
        this.Name = Name;
        this.Kilogram = Kilogram;
        this.Type = Type;
        this.Description = Description;
    }

    public int getId() {
        return this.Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getName() {
        return this.Name;
    }

    public void setName(String Name) {
        this.Name = Name;
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
