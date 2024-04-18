package codebusters.smarttradebackend.BusinessLogic.Models.Factory;

public class Tourism {
    private int id;
    private String name;
    private String type;
    private String place;
    private String people;
    private String description;

    public Tourism(String id, String name, String type, String place, String people, String description) {
        this.id = Integer.parseInt(id);
        this.name = name;
        this.type = type;
        this.people = people;
        this.place = place;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getPeople() {
        return people;
    }

    public void setPeople(String people) {
        this.people = people;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


}