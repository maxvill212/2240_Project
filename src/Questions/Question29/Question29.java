package Questions.Question29;

import Classes.Database;
import EndScreen.EndScreen;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Question29 implements Initializable {


    String results[];
    int i;
    Database database = new Database();


    @FXML
    private TextField lblAns;

    @FXML
    private Button btnSubmit;

    @FXML
    private ListView list;


    @FXML
    void submit(ActionEvent event) {

        results[i] =  lblAns.getText();
        database.inputData(results);

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(EndScreen.class.getResource("EndScreen.fxml"));
            Parent endSRoot = fxmlLoader.load();

            Stage endStage = new Stage();
            endStage.setScene(new Scene(endSRoot));
            endStage.setTitle("Thank You");
            endStage.show();

//            Closing the stage
            Stage currStage = (Stage) btnSubmit.getScene().getWindow();
            currStage.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }


    //    This grabs the username and array count from the previous question
    public void sendToNext(String[] results, int i){
        this.results = results;
        this.i = i;
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
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
                "Water for tea/coffee," +
                        "drinking");
    }
}
