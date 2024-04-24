package codebusters.smarttradebackend.BusinessLogic.Models.Factory;

public class Product {
    private int id;
    private String CIF;
    private String Name;
    private String Price;

    public Product(String id, String cif, String name, String pryce) {
        this.id = Integer.parseInt(id);
        this.CIF = cif;
        this.Name = name;
        this.Price = pryce;
    }

    public Product() {

    }


    public int getId() {
        return id;
    }

    // no deberia de poder cambiarse nunca, lo dejo por si acaso
    public void setId(int id) {
        this.id = id;
    }

    public String getCif() {
        return CIF;
    }

    public void setCif(String cif) {
        this.CIF = cif;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getPrice() {
        return Price;
    }

    public void setPrice(String price) {
        this.Price = price;
    }


}
