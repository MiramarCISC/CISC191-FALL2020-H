package FX.mainFX;

import FX.fx_model.ItemCellFactory;
import FX.fx_model.PurchaseHistory;
import H2Database.db_control.DBSource;
import H2Database.db_model.Book;
import H2Database.db_model.ShoppingCart;

import H2Database.functionality.IllegalQuantityException;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
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
import java.text.DecimalFormat;
import java.util.Map;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.stream.IntStream;

public class MainController implements Initializable {
    @FXML
    private Label labelHistory;
    @FXML
    private Label addBookMS;
    @FXML
    private Label mainText;
    @FXML
    private Label totalMS;
    @FXML
    private Button checkout;
    @FXML
    private Button addBook;
    @FXML
    private Button purchases;
    @FXML
    private Button newCustomer;
    @FXML
    private Button processOrder;
    @FXML
    private TextField textHistory;
    @FXML
    private TextField validateCustomer;
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
    private static StringProperty deletedItem = new SimpleStringProperty();
    private static StringProperty bookName = new SimpleStringProperty();
    private static StringProperty bookISBN = new SimpleStringProperty();
    private static StringProperty newCustomerID = new SimpleStringProperty();
    private static IntegerProperty more = new SimpleIntegerProperty();
    private static DecimalFormat decimalFormat = new DecimalFormat("0.000");
    private static DBSource dbSource;

    private ShoppingCart shoppingCart = new ShoppingCart();
    private ObservableList observableList = FXCollections.observableArrayList();
    private Alert alert;

    public static DBSource getDbSource() {
        return dbSource;
    }

    public static StringProperty deletedItemProperty() {
        return deletedItem;
    }

    public static StringProperty bookNameProperty() {
        return bookName;
    }

    public static StringProperty bookISBNProperty() {
        return bookISBN;
    }

    public static StringProperty newCustomerIDProperty() {
        return newCustomerID;
    }

    public static IntegerProperty moreProperty() {
        return more;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dbSource = DBSource.getConnection();
        dbSource.preload();

        listView.setCellFactory(new ItemCellFactory());

        deletedItem.addListener((observableValue, oldValue, newValue) -> deleteBook(newValue));

        newCustomerID.addListener((observableValue, oldValue, newValue) -> validateCustomer.setText(newValue));

        more.addListener((observableValue, oldValue, newValue) -> {
            try {
                addBookMS.setText("");
                shoppingCart.updateCartUsingISBN(bookISBN.get(), newValue.intValue());
                totalMS.setText("Total: $" + decimalFormat.format(shoppingCart.cartTotal()));
            } catch (IllegalQuantityException e) {
                try {
                    shoppingCart.updateCartUsingISBN(bookISBN.get(), oldValue.intValue());
                    errorInsufficientStock("The requested book is out of stock", "Insufficient Stock");
                } catch (IllegalQuantityException illegalQuantityException) {
                }
            }
        });

        processOrder.setDisable(true);
        BooleanBinding booleanBind = validateCustomer.textProperty().isEmpty();
        processOrder.disableProperty().bind(booleanBind);
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
        try {
            dbSource.insertOrders(validateCustomer.getText().trim(), shoppingCart);
            alert = new Alert(Alert.AlertType.INFORMATION);
            setStyleAlert(alert);
            alert.setTitle("Process Order");
            alert.setContentText("Order Processed Successfully\n");
            alert.showAndWait();
            validateCustomer.clear();
            totalMS.setText("");
            listView.getItems().clear();
        } catch (SQLException sqlException) {
            errorInsufficientStock("Invalid ID","Invalid ID");
        }
    }

    private void addBook(ShoppingCart cart, String info) {
        addBookMS.setText("");
        String bookInfo = info.trim();
        boolean noMatching = false;
        if (!cart.isInCart(bookInfo)) {
            Map.Entry entry = null;
            if (!bookInfo.contains(" ")) {
                try {
                    cart.addToCartUsingISBN(bookInfo);
                    entry = cart.getCurCart().entrySet().stream()
                            .filter(e -> e.getKey().getIsbn().equals(bookInfo))
                            .findFirst()
                            .orElse(null);
                    noMatching = true;
                } catch (IllegalQuantityException e) {
                    errorInsufficientStock("The requested book is out of stock", "Insufficient Stock");
                }
            } else {
                try {
                    cart.addToCartUsingTitle(bookInfo);
                    entry = cart.getCurCart().entrySet().stream()
                            .filter(e -> e.getKey().getTitle().equals(bookInfo))
                            .findFirst()
                            .orElse(null);
                    noMatching = true;
                } catch (IllegalQuantityException e) {
                    errorInsufficientStock("The requested book is out of stock", "Insufficient Stock");
                }
            }

            if (entry != null) {
                listView.getItems().add(entry);
                totalMS.setText("Total: $" + decimalFormat.format(shoppingCart.cartTotal()));
            } else {
                if (noMatching) addBookMS.setText("*No Book Found");
            }
        }
    }

    private void deleteBook(String value) {
        try {
            alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Deleting Book");
            String[] strings = value.split(",");
            String title = strings[0];
            String isbn = strings[1];
            alert.setContentText("Delete " + title + " ?");
            setStyleAlert(alert);

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
            }
            deletedItem.unbind();
            deletedItem.setValue("");
            addBookMS.setText("");
            if (shoppingCart.getCurCart().isEmpty()) totalMS.setText("");
            else totalMS.setText("Total: $" + decimalFormat.format(shoppingCart.cartTotal()));

        } catch (ArrayIndexOutOfBoundsException exception) {
        }
    }

    private void setStyleAlert(Alert alert) {
        alert.getDialogPane()
                .getStylesheets()
                .add(MainController.class.getResource("/style.css").toExternalForm());
        alert.getDialogPane()
                .getStyleClass()
                .add("style");
    }

    private void errorInsufficientStock(String message, String title) {
        alert = new Alert(Alert.AlertType.ERROR);
        setStyleAlert(alert);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.show();
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
