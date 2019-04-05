package EndScreen;

import Classes.Calculate;
import Classes.Database;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class EndScreen implements Initializable {

    @FXML
    private Label lblTableAvg;
    @FXML
    private Label lblUserScore;

    int rsSize;
    double numValue[][];
    double avg, userResults;
    String results[][];
    Calculate calculate = new Calculate();
    Database database = new Database();














    //    No data is preloaded onto the scene
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        rsSize = database.getTableLength();
        lblTableAvg.setText(Double.toString(calculate.avgCalc(numValue)));
        lblUserScore.setText(Double.toString(calculate.UsrResult(numValue)));
        calculate.pull();
    }
}


