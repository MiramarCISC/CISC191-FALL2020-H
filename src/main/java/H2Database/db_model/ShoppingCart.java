package H2Database.db_model;


import H2Database.db_control.DBSource;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    Map<Book, Integer> curCart = new HashMap<>();
    Date orderedDate;

    private final int INITIAL_QUANTITY = 1;

    public void addToCartUsingISBN(String isbn){
        updateCartUsingISBN(isbn,INITIAL_QUANTITY);
    }
    public void addToCartUsingTitle(String title){
        updateCartUsingTitle(title,INITIAL_QUANTITY);
    }
    public void removeFromCart(Book item){
        curCart.remove(item);
    }

    public Map<Book, Integer> getCurCart() {
        return curCart;
    }

    public Date getOrderedDate() {
        return orderedDate;
    }

    public Book findBookISBN(String isbn){
        Book result = curCart.keySet().stream()
                                .filter(e -> e.getIsbn().equals(isbn))
                                .findFirst()
                                .orElse(null);
        return result;
    }
    public Book findBookTitle(String title){
        Book result = curCart.keySet().stream()
                                .filter(e -> e.getTitle().equals(title))
                                .findFirst()
                                .orElse(null);
        return result;
    }


    public void updateCartUsingISBN(String isbn,int newQuantity){
        ResultSet bookResult = DBSource.getConnection().getBookInfoByISBN(isbn);
        try {
            bookResult.next();
            Book book = new Book(
                    bookResult.getString("isbn"),
                    bookResult.getString("title"),
                    bookResult.getDouble("price"),
                    bookResult.getInt("stock"),
                    bookResult.getString("publishedDate"),
                    bookResult.getString("author"),
                    bookResult.getString("category")
            );
            updateCart(book,newQuantity);
        } catch (SQLException sqlException){
            sqlException.printStackTrace();
        }
    }
    public void updateCartUsingTitle(String title,int newQuantity){
        ResultSet bookResult = DBSource.getConnection().getBookInfoByTitle(title);
        try {
            bookResult.next();
            Book book = new Book(
                    bookResult.getString("isbn"),
                    bookResult.getString("title"),
                    bookResult.getDouble("price"),
                    bookResult.getInt("stock"),
                    bookResult.getString("publishedDate"),
                    bookResult.getString("author"),
                    bookResult.getString("category")
            );
            updateCart(book,newQuantity);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
    }
    private void updateCart(Book item, int newQuantity){
        curCart.put(item,newQuantity);
    }
}
