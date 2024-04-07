package src.main.java.codebusters.smarttradebackend.BusinessLogic.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Column;

@Entity
public class Book extends Product {

    @Id
    private int Id;

    @Column(unique = true)
    @ManyToOne(optional = true)
    private String Name;

    private String Title;
    private String Author;
    private String Saga;
    private int Edition;
    private String Description;

    public Book(int Id, String Name, String Title, String Author, String Saga, int Edition, String Description) {
        super(Id, Cif, Name, Price);
        this.Id = Id;
        this.Name = Name;
        this.Title = Title;
        this.Author = Author;
        this.Saga = Saga;
        this.Edition = Edition;
        this.Description = Description;
    }

    public int getId() {
        return this.Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getName() {
        return this.Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getTitle() {
        return this.Title;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public String getAuthor() {
        return this.Author;
    }

    public void setAuthor(String Author) {
        this.Author = Author;
    }

    public String getSaga() {
        return this.Saga;
    }

    public void setSaga(String Saga) {
        this.Saga = Saga;
    }

    public int getEdition() {
        return this.Edition;
    }

    public void setEdition(int Edition) {
        this.Edition = Edition;
    }

    public String getDescription() {
        return this.Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }
}
