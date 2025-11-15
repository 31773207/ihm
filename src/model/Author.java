package model;

public class Author {

    private String name;
    private String imagePath;

    // Constructor
    public Author(String name, String imagePath) {
        this.name = name;
        this.imagePath = imagePath;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getImagePath() {
        return imagePath;
    }

    // Optional setters if needed
    public void setName(String name) {
        this.name = name;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}

