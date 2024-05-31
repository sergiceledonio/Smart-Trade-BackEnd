package codebusters.smarttradebackend.BusinessLogic.Models.Pagos;

import codebusters.smarttradebackend.BusinessLogic.Models.Users.User;
import jakarta.persistence.*;

@Entity
public class Paypal {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Paypal(){};
    public Paypal(String email, String password, User user)
    {
        this.email = email;
        this.password = password;
        this.user = user;
    }
    public int getId() {
        return this.id;
    }
    public String getEmail() {
        return this.email;
    }
    public String getPassword() {
        return this.password;
    }
    public User getUser() {
        return user;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public void setUser(User user) {
        this.user = user;
    }
}
