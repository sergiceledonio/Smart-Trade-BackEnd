package codebusters.smarttradebackend.BusinessLogic.Models.Products;

import jakarta.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private double price;

    @Column(name = "type")
    private String type;

    @Column(name = "description", length = 200)
    private String description;

    @Column(name = "pending")
    private boolean pending;

    @Column(name = "validation")
    private boolean validation;

    public Product() {

    }

    public Product(String name, double price, String type, String description, boolean pend, boolean val) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.description = description;
        this.pending = pend;
        this.validation = val;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getPending() { return pending; }

    public void setPending(boolean pending) { this.pending = pending; }

    public boolean getValidation() { return validation; }

    public void setValidation(boolean validation) { this.validation = validation; }
}
