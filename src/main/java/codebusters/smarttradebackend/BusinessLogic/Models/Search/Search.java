package codebusters.smarttradebackend.BusinessLogic.Models.Search;

import codebusters.smarttradebackend.BusinessLogic.Models.Users.Usuario;
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
    private Usuario Email;

    @Column(unique = true)
    private Date Time;

    private String Text;
    private List<Product> SearchHistory = new ArrayList<Product>();

    public Search(int Id, Usuario Email, Date Time, String Text, List<Product> SearchHistory) {
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
    public Usuario getEmail() {
        return this.Email;
    }

    public void setEmail(Usuario Email) {
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
