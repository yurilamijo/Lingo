/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lingofx;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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

    public WordList wl = new WordList();
    
    @FXML private Label labelName;
    @FXML private Label message;
    @FXML private Label timer;
    @FXML private Label turnsLabel;
    @FXML private TextField woordInput;
    @FXML private GridPane grid;
    @FXML private Button nextWoord;
    
    private StackPane stackpane; 
    private String lingoWoord;
    private int turn;
    private final int maxValue = 5;
    
    private final Circle[][] circles = new Circle[maxValue][maxValue];
    private final Label[][] labels = new Label[maxValue][maxValue];
    private String[] woorden = new String[maxValue];

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        buildBoard();
        newGame();
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
            if(turn < 4){
                changeBoard();
                turn++;
                turnsLabel.setText("Trun: " + (turn+1));
            } else {
                message.setText("Verloren!!");
                nextWoord.setVisible(true);
            }
        }
        woordInput.clear();
    }
    
    @FXML
    private void nextWoordAction(ActionEvent event){
        clearBoard();
        newGame();
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
    
    private void clearBoard(){
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                circles[i][j].setFill(Color.GREY);
                labels[i][j].setText("");
            }
        }
    }
    
    private void newGame(){
        try {
            this.lingoWoord = wl.ReturnWord(null);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LingoViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
        message.setText("");
        turn = 0;
        woorden = new String[maxValue];
        nextWoord.setVisible(false);
        labels[turn][0].setText(String.valueOf(lingoWoord.charAt(0)));
    }
    
    private void changeBoard(){
       for(int i=0;i<labels[turn].length;i++){
            String letter = String.valueOf(woordInput.getText().charAt(i));
 
            woorden[turn] = woordInput.getText();
            labels[turn][i].setText(letter);

//            checkWoord(i);
            
            if(checkWoord(i)){
                labels[turn+1][i].setText(letter);
            }
       }
       
//       if(lingoWoord.equals(woordInput.getText())){
//           try {
//                System.out.println("Clear Board");
//                TimeUnit.SECONDS.sleep(2);
//                clearBoard();
//           } catch (InterruptedException ex) {
//                Logger.getLogger(LingoViewController.class.getName()).log(Level.SEVERE, null, ex);
//           }
//       }
    }

    private boolean checkWoord(int index){
        char woord = woorden[turn].charAt(index);
        // Check if letters are in lingoWoord
        if(lingoWoord.indexOf(woord) != -1){
            // Check if letter is same position
            if(String.valueOf(lingoWoord.charAt(index)).contains(String.valueOf(woord))){
                circles[turn][index].setFill(Color.GREEN);
                if(lingoWoord.equals(woordInput.getText())){
                    message.setText("Gewonnen!!");
                    nextWoord.setVisible(true);
                    return false;
                }
                return true;
            } else {
                circles[turn][index].setFill(Color.YELLOW);
                return false;
            }
        }
        return false;
    }
}
