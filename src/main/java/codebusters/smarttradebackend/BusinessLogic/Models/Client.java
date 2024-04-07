package codebusters.smarttradebackend.BusinessLogic.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Column;

@Entity
public class Client extends User {

    @Column(unique = true)
    private String DNI;

    public Client(int Id, String Email, String Dni, String Name, String Password) {
        super(Id, Email, Name, Password);
        this.DNI = Dni;
    }

    public Client() {

    }

    public String getDni() {
        return this.DNI;
    }

    public void setDNI(String Dni) {
        this.DNI = Dni;
    }
}

