package codebusters.smarttradebackend.Factory;

public class Books implements Product {
    private int id;
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

    @Override
    public String getProductType(){
        return "Books";
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

    @Override
    public void showInfo() {
        System.out.println("Name: " + name);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Saga: " + saga);
        System.out.println("Edition: " + edition);
        System.out.println("Description: " + description);
    }
}