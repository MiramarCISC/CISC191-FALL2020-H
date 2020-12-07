package FX.SecondaryController;

import FX.mainFX.MainFX;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class CloseController {
    @FXML
    private Button closeYes;

    @FXML
    private Button closeNo;

    @FXML
    void closeButton(ActionEvent event) {
        Stage closeStage,mainStage;
        closeStage = (Stage) closeNo.getScene().getWindow();
        if (event.getSource()==closeYes){
            mainStage = MainFX.getPrimaryStage();
            mainStage.close();
            closeStage.close();
        }
        else if(event.getSource()==closeNo) {
            closeStage.close();
        }
    }
}
