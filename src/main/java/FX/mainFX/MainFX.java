package FX.mainFX;

import H2Database.db_model.ShoppingCart;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MainFX extends Application {

    private double xOffset = 0;
    private double yOffset = 0;

    private static Stage primaryStage = null;

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage stage) throws Exception {
        primaryStage = stage;
        FXMLLoader loader = new FXMLLoader(MainFX.class.getResource("/main.fxml"));
        Parent root = loader.load();

        //makes the window movable
        //reference: https://stackoverflow.com/questions/13206193/how-to-make-an-undecorated-window-movable-draggable-in-javafx
        root.setOnMousePressed(event->{
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
        });
        root.setOnMouseDragged(event -> {
                primaryStage.setX(event.getScreenX() - xOffset);
                primaryStage.setY(event.getScreenY() - yOffset);
        });

        Scene scene = new Scene(root);
        //this style get rid of the normal top bar (collapse,minimize,close) of a window
        //but it makes the window not movable
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.setScene(scene);
        primaryStage.setTitle("CISC191H");
        primaryStage.show();
    }

    public static Stage getPrimaryStage() {
        return primaryStage;
    }
}
