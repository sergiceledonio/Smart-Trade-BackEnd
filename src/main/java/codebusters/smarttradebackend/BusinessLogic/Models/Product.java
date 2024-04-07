package src.main.java.codebusters.smarttradebackend.BusinessLogic.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Column;

@Entity
public class Product {

    @Id
    private int Id;

    @Column(unique = true)
    @ManyToOne(optional = true)
    private String Cif;

    @Column(unique = true)
    private String Name;

    private double Price;

    public Product(int Id, String Cif, String Name, double Price) {
        this.Id = Id;
        this.Cif = Cif;
        this.Name = Name;
        this.Price = Price;
    }

    public int getId() {
        return this.Id;
    }

    public void setId() {
        this.Id = Id;
    }

    public String getCif() {
        return this.Cif;
    }

    public void setCif(String Cif) {
        this.Cif = Cif;
    }

    public String getName() {
        return this.Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public double getPrice() {
        return this.Price;
    }

    public void setPrice(double Price) {
        this.Price = Price;
    }
}
