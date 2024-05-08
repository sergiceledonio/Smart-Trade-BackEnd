package codebusters.smarttradebackend.BusinessLogic.Models.ShoppingCart;

import codebusters.smarttradebackend.BusinessLogic.Models.Users.User;
import jakarta.persistence.*;

@Entity
@Table(name = "shopping_cart")
public class ShoppingCart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public ShoppingCart(User user) {
        this.user = user;
    }

    public ShoppingCart(){

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
