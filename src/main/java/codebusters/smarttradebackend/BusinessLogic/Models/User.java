package codebusters.smarttradebackend.BusinessLogic.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Column;

@Entity
public class User {

    @Id
    private int Id;

    @Column(unique = true)
    private String Email;
<<<<<<< HEAD
    private String Name;
    private String Password;
=======

    private String Name;
    private String Password;

    public User(int Id, String Email, String Name, String Password) {
        this.Id = Id;
        this.Email = Email;
        this.Name = Name;
        this.Password = Password;
    }
>>>>>>> refs/remotes/origin/main

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

<<<<<<< HEAD
    public void setName(String nombre) {
        this.Name = nombre;
=======
    public void setName(String name) {
        this.Name = name;
>>>>>>> refs/remotes/origin/main
    }

    public String getPassword() {
        return this.Password;
    }

<<<<<<< HEAD
    public void setPassword(String contrasena) {
        this.Password = contrasena;
=======
    public void setPassword(String password) {
        this.Password = password;
>>>>>>> refs/remotes/origin/main
    }
}
