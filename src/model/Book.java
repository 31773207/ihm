package model;

public class Book {
    private String title;
    private String author;
    private double price;
    private String description;
    private String imagePath; // <-- this

    public Book(String title, String author, double price, String description, String imagePath) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.description = description;
        this.imagePath = imagePath;
    }

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public double getPrice() { return price; }
    public String getDescription() { return description; }
    public String getImagePath() { return imagePath; } // <-- return path
}


