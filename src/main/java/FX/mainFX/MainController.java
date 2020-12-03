package FX.mainFX;

import FX.fx_model.PurchaseHistory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import H2Database.db_control.DBSource;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class MainController implements Initializable {

    @FXML
    private Label mainText;

    @FXML
    private Button checkout;

    @FXML
    private Button purchases;

    @FXML
    private TextField textHistory;

    @FXML
    private Button searchHistory;

    @FXML
    private Label labelHistory;

    @FXML
    private TableView<PurchaseHistory> tableView;

    @FXML
    private TableColumn<PurchaseHistory, String> orderIDColumn;

    @FXML
    private TableColumn<PurchaseHistory, Double> dateOrderedColumn;

    @FXML
    private TableColumn<PurchaseHistory, String> totalColumn;

    private ObservableList observableList = FXCollections.observableArrayList();
    private DBSource dbSource;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dbSource = DBSource.getConnection();
        dbSource.preload();
    }

    public void changeSection(ActionEvent event) throws SQLException {
        if(event.getSource()==checkout) {
            mainText.setText("Checkout");
        }
        else if(event.getSource()==purchases) {
            mainText.setText("History");
        }
    }

    public void searchHistoryButton(ActionEvent event){
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

            if(observableList.size()==0)
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
}
