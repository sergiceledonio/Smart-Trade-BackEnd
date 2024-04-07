package codebusters.smarttradebackend.BusinessLogic.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User {

    @Id
    private int id;
    private String Email;
    private String Name;
    private String Password;

    public int getId() {
        return this.id;
    }
    public void setId(int id) {
        this.id = id;
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

    public void setName(String nombre) {
        this.Name = nombre;
    }

    public String getPassword() {
        return this.Password;
    }

    public void setPassword(String contrasena) {
        this.Password = contrasena;
    }
}
