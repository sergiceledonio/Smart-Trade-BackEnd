package codebusters.smarttradebackend.BusinessLogic.Models.Products;

import codebusters.smarttradebackend.BusinessLogic.Models.Users.User;
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

    @Lob
    @Column(name = "image")
    private byte[] image;

    @Column(name = "user_id")
    private int user_id;

    @Column(name = "description", length = 200)
    private String description;

    @Column(name = "pending")
    private boolean pending;

    @Column(name = "validation")
    private boolean validation;

    public Product() {

    }

    public Product(String name, double price, String type, String description, boolean pend, boolean val, int user, byte[] image) {
        this.name = name;
        this.price = price;
        this.type = type;
        this.image = image;
        this.user_id = user;
        this.description = description;
        this.pending = pend;
        this.validation = val;
    }

    public int getId() {
        return this.id;
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

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
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
