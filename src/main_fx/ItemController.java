package main_fx;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import db_dao.BookImpl;
import db_model.Book;
import db_model.ShoppingCart;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

public class ItemController implements Initializable {
    public Label isbnlbl;
    public Label titlelbl;
    public Label authorlbl;
    public Label pricelbl;
    public JFXButton removeButton;
    public Label quanlbl;

    private BookImpl bDao = new BookImpl();

    private List<Book> tempList = bDao.getAllBooks();

    private ShoppingCart cartCurrent = new ShoppingCart();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Book b = tempList.get(new Random().nextInt(200));
        isbnlbl.setText(b.getIsbn());
        titlelbl.setText(b.getTitle());
        authorlbl.setText(b.getAuthor());
        quanlbl.setText(Integer.toString(b.getQuantity()));
        pricelbl.setText("$" + b.getPrice());

    }

}
