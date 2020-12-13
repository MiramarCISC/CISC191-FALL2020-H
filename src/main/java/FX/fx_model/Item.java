package FX.fx_model;

import FX.mainFX.MainController;
import H2Database.db_model.Book;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.util.Map;

public class Item extends ListCell<Map.Entry<Book, Integer>> {

    private static StringProperty bookName = new SimpleStringProperty();
    private static IntegerProperty bookQuantity = new SimpleIntegerProperty();

    @FXML
    private Label titleLB;
    @FXML
    private Label authorLB;
    @FXML
    private Label quantityLB;
    @FXML
    private Label priceLB;
    @FXML
    private HBox hBox;
    @FXML
    private Button deleteBTN;
    @FXML
    private Button moreBtn;
    @FXML
    private Button lessBtn;

    public Item() {
        loadFXML();
    }

    private void loadFXML() {
        try {
            FXMLLoader loader = new FXMLLoader(Item.class.getResource("/item.fxml"));
            loader.setController(this);
            loader.setRoot(this);
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void updateItem(Map.Entry<Book, Integer> item, boolean empty) {
        super.updateItem(item, empty);
        if (empty || item == null) {
            setText(null);
            setGraphic(null);
        } else {

            String title;
            String author;
            String quantity;
            String price;
            if (item == null)
                title = author = quantity = price = "None";
            else {
                title = item.getKey().getTitle();
                author = "Author: " + item.getKey().getAuthor();
                quantity = "Quantity: " + String.valueOf(item.getValue());
                price = "Price: $" + String.valueOf(item.getKey().getPrice());
            }
            titleLB.setText(title);
            authorLB.setText(author);
            quantityLB.setText(quantity);
            priceLB.setText(price);

            setText(null);
            setGraphic(hBox);

            deleteBTN.setOnMouseClicked(mouseEvent -> {
                bookName.setValue(item.getKey().getTitle() + "," + item.getKey().getIsbn());
                MainController.deletedItemProperty().bind(bookName);
            });

            moreBtn.setOnMouseClicked(mouseEvent -> {
                MainController.bookISBNProperty().bind(new SimpleStringProperty(item.getKey().getIsbn()));
                MainController.moreProperty().bind(new SimpleIntegerProperty(item.getValue() + 1));
                quantityLB.setText("Quantity: " + String.valueOf(item.getValue()));
            });
            lessBtn.setOnMouseClicked(mouseEvent -> {
                MainController.bookISBNProperty().bind(new SimpleStringProperty(item.getKey().getIsbn()));
                if ((item.getValue() - 1) <= 0)
                    MainController.moreProperty().bind(new SimpleIntegerProperty(1));
                else
                    MainController.moreProperty().bind(new SimpleIntegerProperty(item.getValue() - 1));
                quantityLB.setText("Quantity: " + String.valueOf(item.getValue()));
            });
        }
    }
}
