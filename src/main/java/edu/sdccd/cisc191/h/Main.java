package edu.sdccd.cisc191.h;/*
* Contributors: Tu Hoang
* */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

//edu.sdccd.cisc191.h.Main class of the application

public class Main extends Application {

    private double x, y;
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/Customer.fxml"));
        primaryStage.setTitle("Checkout Management");
        primaryStage.setScene(new Scene(root));
        primaryStage.initStyle(StageStyle.UNDECORATED);

        //Make the stage draggable
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

