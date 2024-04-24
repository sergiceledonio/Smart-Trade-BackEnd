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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "time", unique = true)
    private Date time;

    @Column(name = "text")
    private String text;


    public Search(Date Time, String Text) {
        this.time = Time;
        this.text = Text;
    }

    public Search() {

    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
