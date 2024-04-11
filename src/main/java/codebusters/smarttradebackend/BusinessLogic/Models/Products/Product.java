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
    private int StarsNum;
    private int ShippingDuration;

    public Product(int Id, Seller Cif, String Name, double Price, int StarsNum, int ShippingDuration) {
        this.Id = Id;
        this.CIF = Cif;
        this.Name = Name;
        this.Price = Price;
        this.StarsNum = StarsNum;
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

    public int getStarsNum() {
        return this.StarsNum;
    }

    public void setStarsNum(int StarsNum) {
        this.StarsNum = StarsNum;
    }

    public int getShippingDuration() {
        return this.ShippingDuration;
    }

    public void setShippingDuration(int ShippingDuration) {
        this.ShippingDuration = ShippingDuration;
    }
}
