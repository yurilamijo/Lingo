/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lingofx;

import java.util.concurrent.ThreadLocalRandom;
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
 * @author niels_000
 */
public class BingoKaartController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public int[] kaart1 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
    public char[] woordArr = new char[5];

    public String woord;

    @FXML
    private Label kaartNum1;
    @FXML
    private Label kaartNum2;
    @FXML
    private Label kaartNum3;
    @FXML
    private Label kaartNum4;
    @FXML
    private Label kaartNum5;
    @FXML
    private Label kaartNum6;
    @FXML
    private Label kaartNum7;
    @FXML
    private Label kaartNum8;
    @FXML
    private Label kaartNum9;
    @FXML
    private Label kaartNum10;
    @FXML
    private Label kaartNum11;
    @FXML
    private Label kaartNum12;
    @FXML
    private Label kaartNum13;
    @FXML
    private Label kaartNum14;
    @FXML
    private Label kaartNum15;
    @FXML
    private Label kaartNum16;
    @FXML
    private Label kaartNum17;
    @FXML
    private Label kaartNum18;
    @FXML
    private Label kaartNum19;
    @FXML
    private Label kaartNum20;
    @FXML
    private Label kaartNum21;
    @FXML
    private Label kaartNum22;
    @FXML
    private Label kaartNum23;
    @FXML
    private Label kaartNum24;
    @FXML
    private Label kaartNum25;
    @FXML
    private Label wordText;
    @FXML
    private Label charNum;
    @FXML
    private Label wordFromArr;
    @FXML
    private TextField wordInput;

    @FXML
    private void kaartButtonAction(ActionEvent event) {
        GenerateKaart1();
        PutNumInLabel(kaart1);
    }

    @FXML
    private void ActionCheckWord(ActionEvent event) {
        if (wordInput.getText().matches(".*\\d+.*") || wordInput.getText().length() != 5) {
            System.out.println("numbers");
            if (wordInput.getText().length() != 5) {
                wordText.setText("Woord moet 5 letters lang zijn");
            } else {
                wordText.setText("Incorrect value");
            }
        } else {
            wordText.setText(wordInput.getText());
            woord = wordInput.getText();
            charNum.setText(String.valueOf(wordInput.getText().length()));
        }
        if (woord != null) {
            for (int i = 0; i < 5; i++) {
                char letter = woord.charAt(i);
                woordArr[i] = letter;
            }
            wordFromArr.setText(String.valueOf(woordArr));
        }
    }

    public void GenerateKaart1() {
        for (int i = 0; i < 25; i++) {
            Boolean same = false;
            int randomNum = ThreadLocalRandom.current().nextInt(1, 70 + 1);
            for (int j = 0; j < 25; j++) {
                if (randomNum == kaart1[j]) {
                    same = true;
                }
            }
            if (same) {
                Boolean check = true;
                Boolean check2;
                while (check) {
                    check2 = true;
                    int randomNum2 = ThreadLocalRandom.current().nextInt(1, 70 + 1);
                    for (int j = 0; j < 25; j++) {
                        if (randomNum2 == kaart1[j]) {
                            check2 = false;
                        }
                    }
                    if (check2) {
                        kaart1[i] = randomNum2;
                        check = false;
                    }
                }

            } else {
                kaart1[i] = randomNum;
            }
        }
    }

    public void PutNumInLabel(int[] arr) {
        kaartNum1.setText(Integer.toString(arr[0]));
        kaartNum2.setText(Integer.toString(arr[1]));
        kaartNum3.setText(Integer.toString(arr[2]));
        kaartNum4.setText(Integer.toString(arr[3]));
        kaartNum5.setText(Integer.toString(arr[4]));
        kaartNum6.setText(Integer.toString(arr[5]));
        kaartNum7.setText(Integer.toString(arr[6]));
        kaartNum8.setText(Integer.toString(arr[7]));
        kaartNum9.setText(Integer.toString(arr[8]));
        kaartNum10.setText(Integer.toString(arr[9]));
        kaartNum11.setText(Integer.toString(arr[10]));
        kaartNum12.setText(Integer.toString(arr[11]));
        kaartNum13.setText(Integer.toString(arr[12]));
        kaartNum14.setText(Integer.toString(arr[13]));
        kaartNum15.setText(Integer.toString(arr[14]));
        kaartNum16.setText(Integer.toString(arr[15]));
        kaartNum17.setText(Integer.toString(arr[16]));
        kaartNum18.setText(Integer.toString(arr[17]));
        kaartNum19.setText(Integer.toString(arr[18]));
        kaartNum20.setText(Integer.toString(arr[19]));
        kaartNum21.setText(Integer.toString(arr[20]));
        kaartNum22.setText(Integer.toString(arr[21]));
        kaartNum23.setText(Integer.toString(arr[22]));
        kaartNum24.setText(Integer.toString(arr[23]));
        kaartNum25.setText(Integer.toString(arr[24]));
    }
}
