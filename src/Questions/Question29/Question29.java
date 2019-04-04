//<editor-fold desc="About Class"
/*********************************************************************************************************************
 *                                                                                                                   *
 *       ***************ABOUT**********************                                                                  *
 *       This is question 29                                                                                         *
 *                                                                                                                   *
 *       User answers and passed to the next question                                                                *
 *       The result is saved in the result array and passed to the next question                                     *
 *                                                                                                                   *
 *       **********VARIABLES Question 29************                                                                 *
 *       String                                                                                                      *
 *          result[]             -> Array that stores the user's name and all the answers                            *
 *       Integer                                                                                                     *
 *          i                    -> A count that tracks where to place the user's input in the array                 *
 *       Database                                                                                                    *
 *          database      -> The object that allows this page to send the results to the database                    *
 *                                                                                                                   *
 ********************************************************************************************************************/
//</editor-fold>




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

//        Gets the answer and stores it in the last position of the array
        results[i] =  lblAns.getText();
        database.inputData(results);

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(EndScreen.class.getResource("EndScreen.fxml"));
            Parent endSRoot = fxmlLoader.load();

            Stage endStage = new Stage();
            endStage.setScene(new Scene(endSRoot));
            endStage.setTitle("Thank You");
            endStage.show();

            Stage currStage = (Stage) btnSubmit.getScene().getWindow();
            currStage.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void sendToNext(String[] results, int i){
        this.results = results;
        this.i = i;
    }

//    Populates the list view with the examples of daily water usage and the amount in liters
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
                "Water for tea/coffee", "drinking");
    }
}
