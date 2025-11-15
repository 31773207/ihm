package model;

import java.util.ArrayList;
import java.util.List;

public class AuthorStore {

    public static List<Author> getAllAuthors() {
        List<Author> authors = new ArrayList<>();

        // Example authors
        authors.add(new Author("J.K. Rowling", "/images/rowling.png"));
        authors.add(new Author("George R.R. Martin", "/images/martin.png"));
        authors.add(new Author("Agatha Christie", "/images/christie.png"));
        authors.add(new Author("Stephen King", "/images/king.png"));
        authors.add(new Author("Jane Austen", "/images/austen.png"));

        return authors;
    }
}


