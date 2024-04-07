package codebusters.smarttradebackend.BusinessLogic.Models;

import jakarta.persistence.*;

@Entity
public class Paypal {

    @Id
    private int Id;

    @ManyToOne(optional = true)
    @JoinColumn(name="DNI")
    private Client DNI;

    private String Email;
    private int Tlf;

    public Paypal(int Id, Client Dni, String Email, int Tlf) {
        this.Id = Id;
        this.DNI = Dni;
        this.Email = Email;
        this.Tlf = Tlf;
    }

    public Paypal() {

    }

    public int getId() {
        return this.Id;
    }

    public void setId() {
        this.Id = Id;
    }

    public Client getDni() {
        return this.DNI;
    }

    public void setDni(Client Dni) {
        this.DNI = Dni;
    }

    public String getEmail() {
        return this.Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public int getTlf() {
        return this.Tlf;
    }

    public void setTlf(int Tlf) {
        this.Tlf = Tlf;
    }
}
