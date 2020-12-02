package main_fx;


import db_main.*;
import db_model.*;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


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


    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("main.fxml"));
        primaryStage.setTitle("Checkout Management");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
    @Override
    public void init() throws Exception {
        super.init();
        if(!DBSource.getConnection().open()) {
            System.out.println("Cannot connect to the database..");
            Platform.exit();
        }
    }

//    @Override
//    public void stop() throws Exception {
//        super.stop();
//        DBSource.getConnection().close();
//    }

    public static void main(String[] args) {

        launch(args);
        System.out.println("Testing....");
        ShoppingCart cartccurrent = new ShoppingCart();
//        cartccurrent.addtoCart(new Book("iOS in Practice","1617291269",72.083,"2013-11-01","Bear P. Cahill","Mobile Technology"));
//        DBSource.getConnection().insertOrders(new Customer("5fbdc1865bd1221212312536e2",
//                                                            "Jami Pittman",
//                                                            24,
//                                                            "jamipittman@sdccd.edu",
//                                                            "+1 (840) 486-3880",
//                                                            "782 Tilden Avenue, Ryderwood, Georgia, 140"),cartccurrent);
//        ExecutorService excecutor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    }

}

