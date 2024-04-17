package codebusters.smarttradebackend.BusinessLogic.Models.Users;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Client extends User {

    public Client(int Id, String Email, String Name, String Password, String Dni) {
        super(Id, Email, Name, Password, Dni);
    }

    public Client() {

    }


}

