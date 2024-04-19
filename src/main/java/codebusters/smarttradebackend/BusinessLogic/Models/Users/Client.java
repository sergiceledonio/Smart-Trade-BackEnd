package codebusters.smarttradebackend.BusinessLogic.Models.Users;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Client extends User {

    private int Id;
    private String Email;
    private String Dni;

    public Client(String Email, String Dni) {
        //super(Id, Email, Name, Password);
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

