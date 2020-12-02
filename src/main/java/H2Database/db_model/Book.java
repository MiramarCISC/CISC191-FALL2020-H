package H2Database.db_model;

public class Book {
    private String isbn;
    private String title;
    private Double price;
    private Integer stock;
    private String publishedDate;
    private String author;
    private String category;

    public Book(String isbn, String title, Double price, Integer stock, String publishedDate, String author, String category) {
        this.isbn = isbn;
        this.title = title;
        this.price = price;
        this.stock = stock;
        this.publishedDate = publishedDate;
        this.author = author;
        this.category = category;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public Double getPrice() {
        return price;
    }

    public String getAuthor() {
        return author;
    }

    public String getCategory() {
        return category;
    }

    public String getPublishedDate() {
        return publishedDate;
    }
}
