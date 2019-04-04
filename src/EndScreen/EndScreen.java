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
    private Label avg;

    Calculate calculate = new Calculate();

    @FXML
    public void start(Stage welcomeStage) throws Exception{

        calculate.pull();


    }











    //    No data is preloaded onto the scene
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}


