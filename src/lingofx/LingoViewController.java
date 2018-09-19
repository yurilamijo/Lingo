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
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

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
    
    @FXML
    private HBox hbox;
            
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        for (int i=1; i<=5; i++){
            hbox.getChildren().add(new Circle(150,150,35,Color.WHITE));
        }   
    }    
    
    public void setName(String name){
        labelName.setText(name);
    }
    
    @FXML
    private void sendWoordAction(ActionEvent event) {
        if(inputWoord.getText().matches(".*\\d+.*")) {
            System.out.println("numbers");
            woord.setText("Incorrect value");          
        } else {
            woord.setText(inputWoord.getText());    
//            letter.setText(Character.toString(inputWoord.getText().charAt(0)));
        }
        
        inputWoord.clear();
    }
}
