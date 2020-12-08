package FX.mainFX;

import FX.fx_model.ItemCellFactory;
import FX.fx_model.PurchaseHistory;
import H2Database.db_control.DBSource;
import H2Database.db_model.Book;
import H2Database.db_model.ShoppingCart;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.stream.IntStream;

public class MainController implements Initializable {
    private static StringProperty deletedItem = new SimpleStringProperty();

    private static DBSource dbSource;

    @FXML
    private Label labelHistory;
    @FXML
    private Label addBookMS;
    @FXML
    private Label mainText;
    @FXML
    private Button checkout;
    @FXML
    private Button addBook;
    @FXML
    private Button purchases;
    @FXML
    private Button newCustomer;
    @FXML
    private TextField textHistory;
    @FXML
    private TextField searchBook;
    @FXML
    private TableView<PurchaseHistory> tableView;
    @FXML
    private TableColumn<PurchaseHistory, String> orderIDColumn;
    @FXML
    private TableColumn<PurchaseHistory, Double> dateOrderedColumn;
    @FXML
    private TableColumn<PurchaseHistory, String> totalColumn;
    @FXML
    private FontAwesomeIcon close;
    @FXML
    private ListView<Map.Entry<Book, Integer>> listView;
    @FXML
    private GridPane checkOutPane;
    @FXML
    private GridPane purchasesPane;
    private ShoppingCart shoppingCart = new ShoppingCart();
    private ObservableList observableList = FXCollections.observableArrayList();

    public static DBSource getDbSource() {
        return dbSource;
    }

    public static StringProperty deletedItemProperty() {
        return deletedItem;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dbSource = DBSource.getConnection();
        dbSource.preload();

        listView.setCellFactory(new ItemCellFactory());

        deletedItem.addListener((observableValue, oldValue, newValue) -> deleteBook(newValue));
    }

    @FXML
    public void changeSection(ActionEvent event) {
        if (event.getSource() == checkout) {
            mainText.setText("Checkout");
            checkOutPane.toFront();
        } else if (event.getSource() == purchases) {
            mainText.setText("History");
            purchasesPane.toFront();
        }
    }

    @FXML
    public void searchHistoryButton(ActionEvent event) {
        tableView.getItems().clear();
        String keyID = textHistory.getText();
        ResultSet resultSet;
        try {
            resultSet = dbSource.getPurchaseHistory(keyID);
            while (resultSet.next()) {
                observableList.add(new PurchaseHistory(
                        resultSet.getString("order_id"),
                        resultSet.getString("date_ordered"),
                        resultSet.getDouble("total")));
            }

            if (observableList.size() == 0)
                labelHistory.setText("No Matching ID");

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

        this.orderIDColumn.setCellValueFactory(new PropertyValueFactory<>("orderID"));
        this.dateOrderedColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        this.totalColumn.setCellValueFactory(new PropertyValueFactory<>("total"));

        this.tableView.setItems(null);
        this.tableView.setItems(observableList);
    }

    @FXML
    void handleClose(MouseEvent event) {
        if (event.getSource() == close)
            buildNewStage("Exit", "close");
    }

    @FXML
    public void createCustomer(ActionEvent event) {
        if (event.getSource() == newCustomer) {
            buildNewStage("New Customer", "newcustomer");
        }
    }

    @FXML
    public void addBookToCart(ActionEvent event) {
        String bookInfo = searchBook.getText();
        addBook(shoppingCart, bookInfo);
        searchBook.clear();
    }

    private void buildNewStage(String title, String fxmlName) {
        try {
            Stage closeStage = new Stage();
            FXMLLoader loader = new FXMLLoader(MainFX.class.getResource("/" + fxmlName + ".fxml"));
            Pane root = loader.load();
            Scene scene = new Scene(root);

            closeStage.setTitle(title);
            closeStage.initModality(Modality.APPLICATION_MODAL);
            closeStage.setScene(scene);
            closeStage.setResizable(false);
            closeStage.showAndWait();

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    @FXML
    public void processOrder(ActionEvent event) {
        int selected = listView.getSelectionModel().getSelectedIndex();
        System.out.println(selected);
        listView.getItems().remove(selected);
    }

    private void addBook(ShoppingCart cart, String info) {
        String bookInfo = info.trim();
        if (!cart.isInCart(bookInfo)) {
            Map.Entry entry;
            if (!bookInfo.contains(" ")) {
                cart.addToCartUsingISBN(bookInfo);
                entry = cart.getCurCart().entrySet().stream()
                        .filter(e -> e.getKey().getIsbn().equals(bookInfo))
                        .findFirst()
                        .orElse(null);
            } else {
                cart.addToCartUsingTitle(bookInfo);
                entry = cart.getCurCart().entrySet().stream()
                        .filter(e -> e.getKey().getTitle().equals(bookInfo))
                        .findFirst()
                        .orElse(null);
            }

            if (entry != null)
                listView.getItems().add(entry);
            else
                addBookMS.setText("No Book Found");
        }
    }
    
    private void deleteBook(String value) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Deleting Book");
        String[] strings = value.split(",");
        String title = strings[0];
        String isbn = strings[1];
        alert.setContentText("Delete " + title + " ?");
        Optional<ButtonType> answer = alert.showAndWait();
        ObservableList<Map.Entry<Book, Integer>> items = listView.getItems();
        if (answer.get() == ButtonType.OK) {
            shoppingCart.removeFromCart(new Book(isbn));
            int selectedIndex = IntStream
                    .range(0, items.size())
                    .filter(i -> items.get(i).getKey().getIsbn().equals(isbn))
                    .findFirst()
                    .orElse(-1);
            listView.getItems().remove(selectedIndex);
        } else {
            deletedItem.unbind();
            deletedItem.setValue("");
            //Reference: https://github.com/afsalashyana/Library-Assistant/blob/master/src/library/assistant/alert/AlertMaker.java
            alert.setTitle("Deletion Canceled");
            alert.setHeaderText(null);
            alert.setContentText("DELETION PROCESS CANCELED!");
            alert.showAndWait();
        }
    }
}
//    private void buildCustomList() {
//        for (int i = 0; i < 4; i++) {
//            try {
//                Parent parent = new FXMLLoader(MainFX.class.getResource("/item.fxml")).load();
//                vScroll.getChildren().add(parent);
//            } catch (IOException ioException) {
//                ioException.printStackTrace();
//            }
//        }
//
//    }
