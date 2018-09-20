/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lingofx;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.HPos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
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
    private GridPane grid;
    
    private List<Circle> circles;
            
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        circles = new ArrayList<>();
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                Circle circle = new Circle(0,0,30,Color.GRAY);
                circles.add(circle);
                grid.setHalignment(circle, HPos.CENTER);
                grid.add(circle, i, j); 
            }   
        }
        
        System.out.println(circles.size());
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
        }
        
        inputWoord.clear();
    }
}
