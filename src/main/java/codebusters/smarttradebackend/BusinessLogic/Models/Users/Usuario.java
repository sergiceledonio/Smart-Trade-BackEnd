package codebusters.smarttradebackend.BusinessLogic.Models.Users;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

@Entity
public class Usuario {

    @Id
    private int Id;

    private String Email;
    private String Name;
    private String Password;


    public Usuario() {

    }

    public Usuario(int Id, String Email, String Name, String Password) {
        this.Id = Id;
        this.Email = Email;
        this.Name = Name;
        this.Password = Password;
    }

    public int getId() {
        return this.Id;
    }

    public void setId(int Id) {
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

    public void setName(String name) {
        this.Name = name;
    }

    public String getPassword() {
        return this.Password;
    }

    public void setPassword(String password) {
        this.Password = password;
    }
}


