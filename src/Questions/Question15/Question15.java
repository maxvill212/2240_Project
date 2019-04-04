//<editor-fold desc="About Class"
/*********************************************************************************************************************
 *                                                                                                                   *
 *       ***************ABOUT**********************                                                                  *
 *       This is question 15                                                                                         *
 *                                                                                                                   *
 *       User answers and passed to the next question                                                                *
 *       The result is saved in the result array and passed to the next question                                     *
 *                                                                                                                   *
 *       **********VARIABLES Question 15************                                                                 *
 *       String                                                                                                      *
 *          result[]             -> Array that stores the user's name and all the answers                            *
 *       Integer                                                                                                     *
 *          i                    -> A count that tracks where to place the user's input in the array                 *
 *       ObservableList<String>                                                                                      *
 *          choiceBoxList        -> The object that allows The list of options to be displayed on the screen         *
 *                                                                                                                   *
 ********************************************************************************************************************/
//</editor-fold>





package Questions.Question15;

import Questions.Question16.Question16;
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

public class Question15 implements Initializable {


    String results[];
    int i;
    ObservableList<String> choiceBoxList = FXCollections.observableArrayList("0", "2", "3", "4", "5+");

    @FXML
    private Button btnSubmit;
    @FXML
    private ChoiceBox cBox;



    @FXML
    void submit(ActionEvent event) {

        try {
            results[i] =  cBox.getValue().toString();
            i++;

            FXMLLoader fxmlLoader = new FXMLLoader(Question16.class.getResource("Question16.fxml"));
            Parent questionRoot = fxmlLoader.load();
            Stage questionStage = new Stage();
            questionStage.setScene(new Scene(questionRoot));
            questionStage.setTitle("Question 16");
            questionStage.show();

            Question16 question16 = fxmlLoader.getController();
            question16.sendToNext(results, i);

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
        cBox.setValue("0");
    }
}
