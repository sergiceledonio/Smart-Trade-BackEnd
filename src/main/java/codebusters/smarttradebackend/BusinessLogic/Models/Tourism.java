package codebusters.smarttradebackend.BusinessLogic.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Column;

@Entity
public class Tourism extends Product {

    private String Place;
    private int People;
    private String Type;
    private String Description;

    public Tourism(int Id, String Name, String Place, int People, String Type, String Description, Seller cif, double price) {
        super(Id, cif, Name, price);
        this.Place = Place;
        this.People = People;
        this.Type = Type;
        this.Description = Description;
    }

    public Tourism() {

    }

    public String getPlace() {
        return this.Place;
    }

    public void setPlace(String Place) {
        this.Place = Place;
    }

    public int getPeople() {
        return this.People;
    }

    public void setPeople(int People) {
        this.People = People;
    }

    public String getType() {
        return this.Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public String getDescription() {
        return this.Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }
}
