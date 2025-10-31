//stor Book information (title, author, price, description)

// Book.java
package model;

public class Book {
    private String title;
    private String author;
    private String genre;
    private double price;

    public Book(String title, String author, String genre, double price){
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.price = price;
    }

    public String getTitle(){ return title; }
    public String getAuthor(){ return author; }
    public String getGenre(){ return genre; }
    public double getPrice(){ return price; }
}
