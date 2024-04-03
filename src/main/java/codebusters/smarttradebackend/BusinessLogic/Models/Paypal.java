package src.main.java.codebusters.smarttradebackend.BusinessLogic.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Column;

@Entity
public class Paypal {

    @Id
    private int Id;

    @Column(unique = true)
    @ManyToOne(optional = true)
    private String Dni;

    private String Email;
    private int Tlf;

    public Paypal(int Id, String Dni, String Email, int Tlf) {
        this.Id = Id;
        this.Dni = Dni;
        this.Email = Email;
        this.Tlf = Tlf;
    }

    public int getId() {
        return this.Id;
    }

    public void setId() {
        this.Id = Id;
    }

    public String getDni() {
        return this.Dni;
    }

    public void setDni(String Dni) {
        this.Dni = Dni;
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
