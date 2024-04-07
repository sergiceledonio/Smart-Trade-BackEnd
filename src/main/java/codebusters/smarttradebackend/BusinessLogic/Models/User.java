package codebusters.smarttradebackend.BusinessLogic.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User {

    @Id
    private int Id;
    private String Email;
    private String Name;
    private String Password;

    public User() {}

    public User(int Id, String Email, String Name, String Password) {
        this.Id = Id;
        this.Email = Email;
        this.Name = Name;
        this.Password = Password;
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

    public void setEmail(String email) {
        this.Email = email;
    }

    public String getName() {
        return this.Name;
    }

    public String setName(String nombre) {
        return this.Name = nombre;
    }

    public String getPassword() {
        return this.Password;
    }
}
