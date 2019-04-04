//<editor-fold desc="About Class"
/*********************************************************************************************************************
 *                                                                                                                   *
 *       ***************ABOUT**********************                                                                  *
 *       This is question 18                                                                                         *
 *                                                                                                                   *
 *       User answers and passed to the next question                                                                *
 *       The result is saved in the result array and passed to the next question                                     *
 *                                                                                                                   *
 *       **********VARIABLES Question 18************                                                                 *
 *       String                                                                                                      *
 *          result[]             -> Array that stores the user's name and all the answers                            *
 *       Integer                                                                                                     *
 *          i                    -> A count that tracks where to place the user's input in the array                 *
 *       ObservableList<String>                                                                                      *
 *          choiceBoxList        -> The object that allows The list of options to be displayed on the screen         *
 *                                                                                                                   *
 ********************************************************************************************************************/
//</editor-fold>





package Questions.Question18;

import Questions.Question19.Question19;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Question18 implements Initializable {


    String results[];
    int i;
    ObservableList<String> choiceBoxList = FXCollections.observableArrayList("Yes", "No");


    @FXML
    private Button btnSubmit;
    @FXML
    private ChoiceBox cBox;


    @FXML
    void submit(ActionEvent event) {

        try {
            results[i] =  cBox.getValue().toString();
            i++;

            FXMLLoader fxmlLoader = new FXMLLoader(Question19.class.getResource("Question19.fxml"));
            Parent questionRoot = fxmlLoader.load();
            Stage questionStage = new Stage();
            questionStage.setScene(new Scene(questionRoot));
            questionStage.setTitle("Question 19");
            questionStage.show();

            Question19 question19 = fxmlLoader.getController();
            question19.sendToNext(results, i);

            Stage currStage = (Stage) btnSubmit.getScene().getWindow();
            currStage.close();

        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void sendToNext(String[] results, int i){
        this.results = results;
        this.i = i;
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cBox.setItems(choiceBoxList);
        cBox.setValue("Yes");
    }
}
