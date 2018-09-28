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
import javafx.geometry.Pos;
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

    @FXML private Label labelName;
    @FXML private TextField inputWoord;
    @FXML private Label woord;
    @FXML private GridPane grid;
    
    private final int maxValue = 5;
    
    private Circle[][] circles = new Circle[maxValue][maxValue];
    private Label[][] labels = new Label[maxValue][maxValue];
            
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        buildBoard();
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
            changeBoard();
        }
        
        inputWoord.clear();
    }
    
    private void buildBoard(){
        for(int i=0;i<5;i++){          
            for(int j=0;j<5;j++){
                Circle circle = new Circle(0,0,30,Color.GRAY);
                circles[i][j] = circle;
                grid.setHalignment(circle, HPos.CENTER);
                grid.add(circle, i, j); 
            }   
        }
        
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                Label label = new Label(Integer.toString(i));
                labels[i][j] = label;
                grid.setHalignment(label, HPos.CENTER);
                grid.add(label, i, j);
            }
        }
    }
    
    private void changeBoard(){
        String letter = "";
        List<String> letters = new ArrayList<String>();
        char c;
        
        for(int i=0;i<inputWoord.getText().length();i++){
            c = inputWoord.getText().charAt(i);
            letter = Character.toString(c);
            letters.add(letter);
        }

        changeLetter();
 
//        for(int i=0;i<cirles.size();i++){
//            Circle test = circles.get(i);
//        }
    }
    
    private void changeLetter(){
        System.out.println("Length: " + labels[0].length);
        for(int i=0;i<labels[0].length;i++){
            Label testLetter = labels[0][i];
            System.out.println(inputWoord.getText().charAt(i));
            testLetter.setText(inputWoord.getText());
        }
    }
}
