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

    @FXML
    private void kaartButtonAction(ActionEvent event) {
        GenerateKaart1();
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
}
