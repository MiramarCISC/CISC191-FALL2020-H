package H2Database.db_model;


import H2Database.db_control.DBSource;
import H2Database.functionality.IllegalQuantityException;

import java.lang.IllegalArgumentException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ShoppingCart {
    private final int INITIAL_QUANTITY = 1;
    Map<Book, Integer> curCart = new HashMap<>();
    Date orderedDate;

    public void addToCartUsingISBN(String isbn) throws  IllegalQuantityException {
        updateCartUsingISBN(isbn, INITIAL_QUANTITY);
    }

    public void addToCartUsingTitle(String title) throws IllegalQuantityException {
        updateCartUsingTitle(title, INITIAL_QUANTITY);
    }

    public void removeFromCart(Book item) {
        curCart.remove(item);
    }

    public Map<Book, Integer> getCurCart() {
        return curCart;
    }

    public Date getOrderedDate() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.parse(format.format(new Date(System.currentTimeMillis())));
    }

    public boolean isInCart(String isbnOrTitle) {
        return isInCartISBN(isbnOrTitle) || isInCartTitle(isbnOrTitle);
    }

    public double cartTotal(){
        Iterator<Map.Entry<Book, Integer>> itr = curCart.entrySet().iterator();
        Map.Entry<Book,Integer> bookEntry;
        double total = 0;
        while (itr.hasNext()){
            bookEntry = itr.next();
            total+= bookEntry.getValue()*bookEntry.getKey().getPrice();
        }
        return total;
    }

    public void updateCartUsingISBN(String isbn, int newQuantity) throws IllegalQuantityException {
        Book book;
        try (ResultSet bookResult = DBSource.getConnection().getBookInfoByISBN(isbn)) {
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
            if (book.getStock()<newQuantity||newQuantity<=0)
                throw new IllegalQuantityException("Insufficient Stock");
            else
                updateCart(book, newQuantity);
        } catch (SQLException sqlException) {
            book = null;
        }
    }

    public void updateCartUsingTitle(String title, int newQuantity) throws IllegalQuantityException {
        Book book;
        try (ResultSet bookResult = DBSource.getConnection().getBookInfoByTitle(title)) {
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
            if (book.getStock()<newQuantity||newQuantity<=0)
                throw new IllegalQuantityException("Insufficient Stock");
            else
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
