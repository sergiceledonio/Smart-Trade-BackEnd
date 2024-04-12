package codebusters.smarttradebackend.BusinessLogic.Models.Users;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

import java.io.Serializable;

@Entity
public class User {

    @Id
    private int Id;

    private String Email;
    private String Name;
    private String Password;

    @Column(unique = true)
    private String Dni;

    public User() {

    }

    public User(int Id, String Email, String Name, String Password, String Dni) {
        this.Id = Id;
        this.Email = Email;
        this.Name = Name;
        this.Password = Password;
        this.Dni = Dni;
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

    public String getDni() {
        return this.Dni;
    }

    public void setDni(String Dni) {
        this.Dni = Dni;
    }
}
