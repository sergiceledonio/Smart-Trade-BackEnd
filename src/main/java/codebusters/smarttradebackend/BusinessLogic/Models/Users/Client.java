package codebusters.smarttradebackend.BusinessLogic.Models.Users;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Client extends Usuario {

    private String Dni;

    public Client(int Id, String Email, String Name, String Password, String Dni) {
        super(Id, Email, Name, Password);
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

