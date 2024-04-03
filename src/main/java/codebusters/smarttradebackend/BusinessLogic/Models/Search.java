package src.main.java.codebusters.smarttradebackend.BusinessLogic.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Column;

@Entity
public class Search {

    @Id
    private int Id;

    @Column(unique = true)
    @ManyToOne(optional = true)
    private String Email;

    @Column(unique = true)
    private DateTime Time;

    private String Text;

    public Search(int Id, String Email, DateTime Time, String Text) {
        this.Id = Id;
        this.Email = Email;
        this.Time = Time;
        this.Text = Text;
    }

    public int getId() {
        return this.Id;
    }

    public void setId() {
        this.Id = Id;
    }
    public String getEmail() {
        return this.Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public DateTime getTime() {
        return this.Time;
    }

    public void setTime(DateTime Time) {
        this.Time = Time;
    }

    public String getText() {
        return this.Text;
    }

    public void setTime(String Text) {
        this.Text = Text;
    }
}
