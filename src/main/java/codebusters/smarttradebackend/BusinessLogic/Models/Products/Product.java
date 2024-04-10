package codebusters.smarttradebackend.BusinessLogic.Models.Products;

import codebusters.smarttradebackend.BusinessLogic.Models.Users.Seller;
import jakarta.persistence.*;

@Entity
public class Product {

    @Id
    private int Id;

    @ManyToOne(optional = true)
    @JoinColumn(name="CIF")
    private Seller CIF;

    @Column(unique = true)
    private String Name;

    private double Price;
    private int NumStars;
    private int ShippingDuration;

    public Product(int Id, Seller Cif, String Name, double Price, int NumStars, int ShippingDuration) {
        this.Id = Id;
        this.CIF = Cif;
        this.Name = Name;
        this.Price = Price;
        this.NumStars = NumStars;
        this.ShippingDuration = ShippingDuration;
    }

    public Product() {

    }

    public int getId() {
        return this.Id;
    }

    public void setId() {
        this.Id = Id;
    }

    public Seller getCif() {
        return this.CIF;
    }

    public void setCif(Seller Cif) {
        this.CIF = Cif;
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

    public int getNumStars() {
        return this.NumStars;
    }

    public void setNumStars(int NumStars) {
        this.NumStars = NumStars;
    }
}
