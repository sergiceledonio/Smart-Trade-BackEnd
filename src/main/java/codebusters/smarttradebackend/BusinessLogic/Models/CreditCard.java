package src.main.java.codebusters.smarttradebackend.BusinessLogic.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Column;

@Entity
public class CreditCard {

    @Id
    private int Id;

    @Column(unique = true)
    @ManyToOne(optional = true)
    private String Dni;

    private String Name;
    private int Num;
    private DateTime ExpireDate;

    public CreditCard(int Id, String Dni, String Name, int Num, DateTime CadDate) {
        this.Id = Id;
        this.Dni = Dni;
        this.Name = Name;
        this.Num = Num;
        this.ExpireDate = ExpireDate;
    }

    public int getId() {
        return this.Id;
    }

    public void setId() {
        this.Id = Id;
    }

    public String getDni() {
        return this.Dni;
    }

    public void setDni(String Dni) {
        this.Dni = Dni;
    }

    public String getName() {
        return this.Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getNum() {
        return this.Num;
    }

    public void setNum(int Num) {
        this.Num = Num;
    }

    public DateTime getExpireDate() {
        return this.ExpireDate;
    }

    public void setExpireDate(DateTime ExpireDate) {
        this.CadDate = ExpireDate;
    }
}
