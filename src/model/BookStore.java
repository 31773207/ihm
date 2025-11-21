package model;

import java.util.ArrayList;
import java.util.List;

public class BookStore {

    public static List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();

        books.add(new Book(
            "<html>Harry Potter and the Philosopher's Stone</html>",
            "J.K. Rowling",
            19.99,
            "The first book in the Harry Potter series.",
            "/images/harry1.jpg",
            "Fantasy"
        ));

        books.add(new Book(
            "<html>Harry Potter and the Chamber of Secrets</html>",
            "J.K. Rowling",
            20.99,
            "The second book in the Harry Potter series.",
            "/images/harry2.jpg",
            "Fantasy"
        ));

        books.add(new Book(
            "<html>Harry Potter and the Prisoner of Azkaban</html>",
            "J.K. Rowling",
            21.99,
            "The third book in the Harry Potter series.",
            "/images/harry3.jpg",
            "Fantasy"
        ));

        books.add(new Book(
            "<html>Harry Potter and the Goblet of Fire</html>",
            "J.K. Rowling",
            22.99,
            "The fourth book in the Harry Potter series.",
            "/images/harry4.jpg",
            "Fantasy"
        ));

        books.add(new Book(
            "<html>Harry Potter and the Order of the Phoenix</html>",
            "J.K. Rowling",
            23.99,
            "The fifth book in the Harry Potter series.",
            "/images/harry5.jpg",
            "Fantasy"
        ));

        books.add(new Book(
            "<html>Harry Potter and the Half-Blood Prince</html>",
            "J.K. Rowling",
            24.99,
            "The sixth book in the Harry Potter series.",
            "/images/harry6.jpg",
            "Fantasy"
        ));

        books.add(new Book(
            "<html>Harry Potter and the Deathly Hallows</html>",
            "J.K. Rowling",
            25.99,
            "The seventh and final book in the Harry Potter series.",
            "/images/harry7.jpg",
            "Fantasy"
        ));

        books.add(new Book(
            "Percy Jackson: The Lightning Thief", 
            "Rick Riordan", 
            14.99, 
            "A demigod discovers his identity and goes on a quest.", 
            "/images/book8.jpg",
            "Fantasy"
        ));

        books.add(new Book(
            "The Fault in Our Stars",
            "John Green",
            16.99,
            "A touching story about young love, illness, and life.",
            "/images/book9.jpg",
            "Romance"
        ));

        books.add(new Book(
            "Divergent", 
            "Veronica Roth", 
            13.99, 
            "In a futuristic society, a girl challenges the rules and discovers herself.", 
            "/images/book10.jpg",
            "Sci-Fi"
        ));

        books.add(new Book(
           "Shadow and Bone", 
           "Leigh Bardugo", 
           14.99, 
           "A young soldier discovers a power that could unite her country.", 
           "/images/book11.jpg",
           "Fantasy"
        ));

        books.add(new Book(
            "Six of Crows", 
            "Leigh Bardugo", 
            16.99, 
            "A gang of teens attempt a deadly heist in a dangerous city.", 
            "/images/book12.jpg",
            "Fantasy"
        ));

        books.add(new Book(
            "The Fault in Our Stars", 
            "John Green", 
            13.99, 
            "Two teens with cancer fall in love and face life's challenges.", 
            "/images/book13.jpg",
            "Romance"
        ));

        // ... you can add more books with genre here

        return books;
    }
}



