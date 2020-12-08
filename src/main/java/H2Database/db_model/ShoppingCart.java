package H2Database.db_model;


import H2Database.db_control.DBSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private final int INITIAL_QUANTITY = 1;
    Map<Book, Integer> curCart = new HashMap<>();
    Date orderedDate;

    public void addToCartUsingISBN(String isbn) {
        updateCartUsingISBN(isbn, INITIAL_QUANTITY);
    }

    public void addToCartUsingTitle(String title) {
        updateCartUsingTitle(title, INITIAL_QUANTITY);
    }

    public void removeFromCart(Book item) {
        curCart.remove(item);
    }

    public Map<Book, Integer> getCurCart() {
        return curCart;
    }

    public Date getOrderedDate() {
        return orderedDate;
    }

    public boolean isInCart(String isbnOrTitle) {
        return isInCartISBN(isbnOrTitle) || isInCartTitle(isbnOrTitle);
    }

    protected void updateCartUsingISBN(String isbn, int newQuantity) {
        Book book;
        try(ResultSet bookResult = DBSource.getConnection().getBookInfoByISBN(isbn)) {
            bookResult.next();
            book = new Book(
                    bookResult.getString("isbn"),
                    bookResult.getString("title"),
                    bookResult.getDouble("price"),
                    bookResult.getInt("stock"),
                    bookResult.getString("publishedDate"),
                    bookResult.getString("author"),
                    bookResult.getString("category")
            );
            updateCart(book, newQuantity);
        } catch (SQLException sqlException) {
            book = null;
        }
    }

    protected void updateCartUsingTitle(String title, int newQuantity) {
        Book book;
        try(ResultSet bookResult = DBSource.getConnection().getBookInfoByTitle(title)) {
            bookResult.next();
            book = new Book(
                    bookResult.getString("isbn"),
                    bookResult.getString("title"),
                    bookResult.getDouble("price"),
                    bookResult.getInt("stock"),
                    bookResult.getString("publishedDate"),
                    bookResult.getString("author"),
                    bookResult.getString("category")
            );
            updateCart(book, newQuantity);
        } catch (SQLException sqlException) {
            book = null;
        }
    }


    private boolean isInCartISBN(String isbn) {
        return curCart.containsKey(new Book(isbn));
    }

    private boolean isInCartTitle(String title) {
        Book result = curCart.keySet().stream()
                .filter(e -> e.getTitle().equals(title))
                .findFirst()
                .orElse(null);
        return (result != null);
    }

    private void updateCart(Book item, int newQuantity) {
        curCart.put(item, newQuantity);
    }
}
