package main_fx;

import com.jfoenix.controls.*;
import db_dao.CusDaoImpl;
import db_model.Customer;
import db_source.H2Connection;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

public class CustomerController  implements Initializable {

    public JFXTextField nameField;
    public JFXTextField phoneField;
    public JFXTextField emailField;
    public JFXTextField adrsField;
    public JFXTextField idField;
    public JFXButton prcdButton;
    public JFXButton rdButton;
    public JFXTextField ageField;
    public JFXButton clrButton;
    public JFXButton newButton;
    public StackPane stackPane;


    private CusDaoImpl cusDao = new CusDaoImpl();
    private List<Customer> customerList = cusDao.getCustomersList();
    private Customer newCustomer;
    private JFXDialogLayout dialogLayout = new JFXDialogLayout();
    Label body = new Label();
    Label header = new Label("Error!");
    JFXButton dlButton = new JFXButton("OK");
    private double x, y;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        initDialog(dialogLayout, body, header, dlButton);

    }

    static void initDialog(JFXDialogLayout dialogLayout, Label body, Label header, JFXButton dlButton) {
        dialogLayout.setStyle("-fx-background-color: #313139");
        body.setStyle("-fx-font-size: 14px;-fx-text-fill: #b4bfe1; -fx-font-family: Consolas");
        header.setStyle("-fx-font-size: 16px;-fx-text-fill:  #b4bfe1; -fx-font-family: Consolas");
        dlButton.setStyle("-fx-background-color: #292C34; -fx-text-fill:  #b4bfe1");
        dlButton.setPrefWidth(65);
        dlButton.setPrefHeight(42);
        dlButton.setFont(Font.font("Consolas", FontWeight.NORMAL, FontPosture.REGULAR, 15));
    }

    @FXML
    void proceedToCart(ActionEvent event){
        if (newCustomer != null) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("Cart.fxml"));
                Parent CartViewParent = loader.load();
                CartController cartController = loader.getController();
                if (!customerList.contains(newCustomer)) {
                    cusDao.insertCustomer(newCustomer);
                }
                cartController.getCustomerInfo(newCustomer);

                Scene CartScene = new Scene(CartViewParent);
                Stage cartWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();
                cartWindow.setScene(CartScene);
                CartViewParent.setOnMousePressed(e -> {
                    x = e.getSceneX();
                    y = e.getSceneY();
                });
                CartViewParent.setOnMouseDragged(e -> {

                    cartWindow.setX(e.getScreenX() - x);
                    cartWindow.setY(e.getScreenY() - y);

                });
                cartWindow.centerOnScreen();
                cartWindow.show();
            } catch (SQLException | IOException e){
                System.out.println("Some thing went wrong when changing scene or inserting new customer! ");
                System.out.println(e.getMessage());
            }
        } else
            loadDialog(0);
    }


    @FXML
    void clearFields(){
        idField.clear();
        nameField.clear();
        ageField.clear();
        adrsField.clear();
        phoneField.clear();
        emailField.clear();
    }
    @FXML
    void randomizeCustomer(){
        Customer rdCustomer = customerList.get(new Random().nextInt(51));
        idField.setText(rdCustomer.getcId());
        nameField.setText(rdCustomer.getcName());
        phoneField.setText(rdCustomer.getcPhone());
        emailField.setText(rdCustomer.getcEmail());
        adrsField.setText(rdCustomer.getcAddress());
        ageField.setText(Integer.toString(rdCustomer.getcAge()));
        newCustomer = rdCustomer;
    }
    void loadDialog(int i){

        JFXDialog dialog = new JFXDialog(stackPane, dialogLayout, JFXDialog.DialogTransition.CENTER);

        if( i == 0 ){
            body.setText("Missing Information!");
        }
        if (i == 1){
            body.setText("\nCustomer ID already existed!\n\nPlease enter a different ID.");
        }
        if (i == 2){
            header.setText("Message");
            body.setText("\nAdded a new customer successfully!\n\nPlease proceed to check out");
        }
        dlButton.setOnAction(e -> dialog.close());
        dialogLayout.setActions(dlButton);
        dialogLayout.setHeading(header);
        dialogLayout.setBody(body);
        dialog.show();

    }
    boolean isExisted(String id){
        return customerList.stream().map(Customer::getcId).anyMatch(s -> s.equals(id));
    }

    @FXML
    void addNewCustomer(){
        if (idField.getText().trim().isEmpty() || nameField.getText().trim().isEmpty()
            || phoneField.getText().trim().isEmpty() || emailField.getText().trim().isEmpty()
            || adrsField.getText().trim().isEmpty() || ageField.getText().trim().isEmpty()){
            loadDialog(0);
        } else if (isExisted(idField.getText().trim())){
            System.out.println(idField.getText());
            loadDialog(1);

        } else {
            loadDialog(2);
            newCustomer = new Customer(idField.getText().trim(), nameField.getText().trim(), Integer.parseInt(ageField.getText().trim()),
                                        emailField.getText().trim(), phoneField.getText().trim(), adrsField.getText().trim());

        }
    }
    @FXML
    public void exit(){
        H2Connection.close();
        System.exit(0);
    }

}
