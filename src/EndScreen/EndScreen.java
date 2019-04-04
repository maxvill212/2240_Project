package EndScreen;

import Classes.Calculate;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class EndScreen implements Initializable {

    @FXML
    private Label lblAvg;
    @FXML
    private Label getLblAvg;

    Calculate calculate = new Calculate();














    //    No data is preloaded onto the scene
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lblAvg.setText("Test");
        calculate.pull();
    }
}


