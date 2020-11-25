package db_model;

public class Book {
    private String isbn;
    private String title;
    private String author;
    private String category;
    private String publishedDate;
    private Double price;

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public Double getPrice() {
        return price;
    }
}
