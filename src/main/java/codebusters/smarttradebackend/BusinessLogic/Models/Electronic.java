package src.main.java.codebusters.smarttradebackend.BusinessLogic.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Column;

@Entity
public class Electronic extends {

    @Id
    private int Id;

    @Column(unique = true)
    @ManyToOne(optional = true)
    private String Name;

    private String Material;
    private String Type;
    private String Description;

    public Electronic(int Id, String Name, String Material, String Type, String Description) {
            super(Id, Cif, Name, Price);
            this.Id = Id;
            this.Name = Name;
            this.Material = Material;
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

    public String getMaterial() {
        return this.Material;
    }

    public void setMaterial(String Material) {
        this.Material = Material;
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
