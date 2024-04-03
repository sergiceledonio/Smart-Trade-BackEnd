package src.main.java.codebusters.smarttradebackend.BusinessLogic.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Column;

@Entity
public class Seller extends User {

    @Id
    private int Id;

    @Column(unique = true)
    @ManyToOne(optional = true)
    private String Email;

    @Column(unique = true)
    private String Cif;

    private String Iban;

    public Seller(int Id, String Email, String Cif, String Iban) {
        super(Id, Email, Name, Password);
        this.Id = Id;
        this.Email = Email;
        this.Cif = Cif;
        this.Iban = Iban;
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

    public String getCif() {
        return this.Cif;
    }

    public void setCif(String Cif) {
        this.Cif = Cif;
    }

    public String getIban() {
        return this.Iban;
    }

    public void setIban() {
        this.Iban = Iban;
    }
}
