package main_fx;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import db_dao.BookImpl;
import db_dao.OrderHistoryImpl;
import db_model.Book;
import db_model.Customer;
import db_model.ShoppingCart;
import db_source.H2Connection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.*;
import javafx.scene.layout.StackPane;

import java.net.URL;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

public class CartController implements Initializable {


    public JFXButton addButton;
    public Label itemslbl;
    public Label subtlbl;
    public Label totallbl;
    public StackPane stackPane;


    private final OrderHistoryImpl orderHistoryAcess = new OrderHistoryImpl();
    private final BookImpl bookAcess = new BookImpl();

    private final List<Book> tempList = bookAcess.getAllBooks();

    private final ShoppingCart curCart = new ShoppingCart();
    @FXML
    public TableColumn<Book, String> author_column;
    @FXML
    public TableColumn<Book, Double> price_column;

    @FXML
    public TableColumn<Book, String> isbn_column;
    @FXML
    public TableColumn<Book, String> title_column;
    @FXML
    public TableColumn<Book, Integer> quantity_column;
    @FXML
    public TableView<Book> tbview;
    @FXML
    public TableColumn<Book, String> bColumn;
    public JFXButton clearButton;
    public Label welcomelbl;
    public JFXButton payButton;

    private ObservableList<Book> bookData;
    private Customer curCustomer;
    private final JFXDialogLayout dialogLayout = new JFXDialogLayout();
    private final Label body = new Label();
    private final Label header = new Label("Error!");
    private final JFXButton dlButton = new JFXButton("OK");



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        CustomerController.initDialog(dialogLayout, body, header, dlButton);
        bookData = FXCollections.observableArrayList();
        initData();

    }

    private void initData() {
        Label placeHolder = new Label("Cart is empty!");
        placeHolder.setStyle("-fx-text-fill: #beceff; -fx-font-size: 20px; -fx-font-family: Consolas");
        tbview.setPlaceholder(placeHolder);
        isbn_column.setCellValueFactory(new PropertyValueFactory<>("isbn"));
        title_column.setCellValueFactory(new PropertyValueFactory<>("title"));
        quantity_column.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        author_column.setCellValueFactory(new PropertyValueFactory<>("author"));
        price_column.setCellValueFactory(new PropertyValueFactory<>("price"));
        bColumn.setCellFactory(TableColumn -> new TableCell<>() {
            final ImageView icon = new ImageView(new Image("file:src/images/trash-can-outline.png"));
            final Button removeButton = new Button("",icon);
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (item == null && empty) {
                    setText(null);
                    setGraphic(null);
                } else {
                    itemslbl.setText(bookData.stream().map(Book::getQuantity).reduce(0, Integer::sum).toString());

                    Double sumPrice = bookData.stream()
                            .map(book -> ((double)book.getQuantity()) * book.getPrice())
                            .reduce(0.0, Double::sum);

                    subtlbl.setText("$" + new DecimalFormat("#.##").format(sumPrice));

                    totallbl.setText("$" + new DecimalFormat("#.##").format(sumPrice * 1.075));

                    icon.setFitWidth(23);
                    icon.setFitHeight(23);
                    setGraphic(removeButton);
                    removeButton.setFocusTraversable(false);
                    removeButton.setPrefHeight(45.0);
                    removeButton.setPrefWidth(45.0);
                    removeButton.setGraphicTextGap(0);
                    removeButton.getStylesheets().add("file:src/main_fx/style.css");
                    removeButton.setOnMouseClicked(event -> {
                        bookData.remove(this.getTableRow().getIndex());
                        if (bookData.isEmpty()){
                            itemslbl.setText("0");
                            totallbl.setText("");
                            subtlbl.setText("");
                        }

                    });



                }

            }
        });
        tbview.setItems(bookData);
    }

    @FXML
    public void pay(){
        if(bookData.isEmpty()){
            loadDialog(0, null);
        } else {
            bookData.forEach(curCart::addToCart);
            String orderId = orderHistoryAcess.insertOrders(curCustomer, curCart);
            loadDialog(1, orderId);
            new Thread(() -> bookAcess.changeStocks(curCart.getCurCart())).start();
            clearButton.fire();
        }
    }
    @FXML
    public void exit(){

        System.exit(0);
    }



    @FXML
    public void scanRandom(){
        if(tempList!=null){
            bookData.add(tempList.get(new Random().nextInt(207)));
        }
    }
    @FXML
    public void clearAll(){
        bookData.clear();
        itemslbl.setText("0");
        totallbl.setText("");
        subtlbl.setText("");
    }

    public void getCustomerInfo(Customer newCustomer) {
        curCustomer = newCustomer;
        welcomelbl.setText("Welcome, "+curCustomer.getcName().split(" ")[0]);
    }
    void loadDialog(int i, String id){

        JFXDialog dialog = new JFXDialog(stackPane, dialogLayout, JFXDialog.DialogTransition.CENTER);

        if( i == 0 ){
            body.setText("There is nothing in cart!");
        }
        if (i == 1){
            header.setText(getReceiptHeading(id));
            body.setText(getReceiptBody(itemslbl.getText(), subtlbl.getText(),totallbl.getText()));
        }
        dlButton.setOnAction(e -> dialog.close());
        dialogLayout.setActions(dlButton);
        dialogLayout.setHeading(header);
        dialogLayout.setBody(body);
        dialog.show();

    }

    private String getReceiptBody(String itemsSold, String subTotal, String totalPrice) {

        return String.format("%46s", "Date: " + curCart.getOrderedDate()) + String.format("%n**********************************************") +
                    String.format("%n%46s", "#Items Sold: " + itemsSold) +
                    String.format("%n%46s", "Subtotal: " + subTotal) +
                    String.format("%n%46s", "Sale's Tax: 7.5%") +
                    String.format("%n%46s", "Total Amount: " + totalPrice) +
                    String.format("%n**********************************************") +
                    String.format("%n%46s", "Transaction Type: Credit Card") +
                    String.format("%n%46s", "Authorization: Approved") +
                    String.format("%n%46s", "Change due: $0.0") +
                    "\n";
    }

    String getReceiptHeading(String orderId){

        return "\t\tBOOK STORE" + String.format("\n%26s", "ADDRESS: #") +
                    String.format("\n%31s", "PHONE: 123-1234-1234") +
                    String.format("\n%36s", "Receipt for Order #" + orderId);
    }
}
