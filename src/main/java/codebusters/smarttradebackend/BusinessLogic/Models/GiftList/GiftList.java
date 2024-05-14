package codebusters.smarttradebackend.BusinessLogic.Models.GiftList;

import codebusters.smarttradebackend.BusinessLogic.Models.Users.User;
import jakarta.persistence.*;

@Entity
@Table(name = "gift_list")
public class GiftList {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public GiftList(User user) {
        this.user = user;
    }

    public GiftList() {

    }

    public int getId() {
        return this.id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
