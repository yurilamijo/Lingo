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
    public int[] kaartArr = {};
    @FXML
    private void kaartButtonAction(ActionEvent event){
        for(int i =0;i<25;i++){
            int randomNum = ThreadLocalRandom.current().nextInt(1, 70 + 1);
            kaartArr[i]=randomNum;
            System.out.println(kaartArr[i]);
        }
    }
}
