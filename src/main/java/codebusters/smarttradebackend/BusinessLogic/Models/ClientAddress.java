package src.main.java.codebusters.smarttradebackend.BusinessLogic.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Column;

@Entity
public class ClientAddress extends Client {

    @Id
    private int Id;

    @Column(unique = true)
    @ManyToOne(optional = true)
    private String Email;

    @Column(unique = true)
    @ManyToOne(optional = true)
    private String Dni;

    @Column(unique = true)
    private int Num;

    private String City;
    private String Street;
    private int Number;
    private int Flat;
    private int Door;

    public SellerAddress(int Id, String Email, String Dni, int Num, String City, String Street, int Number, int Flat,
                            int Door) {
        super(Id, Email, Cif, Iban);
        this.Id = Id;
        this.Email = Email;
        this.Dni = Dni;
        this.Num = Num;
        this.City = City;
        this.Street = Street;
        this.Number = Number;
        this.Flat = Flat;
        this.Door = Door;
    }

    public int getId() {
        return this.Id;
    }

    public void setId() {
        this.Id = Id;
    }
    public String getEmail() {
        return this.Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getDni() {
        return this.Dni;
    }

    public void setDni(String Dni) {
        this.Dni = Dni;
    }

    public int getNum() {
        return this.Num;
    }

    public int setNum(int Num) {
        this.Num = Num;
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
