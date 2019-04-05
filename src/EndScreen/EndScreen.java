package EndScreen;

import Classes.Calculate;
import Classes.Database;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class EndScreen implements Initializable {

    @FXML
    private Label lblTableAvg;
    @FXML
    private Label lblUserScore;
    @FXML
    private Button btnSubmit;

    Calculate calculate = new Calculate();
    double tableAvg;
    double userResults;

    @FXML
    void submit(ActionEvent event){

        tableAvg = calculate.sendToEndTable();
        userResults = calculate.sendToEndUser();

        lblTableAvg.setText(Double.toString(tableAvg));
        lblUserScore.setText(Double.toString(userResults));

//        lblTableAvg.setText(Double.toString(tableAvg));
//        lblUserScore.setText(Double.toString(userResults));
    }









    //    No data is preloaded onto the scene
    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        Calculate calculate = new Calculate();
//        double tableAvg = calculate.sendToEndTable();
//        double userResults = calculate.sendToEndUser();
//        lblTableAvg.setText(Double.toString(tableAvg));
//        lblUserScore.setText(Double.toString(userResults));
    }
}


