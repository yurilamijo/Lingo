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
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;

/**
 * FXML Controller class
 *  
 * @author yurilamijo
 */
public class LingoViewController implements Initializable {

    @FXML private Label labelName;
    @FXML private Label message;
    @FXML private Label timer;
    @FXML private TextField woordInput;
    @FXML private GridPane grid;
    
    private StackPane stackpane; 
    private String lingoWoord = "fiets";
    private int turn = 0;
    private final int maxValue = 5;
    
    private final Circle[][] circles = new Circle[maxValue][maxValue];
    private final Label[][] labels = new Label[maxValue][maxValue];
    private final String[] woorden = new String[maxValue];

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        buildBoard();
        labels[turn][0].setText(String.valueOf(lingoWoord.charAt(0)));
    }    
    
    public void setName(String name){
        labelName.setText(name);
    }
    
    private void timer(){
        
    }
    
    @FXML
    private void sendWoordAction(ActionEvent event) {      
        if (woordInput.getText().matches(".*\\d+.*") || woordInput.getText().length() != 5) {
            if (woordInput.getText().length() != 5) {
                message.setText("Woord moet 5 letters lang zijn");
            } else {
                message.setText("Incorrect value");
            }
        } else {
            if(turn < 5){
                changeBoard();
                turn++;
            } else {
                message.setText("Max turns");
            }
        }

        woordInput.clear();
    }
    
    private void buildBoard(){
        for(int i=0;i<5;i++){          
            for(int j=0;j<5;j++){
                stackpane = new StackPane();  
                Circle circle = new Circle(0,0,30,Color.GRAY);                             
                Label label = new Label();          
                label.setFont(new Font("Arial", 30));
                
                circles[i][j] = circle;
                labels[i][j] = label;
                
                stackpane.getChildren().add(circle);                
                stackpane.getChildren().add(label);
                grid.add(stackpane, j, i);
            }   
        }
    }
    
    private void changeBoard(){
        for(int i=0;i<labels[turn].length;i++){
            String letter = String.valueOf(woordInput.getText().charAt(i));
            Label letterLabel = labels[turn][i];
            
            woorden[turn] = woordInput.getText();
            letterLabel.setText(letter);
            
            checkWoord(i);
        }
    }

        
    private void checkWoord(int index){
        char woord = woorden[turn].charAt(index);
        // Check if letters are in lingoWoord
        if(lingoWoord.indexOf(woord) != -1){
            // Check if letter is same position
            if(String.valueOf(lingoWoord.charAt(index)).contains(String.valueOf(woord))){
                circles[turn][lingoWoord.indexOf(woord)].setFill(Color.GREEN);
            } else {
                circles[turn][woorden[turn].indexOf(woord)].setFill(Color.YELLOW);
            }
        }
    }
}
