package codebusters.smarttradebackend.BusinessLogic.Models.Factory;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

//@Entity
public class Books {
    //@Id
    private int id;
    @Column(unique = true)
    private String name;
    private String title;
    private String author;
    private String saga;
    private String edition;
    private String description;

    public Books(String id, String name, String title, String author, String saga, String edition, String description) {
        this.id = Integer.parseInt(id);
        this.name = name;
        this.title = title;
        this.author = author;
        this.saga = saga;
        this.edition = edition;
        this.description = description;
    }


    public int getId() {
        return id;
    }

    // no deberia de poder cambiarse nunca, lo dejo por si acaso
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getSaga() {
        return saga;
    }

    public void setSaga(String saga) {
        this.saga = saga;
    }

    public String getEdition() {
        return edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}