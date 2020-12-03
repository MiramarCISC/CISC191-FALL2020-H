package FX.mainFX;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MainFX extends Application {

    private static Stage primaryStage = null;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        primaryStage = stage;
        FXMLLoader loader = new FXMLLoader(MainFX.class.getResource("/main.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(scene);
        primaryStage.setTitle("CISC191H");
        primaryStage.show();
    }

    public static Stage getPrimaryStage() {
        return primaryStage;
    }
}
