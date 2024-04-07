package src.main.java.codebusters.smarttradebackend.BusinessLogic.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Column;

@Entity
public class Tourism extends Product {

    @Id
    private int Id;

    @Column(unique = true)
    @ManyToOne(optional = true)
    private String Name;

    private String Place;
    private int People;
    private String Type;
    private String Description;

    public Tourism(int Id, String Name, String Place, int People, String Type, String Description) {
        super(Id, Cif, Name, Price);
        this.Id = Id;
        this.Name = Name;
        this.Place = Place;
        this.People = People;
        this.Type = Type;
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

    public String getPlace() {
        return this.Place;
    }

    public void setPlace(String Place) {
        this.Place = Place;
    }

    public String getPeople() {
        return this.People;
    }

    public void setPeople(String People) {
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
