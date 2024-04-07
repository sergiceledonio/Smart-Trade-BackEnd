package codebusters.smarttradebackend.BusinessLogic.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Column;

@Entity
public class Seller extends User {

    @Column(unique = true)
    private String CIF;

    private String Iban;

    public Seller(int Id, String Name, String Password, String Email, String Cif, String Iban) {
        super(Id, Email, Name, Password);
        this.CIF = Cif;
        this.Iban = Iban;
    }

    public Seller() {

    }

    public String getCif() {
        return this.CIF;
    }

    public void setCif(String Cif) {
        this.CIF = Cif;
    }

    public String getIban() {
        return this.Iban;
    }

    public void setIban() {
        this.Iban = Iban;
    }
}
