package codebusters.smarttradebackend.BusinessLogic.Models.Adresses;

import codebusters.smarttradebackend.BusinessLogic.Models.Users.Seller;
import jakarta.persistence.Entity;

@Entity
public class SellerAddress extends Seller {

    private String City;
    private String Street;
    private int Number;
    private int Flat;
    private int Door;

    public SellerAddress(int Id, String Email, String Name, String Password, String Dni, String Cif, String Iban,
                            String City, String Street, int Number, int Flat, int Door) {
        super(Id, Email, Name, Password, Dni, Cif, Iban);
        this.City = City;
        this.Street = Street;
        this.Number = Number;
        this.Flat = Flat;
        this.Door = Door;
    }

    public SellerAddress() {

    }

    public String getCity() {
        return this.City;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public String getStreet() {
        return this.Street;
    }

    public void setStreet(String Street) {
        this.Street = Street;
    }

    public int getNumber() {
        return this.Number;
    }

    public void setNumber(int Number) {
        this.Number = Number;
    }

    public int getFlat() {
        return this.Flat;
    }

    public void setFlat(int Flat) {
        this.Flat = Flat;
    }

    public int getDoor() {
        return this.Door;
    }

    public void setDoor(int Door) {
        this.Door = Door;
    }
}