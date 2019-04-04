//<editor-fold desc="About Class"
/*********************************************************************************************************************
 *                                                                                                                   *
 *       ***************ABOUT**********************                                                                  *
 *       This is question 14                                                                                         *
 *                                                                                                                   *
 *       User answers and passed to the next question                                                                *
 *       The result is saved in the result array and passed to the next question                                     *
 *                                                                                                                   *
 *       **********VARIABLES Question 14************                                                                 *
 *       String                                                                                                      *
 *          result[]             -> Array that stores the user's name and all the answers                            *
 *       Integer                                                                                                     *
 *          i                    -> A count that tracks where to place the user's input in the array                 *
 *       ObservableList<String>                                                                                      *
 *          choiceBoxList        -> The object that allows The list of options to be displayed on the screen         *
 *                                                                                                                   *
 ********************************************************************************************************************/
//</editor-fold>




package Questions.Question14;

import Questions.Question15.Question15;
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

public class Question14 implements Initializable {

//    Variable Declaration, also states what options the user will be able to choose from
    String results[];
    int i;
    ObservableList<String> choiceBoxList = FXCollections.observableArrayList("0", "1-2", "3-5", "6-10", "11+");

//    Pulls items from the .fxml file
    @FXML
    private Button btnSubmit;

    @FXML
    private ChoiceBox cBox;

//    When the user clicks submit
    @FXML
    void submit(ActionEvent event) {

//        Adds the answer of this question to array and prepares the next answer
//        to be added to the next position position
        results[i] =  cBox.getValue().toString();
        i++;

        try {
//            Creates the next question's Stage, Root and Scene
            FXMLLoader fxmlLoader = new FXMLLoader(Question15.class.getResource("Question15.fxml"));
            Parent questionRoot = fxmlLoader.load();
            Stage questionStage = new Stage();
            questionStage.setScene(new Scene(questionRoot));
            questionStage.setTitle("Question 15");
            questionStage.show();

//            Sends the answer and array index to the next question
            Question15 question15 = fxmlLoader.getController();
            question15.sendToNext(results, i);

//            Closing the current stage
            Stage currStage = (Stage) btnSubmit.getScene().getWindow();
            currStage.close();


        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


//    Receives the answer and array counter from the previous question
    public void sendToNext(String[] results, int i){
        this.results = results;
        this.i = i;
    }

//    Populates the choice Box with the options the user has and sets default value
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cBox.setItems(choiceBoxList);
        cBox.setValue("0");
    }
}
