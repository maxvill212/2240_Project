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
import java.text.DecimalFormat;
import java.util.ResourceBundle;

public class EndScreen implements Initializable {

    @FXML
    private Label lblTableAvg;
    @FXML
    private Label lblUserScore;
    @FXML
    private Button btnSubmit;

    Calculate calculate = new Calculate();
    String tableAvg, userResults;


    @FXML
    void submit(ActionEvent event){

        tableAvg = Double.toString(calculate.sendToEndTable());

        userResults = Double.toString(calculate.sendToEndUser());

        lblTableAvg.setText(tableAvg);
        lblUserScore.setText(userResults);

    }









    //    No data is preloaded onto the scene
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
}


