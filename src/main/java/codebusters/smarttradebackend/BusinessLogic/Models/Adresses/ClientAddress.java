package codebusters.smarttradebackend.BusinessLogic.Models.Adresses;

import codebusters.smarttradebackend.BusinessLogic.Models.Users.Client;
import jakarta.persistence.Entity;
import jakarta.persistence.Column;

@Entity
public class ClientAddress extends Client {

    @Column(unique = true)
    private int Num;

    private String City;
    private String Street;
    private int Number;
    private int Flat;
    private int Door;

    public ClientAddress(int Id, String Email, String Dni, int Num, String City, String Street, int Number, int Flat,
                            int Door, String Name, String Password) {
        super(Id, Email, Dni, Name, Password);
        this.Num = Num;
        this.City = City;
        this.Street = Street;
        this.Number = Number;
        this.Flat = Flat;
        this.Door = Door;
    }

    public ClientAddress() {

    }

    public int getNum() {
        return this.Num;
    }

    public int setNum(int Num) {
        return this.Num = Num;
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
