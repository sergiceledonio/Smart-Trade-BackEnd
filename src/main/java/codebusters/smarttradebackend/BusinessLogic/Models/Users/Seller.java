package codebusters.smarttradebackend.BusinessLogic.Models.Users;

import codebusters.smarttradebackend.BusinessLogic.Models.Users.Usuario;
import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

@Entity
public class Seller extends Usuario {
    @Id
    private int Id;
    @JoinColumn(name="Email")
    private String Email;
    @Column(unique = true)
    private String CIF;

    private String Iban;


    public Seller(int Id, String Email, String Cif, String Iban) {
        //super(Id, Email, Name, Password);
        this.Id = Id;
        this.Email = Email;
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

    public void setIban(String iban) {
        this.Iban = Iban;
    }
}
