package FX.SecondaryController;

import FX.mainFX.MainController;
import H2Database.db_control.DBSource;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class CustomerController implements Initializable {

    String insertedID;
    @FXML
    private Button createButton;
    @FXML
    private TextField firstNameTF;
    @FXML
    private TextField lastNameTF;
    @FXML
    private TextField ageTF;
    @FXML
    private TextField phoneTF;
    @FXML
    private TextField addressTF;
    @FXML
    private TextField emailTF;
    @FXML
    private Label nameAgeMS;
    @FXML
    private Label phoneMS;
    @FXML
    private Label emailMS;

    private SimpleBooleanProperty ageBoolean = new SimpleBooleanProperty(false);
    private SimpleBooleanProperty phoneBoolean = new SimpleBooleanProperty(false);
    private SimpleBooleanProperty emailBoolean = new SimpleBooleanProperty(false);
    private SimpleBooleanProperty firstNameBoolean = new SimpleBooleanProperty(false);
    private SimpleBooleanProperty lastNameBoolean = new SimpleBooleanProperty(false);

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        createButton.setDisable(true);
    }


    @FXML
    public void createCustomer(ActionEvent event) {

        Stage customerStage = (Stage) createButton.getScene().getWindow();
        DBSource dbSource = MainController.getDbSource();


        String firstName = firstNameTF.getText().trim();
        String lastName = lastNameTF.getText().trim();
        String name = String.join(" ", firstName, lastName);
        Integer age = Integer.parseInt(ageTF.getText().trim());
        String phone = phoneTF.getText().trim();
        String email = emailTF.getText().trim();
        String address = addressTF.getText().trim();


        try {
            insertedID = dbSource.createCustomer(name, age, phone, email, address);
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        customerStage.close();
    }

    private boolean isValidEmail(String email) {
        String regex = "^[\\w-_.+]*[\\w-_.]@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }

    private boolean isValidAge(Integer age) {
        return (age < 125 && age > 10);
    }

    private boolean isValidPhone(String email) {
        String regex = "^[2-9]{2}[0-9]{8}$";
        return email.matches(regex);
    }

    private boolean isValidName(String email) {
        String regex = "(?i)(^[a-z])((?![ .,'-]$)[a-z .,'-]){0,24}$"; //reference: https://stackoverflow.com/questions/46326822/java-regex-first-name-validation
        return email.matches(regex);
    }


    @FXML
    public void displayMessage(MouseEvent event) {
        if (firstNameTF.textProperty().isEmpty().getValue()
                || lastNameTF.textProperty().isEmpty().getValue()
                || ageTF.textProperty().isEmpty().getValue())
            nameAgeMS.setText("*Name and Age are required fields");
        else {
            nameAgeMS.setText("");
            try {
                Integer age = Integer.parseInt(ageTF.getText());
                if (!isValidAge(age)) {
                    nameAgeMS.setText("*Invalid Age");
                    ageBoolean.set(true);
                }
            } catch (NumberFormatException numberFormatException) {
                nameAgeMS.setText("*Invalid Age");
                ageBoolean.set(true);
            }
            if(!isValidName(firstNameTF.getText())){
                nameAgeMS.setText("*Invalid First Name");
                firstNameBoolean.set(true);
            }
            if(!isValidName(lastNameTF.getText())){
                nameAgeMS.setText("*Invalid Last Name");
                lastNameBoolean.set(true);
            }
        }
        if (!isValidPhone(phoneTF.getText()) && !phoneTF.textProperty().isEmpty().getValue()) {
            phoneMS.setText("*Invalid Phone Number");
            phoneBoolean.set(true);
        }
        if (!isValidEmail(emailTF.getText()) && !emailTF.textProperty().isEmpty().getValue()) {
            emailMS.setText("*Invalid Email Address");
            emailBoolean.set(true);
        }
    }

    @FXML
    public void hideMessageNameAge(MouseEvent event) {
        nameAgeMS.setText("");
        ageBoolean.set(false);
        firstNameBoolean.set(false);
        lastNameBoolean.set(false);
    }

    @FXML
    public void hideMessagePhone(MouseEvent event) {
        phoneMS.setText("");
        phoneBoolean.set(false);
    }

    @FXML
    public void hideMessageEmail(MouseEvent event) {
        emailMS.setText("");
        emailBoolean.set(false);
    }

    @FXML
    public void handleCreateBtn(MouseEvent event) {
        BooleanBinding booleanBind = firstNameTF.textProperty().isEmpty()
                .or(lastNameTF.textProperty().isEmpty())
                .or(ageTF.textProperty().isEmpty())
                .or(ageBoolean)
                .or(phoneBoolean)
                .or(emailBoolean)
                .or(firstNameBoolean)
                .or(lastNameBoolean);

        createButton.disableProperty().bind(booleanBind);
    }
}
