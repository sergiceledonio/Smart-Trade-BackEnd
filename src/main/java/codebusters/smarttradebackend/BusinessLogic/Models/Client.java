package src.main.java.codebusters.smarttradebackend.BusinessLogic.Models;
package src.main.java.codebusters.smarttradebackend.BusinessLogic.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Column;

@Entity
public class Client extends User {

    @Id
    private int Id;

    @ManyToOne(optional = true)
    @Column(unique = true)
    private String Email;

    @Column(unique = true)
    private String Dni;

    public Buyer(int Id, String Email, String Dni) {
        super(Id, Email, Name, Password);
        this.Id = Id;
        this.Email = Email;
        this.Dni = Dni;
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

    public String getDni() {
        return this.Dni;
    }

    public void setDNI(String Dni) {
        this.Dni = Dni;
    }
}

