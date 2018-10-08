package lingofx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.stage.Stage;

public class PopupController implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    
    
    @FXML
    private void ActionOpnieuwButton(ActionEvent event){
        LingoViewController lvc = new LingoViewController();
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
        lvc.ExternalReset();
    }
}
