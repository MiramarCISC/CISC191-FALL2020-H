package main_fx;


import db_model.*;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class Main extends Application {
//    private Stage primarystage;

//    @Override
//    public void start(Stage stage) {
//
//        // sample data
//        Map<String, String> map = new HashMap<>();
//        map.put("one", "One");
//        map.put("two", "Two");
//        map.put("three", "Three");
//
//
//        // use fully detailed type for Map.Entry<String, String>
//        TableColumn<Map.Entry<String, String>, String> column1 = new TableColumn<>("Key");
//        column1.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Map.Entry<String, String>, String>, ObservableValue<String>>() {
//
//            @Override
//            public ObservableValue<String> call(TableColumn.CellDataFeatures<Map.Entry<String, String>, String> p) {
//                // this callback returns property for just one cell, you can't use a loop here
//                // for first column we use key
//                return new SimpleStringProperty(p.getValue().getKey());
//            }
//        });
//
//        TableColumn<Map.Entry<String, String>, String> column2 = new TableColumn<>("Value");
//        column2.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Map.Entry<String, String>, String>, ObservableValue<String>>() {
//
//            @Override
//            public ObservableValue<String> call(TableColumn.CellDataFeatures<Map.Entry<String, String>, String> p) {
//                // for second column we use value
//                return new SimpleStringProperty(p.getValue().getValue());
//            }
//        });
//
//        ObservableList<Map.Entry<String, String>> items = FXCollections.observableArrayList(map.entrySet());
//        final TableView<Map.Entry<String,String>> table = new TableView<>(items);
//
//        table.getColumns().setAll(column1, column2);
//
//        Scene scene = new Scene(table, 400, 400);
//        stage.setScene(scene);
//        stage.show();
//    }

    private double x, y;
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Customer.fxml"));
        primaryStage.setTitle("Checkout Management");
        primaryStage.setScene(new Scene(root));
        primaryStage.initStyle(StageStyle.UNDECORATED);

        //drag it here
        root.setOnMousePressed(event -> {
            x = event.getSceneX();
            y = event.getSceneY();
        });
        root.setOnMouseDragged(event -> {

            primaryStage.setX(event.getScreenX() - x);
            primaryStage.setY(event.getScreenY() - y);

        });
        root.requestFocus();
        primaryStage.show();
    }

    public static void main(String[] args) {

        launch(args);

    }

}

