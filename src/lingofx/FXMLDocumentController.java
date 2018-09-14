/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lingofx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author yurilamijo
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private TextField name;

    @FXML
    private void handleButtonAction(ActionEvent event) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("LingoView.fxml"));
        Parent lingoView = loader.load();

        LingoViewController controller = loader.getController();
        controller.setData(name.getText());

        Scene scene = new Scene(lingoView);        
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    private void kaartTestAction(ActionEvent event) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("BingoKaart.fxml"));
        Parent bingoKaart = loader.load();

        BingoKaartController controller = loader.getController();

        Scene scene = new Scene(bingoKaart);        
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.hide();
        stage.setScene(scene);
        stage.show();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
}
