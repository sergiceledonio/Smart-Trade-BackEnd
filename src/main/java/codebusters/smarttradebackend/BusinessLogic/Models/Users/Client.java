package codebusters.smarttradebackend.BusinessLogic.Models.Users;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

@Entity
public class Client extends Usuario {

    @Id
    private int Id;
    @JoinColumn(name="Email")
    private String Email;
    @Column(unique = true)
    private String Dni;

    public Client(int Id, String Email, String Dni) {
        //super(Id, Email, Name, Password);
        this.Id = Id;
        this.Email = Email;
        this.Dni = Dni;
    }

    public Client() {

    }
    public String getDni() {
        return this.Dni;
    }

    public void setDni(String Dni) {
        this.Dni = Dni;
    }

}

