/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lingofx;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

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
    @FXML private Button sendWoord;
    
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
    private void sendWoordAction(ActionEvent event) throws IOException {      
        if (woordInput.getText().matches(".*\\d+.*") || woordInput.getText().length() != 5) {
            if (woordInput.getText().length() != 5) {
                message.setText("Woord moet 5 letters lang zijn");
            } else {
                message.setText("Incorrect value");
            }
        } else {
            if(turn < 4){
                changeBoard();
                checkSameLetter();
                turn++;
                turnsLabel.setText("Trun: " + (turn+1));
            } else {
                changeControls("Verloren!!", true);
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
    
    private void changeControls(String text, boolean active){
        message.setText(text);
        woordInput.setDisable(active);
        sendWoord.setDisable(active);
        nextWoord.setVisible(active);
    }
    
    private void newGame(){
        try {
            this.lingoWoord = wl.ReturnWord(null);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LingoViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
        turn = 0;
        turnsLabel.setText("Trun: " + (turn+1));
        changeControls("", false);
        woorden = new String[maxValue];
        labels[turn][0].setText(String.valueOf(lingoWoord.charAt(0)));
    }
    
    private void changeBoard() throws IOException{
        woorden[turn] = woordInput.getText();
        for(int i=0;i<labels[turn].length;i++){
            String letter = String.valueOf(woordInput.getText().charAt(i));
            Label letterLabel = labels[turn][i];

            letterLabel.setText(letter);

            if(checkWoord(i)){
                labels[turn+1][0].setText(String.valueOf(lingoWoord.charAt(0)));
                labels[turn+1][i].setText(letter);
            }
       }
    }

        
    private boolean checkWoord(int index) throws IOException{
        char woord = woorden[turn].charAt(index);
        // Check if letters are in lingoWoord
        if(lingoWoord.indexOf(woord) != -1){
            // Check if letter is same position
            if(String.valueOf(lingoWoord.charAt(index)).contains(String.valueOf(woord))){
                circles[turn][index].setFill(Color.GREEN);
                if(lingoWoord.equals(woordInput.getText())){
                    changeControls("Gewonnen!!", true);
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

    private void checkSameLetter() throws IOException {
        String[] letterArr = new String[5];
        for(int i = 0; i<5; i++){
            letterArr[i] = String.valueOf(this.woordInput.getText().charAt(i));
        }
        if(letterArr[0].equals(letterArr[1]) && letterArr[0].equals(letterArr[2]) && letterArr[0].equals(letterArr[3]) && letterArr[0].equals(letterArr[4])){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("view/Popup.fxml"));
            Parent popup = loader.load();
            
            Scene scene = new Scene(popup);    
            Stage stage = new Stage();
            stage.setTitle("Valsspeler! " + "'" + this.woordInput.getText() + "'" + " is geen bestaand woord");
            stage.setScene(scene);
            stage.show();
            letterArr = new String[5];
            clearBoard();
        }
    }
    
//    public void ExternalReset(){
//        System.out.println("IN");
//        clearBoard();
//    }
}
