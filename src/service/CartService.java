package service;

import model.Book;
import java.util.ArrayList;
import java.util.List;

public class CartService {

    private static CartService instance;
    private final List<Book> cartItems;

    private CartService() {
        cartItems = new ArrayList<>();
    }

    public static CartService getInstance() {
        if (instance == null) {
            instance = new CartService();
        }
        return instance;
    }

    public void addBook(Book book) {
        cartItems.add(book);
    }

    public void removeBook(Book book) {
        cartItems.remove(book);
    }

    public List<Book> getCartItems() {
        return cartItems;
    }

    public void clearCart() {
        cartItems.clear();
    }

    public double getTotalPrice() {
        return cartItems.stream()
                .mapToDouble(Book::getPrice)
                .sum();
    }
}
