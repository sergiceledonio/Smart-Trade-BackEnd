package codebusters.smarttradebackend.BusinessLogic.Models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class CreditCard {

    @Id
    private int Id;

    @ManyToOne(optional = true)
    @JoinColumn(name="DNI")
    private Client DNI;

    private String Name;
    private int Num;
    private Date ExpireDate;

    public CreditCard(int Id, Client Dni, String Name, int Num, Date CadDate) {
        this.Id = Id;
        this.DNI = Dni;
        this.Name = Name;
        this.Num = Num;
        this.ExpireDate = ExpireDate;
    }

    public CreditCard() {

    }

    public int getId() {
        return this.Id;
    }

    public void setId() {
        this.Id = Id;
    }

    public Client getDni() {
        return this.DNI;
    }

    public void setDni(Client Dni) {
        this.DNI = Dni;
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

    public Date getExpireDate() {
        return this.ExpireDate;
    }

    public void setExpireDate(Date ExpireDate) {
        this.ExpireDate = ExpireDate;
    }
}
