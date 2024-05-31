package codebusters.smarttradebackend.BusinessLogic.Models.Pagos;

import codebusters.smarttradebackend.BusinessLogic.Models.Users.User;
import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "number")
    private String number;
    @Column(name = "name")
    private String name;
    @Column(name = "cvv")
    private String cvv;
    @Column(name = "expireDate")
    private String expireDate;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Card(){};
    public Card(String number, String name, String cvv, String expireDate, User user)
    {
        this.number = number;
        this.name = name;
        this.cvv = cvv;
        this.expireDate = expireDate;
        this.user = user;
    }
    public int getId() {
        return this.id;
    }
    public String getNumber() {
        return this.number;
    }
    public String getName() {
        return this.name;
    }
    public String getCvv() {
        return this.cvv;
    }
    public String getExpireDate() {
        return this.expireDate;
    }
    public User getUser() {
        return user;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public void setExpireDate(String expireDate) {
        this.expireDate = expireDate;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
