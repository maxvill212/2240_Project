//<editor-fold desc="About Class"
/*********************************************************************************************************************
 *                                                                                                                   *
 *       ***************ABOUT**********************                                                                  *
 *       This is the class that shows user their result, as well as the population's average                         *
 *                                                                                                                   *
 *       User answers and passed to the next question                                                                *
 *       The result is saved in the result array and passed to the next question                                     *
 *                                                                                                                   *
 *       **********VARIABLES Calculate*************                                                                  *
 *       Calculate                                                                                                   *
 *          calculate      -> Gives access to the calculation class to the database                                  *
 *       String                                                                                                      *
 *          tableAvg       -> Converts and stores population's average, is used to show in the label                 *
 *          userResult     -> Converts and stores user's score, is used to show in the label                         *
 *                                                                                                                   *
 ********************************************************************************************************************/
//</editor-fold>




package EndScreen;

import Classes.Calculate;
import Classes.Database;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

import javax.xml.crypto.Data;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ResourceBundle;
import java.util.logging.Level;

public class EndScreen implements Initializable {

    @FXML
    private Label lblTableAvg;
    @FXML
    private Label lblUserScore;
    @FXML
    private Button btnExit;


//Variable Declaration
    Calculate calculate = new Calculate();
    String tableAvg, userResults;






//Closes the program when the exit button is pressed
    @FXML
    void exit(ActionEvent event){

        Stage currStage = (Stage) btnExit.getScene().getWindow();
        currStage.close();
    }



//    Displays the user's results and population average
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        tableAvg = Double.toString(calculate.sendToEndTable());
        userResults = Double.toString(calculate.sendToEndUser());

        lblTableAvg.setText(tableAvg);
        lblUserScore.setText(userResults);

    }
}


