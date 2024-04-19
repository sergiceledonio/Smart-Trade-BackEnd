package codebusters.smarttradebackend.BusinessLogic.Models.Search;

import codebusters.smarttradebackend.BusinessLogic.Models.Users.User;
import jakarta.persistence.*;
import codebusters.smarttradebackend.BusinessLogic.Models.Products.*;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

@Entity
public class Search {

    @Id
    private int Id;

    @ManyToOne(optional = true)
    @JoinColumn(name="Email")
    private User Email;

    @Column(unique = true)
    private Date Time;

    private String Text;
    private List<Product> SearchHistory = new ArrayList<Product>();

<<<<<<< HEAD
    public Search(int Id, User Email, Date Time, String Text) {
=======
    public Search(int Id, Usuario Email, Date Time, String Text, List<Product> SearchHistory) {
>>>>>>> e2fed781645c0c8a4b4a3765348504af73d85c62
        this.Id = Id;
        this.Email = Email;
        this.Time = Time;
        this.Text = Text;
        this.SearchHistory = SearchHistory;
    }

    public Search() {

    }

    public int getId() {
        return this.Id;
    }

    public void setId() {
        this.Id = Id;
    }
    public User getEmail() {
        return this.Email;
    }

    public void setEmail(User Email) {
        this.Email = Email;
    }

    public Date getTime() {
        return this.Time;
    }

    public void setTime(Date Time) {
        this.Time = Time;
    }

    public String getText() {
        return this.Text;
    }

    public void setTime(String Text) {
        this.Text = Text;
    }
}
