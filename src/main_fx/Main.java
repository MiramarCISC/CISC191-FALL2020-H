package main_fx;


import db_main.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
        if (!DBSource.getConnection().open()) {
            System.out.println("Cannot connect to the database..");
            return;
        } else
        {
            DBSource.getConnection().preload();
        }
        ExecutorService excecutor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());


        DBSource.getConnection().close();
    }

}

