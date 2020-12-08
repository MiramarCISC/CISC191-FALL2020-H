package FX.fx_model;

import H2Database.db_model.Book;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.util.Map;

public class Item extends ListCell<Map.Entry<Book, Integer>> {

    @FXML
    private Label titleTF;

    @FXML
    private Label authorTF;

    @FXML
    private Label quantityTF;

    @FXML
    private Label priceTF;

    @FXML
    private HBox hBox;

    @FXML
    private Button deleteBTN;


    public Item() {
        loadFXML();
    }

    private void loadFXML() {
        try {
            FXMLLoader loader = new FXMLLoader(Item.class.getResource("/item.fxml"));
            loader.setController(this);
            loader.setRoot(this);
            loader.load();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void updateItem(Map.Entry<Book, Integer> item, boolean empty) {
        super.updateItem(item, empty);
        if (empty) {
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
                price = "Price: $"+ String.valueOf(item.getKey().getPrice());
            }


            titleTF.setText(title);
            authorTF.setText(author);
            quantityTF.setText(quantity);
            priceTF.setText(price);

            setText(null);
            setGraphic(hBox);
        }
    }

    public Button getDeleteBTN() {
        return deleteBTN;
    }
}
