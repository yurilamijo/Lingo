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
import javafx.geometry.HPos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
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
    @FXML private TextField woordInput;
    @FXML private Label woord;
    @FXML private GridPane grid;
    
    private String lingoWoord = "fiets";
    private int turn = 0;
    private final int maxValue = 5;
    
    private final Circle[][] circles = new Circle[maxValue][maxValue];
    private final Label[][] labels = new Label[maxValue][maxValue];
    private final String[] woorden = new String[maxValue];
            
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        buildBoard();
    }    
    
    public void setName(String name){
        labelName.setText(name);
    }
    
    @FXML
    private void sendWoordAction(ActionEvent event) {
        
        if (woordInput.getText().matches(".*\\d+.*") || woordInput.getText().length() != 5) {
            System.out.println("numbers");
            if (woordInput.getText().length() != 5) {
                woord.setText("Woord moet 5 letters lang zijn");
            } else {
                woord.setText("Incorrect value");
            }
        } else {
            if(turn < 5){
                woord.setText(woordInput.getText());
//              charNum.setText(String.valueOf(wordInput.getText().length()));
                changeBoard();
                turn++;
                
//                System.out.println("Letters" + Arrays.deepToString(woorden));
            } else {
                woord.setText("Max turns");
            }
        }

        woordInput.clear();
    }
    
    private void buildBoard(){
        for(int i=0;i<5;i++){          
            for(int j=0;j<5;j++){
                Circle circle = new Circle(0,0,30,Color.GRAY);
                circles[i][j] = circle;
                grid.setHalignment(circle, HPos.CENTER);
                grid.add(circle, j, i); 
            }   
        }
        
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                Label label = new Label();
                label.setFont(new Font("Arial", 30));
                labels[i][j] = label;
                grid.setHalignment(label, HPos.CENTER);
                grid.add(label, j, i);
            }
        }
    }
    
    private void changeBoard(){
        changeLetter(turn);
    }
    
    private void changeLetter(int turn){
        for(int i=0;i<labels[turn].length;i++){
            String letter = String.valueOf(woordInput.getText().charAt(i));
            woorden[turn] = woordInput.getText();
            Label letterLabel = labels[turn][i];
            letterLabel.setText(letter);
            
            checkWoord(i);
        }
        System.out.println("\n");
    }
    
    private void checkWoord(int letters){
        // Check if letters are in lingoWoord
        if(lingoWoord.indexOf(woorden[turn].charAt(letters)) != -1){
            System.out.println("woord contains letter but wrong position: " + woorden[turn].charAt(letters));
            
            // Check if letter is same position
            if(String.valueOf(lingoWoord.charAt(letters)).contains(String.valueOf(woorden[turn].charAt(letters)))){
                System.out.println(woorden[turn].charAt(letters) + " Same position");
            }
        }
    }
}
