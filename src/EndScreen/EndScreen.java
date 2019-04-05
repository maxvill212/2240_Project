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
    private Label lblText1;
    @FXML
    private Label lblText2;
    @FXML
    private Button btnSubmit;
    @FXML
    private Button btnPreviousResults;
    @FXML
    private ListView list;


    Calculate calculate = new Calculate();
    Database database = new Database();
    String tableAvg, userResults, username;






    @FXML
    void submit(ActionEvent event){

        btnPreviousResults.setVisible(true);
        lblUserScore.setVisible(true);
        lblTableAvg.setVisible(true);
        lblText1.setVisible(true);
        lblText2.setVisible(true);
    }


    @FXML
    void oldResults (ActionEvent event){

        btnPreviousResults.setVisible(false);
        lblUserScore.setVisible(false);
        lblTableAvg.setVisible(false);
        lblText1.setVisible(false);
        lblText2.setVisible(false);
        calculate.getUserRs(username);


    }


    public void sendToNext(String username){
        this.username = username;
    }






//    No data is preloaded onto the scene
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        tableAvg = Double.toString(calculate.sendToEndTable());
        userResults = Double.toString(calculate.sendToEndUser());

        lblTableAvg.setText(tableAvg);
        lblTableAvg.setVisible(true);
        lblUserScore.setText(userResults);
        lblUserScore.setVisible(true);

        list.getItems().addAll("Toilet Flush:                                     9",
                "Brushing Teeth:                               0.4",
                "Washing Hands:                              0.3",
                "Bath:                                                75",
                "Shower:                                           22 / Minute",
                "Full Kitchen Sink:                             25",
                "Dishwasher:                                     29",
                "Washing Machine:                           75 / load",
                "Cooking:                                           1",
                "Dripping Tap:                                   20 / week",
                "Pet Water Bowls",
                "Water for tea/coffee", "drinking");

    }
}


