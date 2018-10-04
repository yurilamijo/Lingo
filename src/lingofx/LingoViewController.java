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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author yurilamijo
 */
public class LingoViewController implements Initializable {

    @FXML
    private Label labelName;
    
    @FXML
    private TextField inputWoord;
    
    @FXML
    private Label woord;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void setData(String name){
        labelName.setText(name);
    }
    
    @FXML
    private void sendWoordAction(ActionEvent event) {
        if(inputWoord.getText().matches(".*\\d+.*")) {
            System.out.println("numbers");
            woord.setText("Incorrect value");
        } else {
            woord.setText(inputWoord.getText());
        }
        
        inputWoord.clear();
    }
}