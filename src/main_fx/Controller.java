package main_fx;


import db_main.DBSource;
import db_model.Book;
import db_model.ShoppingCart;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;

import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.Random;

public class Controller{


    public TableColumn<Book, String> bColumn;


    public void initialize(){

        this.bookData = FXCollections.observableArrayList(cartccurrent.getCurCart());
        tbview.setItems(this.bookData);
        tbview.setPlaceholder(new Label("Cart is empty!"));
        isbn_column.setCellValueFactory(new PropertyValueFactory<>("isbn"));
        title_column.setCellValueFactory(new PropertyValueFactory<>("title"));
        pdate_column.setCellValueFactory(new PropertyValueFactory<>("publishedDate"));
        quantity_column.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        author_column.setCellValueFactory(new PropertyValueFactory<>("author"));
        category_column.setCellValueFactory(new PropertyValueFactory<>("category"));
        bColumn.setCellFactory(bookButtonTableColumn -> new TableCell<>() {
            final Button btn = new Button("Just Do It");
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if(empty){
                    setText(null);
                    setGraphic(null);
                } else
                    setGraphic(btn);
                    btn.setOnAction(event -> {
                        bookData.get(this.getTableRow().getIndex()).increaseQuantity();
//                        if(bookData.get(this.getTableRow().getIndex()).getQuantity()==10){
//                            bookData.remove(this.getTableRow().getIndex());
//                        }

                    });

            }
        });

        index_column.setCellFactory(indexColumn -> new TableCell<>() {
            @Override
            protected void updateItem(Integer item, boolean empty) {
                super.updateItem(item, empty);
                if (item == null && empty){
                    setText(null);
                    setGraphic(null);
                } else
                    setText(this.getTableRow().getIndex() + 1 + "");

            }
        });
    }
    @FXML
    public TableColumn<Book, String> author_column;
    @FXML
    public TableColumn<Book, String> category_column;

    @FXML
    public TableColumn<Book, String> isbn_column;
    @FXML
    public TableColumn<Book, String> title_column;
    @FXML
    public TableColumn<Book, String> pdate_column;
    @FXML
    public TableColumn<Book, Integer> quantity_column;
    @FXML
    public TableColumn<Book, Integer> index_column;
    @FXML
    public TableView<Book> tbview;

    private ObservableList<Book> bookData;
    private ShoppingCart cartccurrent = new ShoppingCart();

    @FXML
    private Button addButton;
    @FXML
    public Button deleteButton;
    @FXML
    public void addBook(){
//        Book b1 = new Book();
//        b1.setIsbn(DBSource.getConnection().getBookData().get(new Random().nextInt(38)).getIsbn());
//        b1.setTitle(DBSource.getConnection().getBookData().get(new Random().nextInt(38)).getTitle());
//        b1.setPrice(DBSource.getConnection().getBookData().get(new Random().nextInt(38)).getPrice());
//        b1.setPublishedDate(DBSource.getConnection().getBookData().get(new Random().nextInt(38)).getPublishedDate());
//        b1.setAuthor(DBSource.getConnection().getBookData().get(new Random().nextInt(38)).getAuthor());
//        b1.setCategory(DBSource.getConnection().getBookData().get(new Random().nextInt(38)).getCategory());

        bookData.add(DBSource.getConnection().getBookData().get(new Random().nextInt(38)));
        //tbview.setItems(Bdata);

        //tbview.getItems().add(bookData.get(0));
        //tbview.getColumns().setAll(isbn_column,title_column ,pdate_column,quantity_column,totalprice_column);
    }

    public void deleteBook() {
        bookData.removeAll(tbview.getSelectionModel().getSelectedItems());
    }
}
