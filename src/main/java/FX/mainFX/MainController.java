package FX.mainFX;

import FX.fx_model.PurchaseHistory;
import H2Database.db_control.DBSource;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

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

    @FXML
    private FontAwesomeIcon close;

    @FXML
    private VBox vScroll;

    @FXML
    private GridPane checkOutPane;

    @FXML
    private GridPane purchasesPane;

    private ObservableList observableList = FXCollections.observableArrayList();
    private DBSource dbSource;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dbSource = DBSource.getConnection();
        dbSource.preload();
        buildCustomList();
    }

    @FXML
    public void changeSection(ActionEvent event) throws SQLException {
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
            close();
    }


    private static void close() {
        try {
            Stage closeStage = new Stage();
            FXMLLoader loader = new FXMLLoader(MainFX.class.getResource("/close.fxml"));
            Pane root = loader.load();
            Scene scene = new Scene(root);

            closeStage.setTitle("Exit");
            closeStage.initModality(Modality.APPLICATION_MODAL);
            closeStage.setScene(scene);
            closeStage.setResizable(false);
            closeStage.showAndWait();

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    private void buildCustomList() {
        Node node;
        for (int i = 0; i < 5; i++) {
            try {
                node = new FXMLLoader(MainFX.class.getResource("/item.fxml")).load();
                vScroll.getChildren().add(node);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        }
    }
}
