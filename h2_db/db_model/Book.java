/*
 * Contributors: Tu Hoang
 **/

package db_model;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import java.text.DecimalFormat;
import java.util.Random;

/*
 * This is the model class for BOOKS table.
 **/

public class Book {

    private SimpleStringProperty title = new SimpleStringProperty("");
    private SimpleStringProperty isbn = new SimpleStringProperty("");
    private SimpleDoubleProperty price = new SimpleDoubleProperty();
    private SimpleStringProperty publishedDate = new SimpleStringProperty("");
    private SimpleStringProperty author = new SimpleStringProperty("");
    private SimpleStringProperty category = new SimpleStringProperty("");
    private SimpleIntegerProperty quantity = new SimpleIntegerProperty(new Random().nextInt(3)+1);

    //Constructor
    public Book(String title, String isbn, Double price, String publishedDate, String author, String category) {
        this.title.set(title);
        this.isbn.set(isbn);
        this.price.set(Double.parseDouble(new DecimalFormat("#.##").format(price)));
        this.publishedDate.set(publishedDate);
        this.author.set(author);
        this.category.set(category);
    }


    //Setters and getters

    public String getTitle() {
        return title.get();
    }

    public SimpleStringProperty titleProperty() {
        return title;
    }

    public void setTitle(String title) {
        this.title.set(title);
    }

    public String getIsbn() {
        return isbn.get();
    }

    public SimpleStringProperty isbnProperty() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn.set(isbn);
    }

    public double getPrice() {
        return price.get();
    }

    public SimpleDoubleProperty priceProperty() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price.set(price);
    }

    public String getPublishedDate() {
        return publishedDate.get();
    }

    public SimpleStringProperty publishedDateProperty() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate.set(publishedDate);
    }

    public String getAuthor() {
        return author.get();
    }

    public SimpleStringProperty authorProperty() {
        return author;
    }

    public void setAuthor(String author) {
        this.author.set(author);
    }

    public String getCategory() {
        return category.get();
    }

    public SimpleStringProperty categoryProperty() {
        return category;
    }

    public void setCategory(String category) {
        this.category.set(category);
    }

    public int getQuantity() {
        return quantity.get();
    }

    public SimpleIntegerProperty quantityProperty() {
        return quantity;
    }

    public void increaseQuantity() {
        this.quantity.set(this.getQuantity()+1);
    }
}
