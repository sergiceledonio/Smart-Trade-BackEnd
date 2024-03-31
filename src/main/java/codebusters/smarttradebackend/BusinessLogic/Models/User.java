package codebusters.smarttradebackend.BusinessLogic.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User {

    @Id
    private String Email;
    private String Nombre;
    private String Contrasena;

    public String getEmail() {
        return this.Email;
    }
    public void setEmail(String email) {
        this.Email = email;
    }

    public String getNombre() {
        return this.Nombre;
    }

    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }

    public String getcontrasena() {
        return this.Contrasena;
    }

    public void setContrasena(String contrasena) {
        this.Contrasena = contrasena;
    }
}
