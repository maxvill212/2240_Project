//<editor-fold desc="About Class"
/*********************************************************************************************************************
 *                                                                                                                   *
 *       ***************ABOUT**********************                                                                  *
 *       This is question 25                                                                                         *
 *                                                                                                                   *
 *       User answers and passed to the next question                                                                *
 *       The result is saved in the result array and passed to the next question                                     *
 *                                                                                                                   *
 *       **********VARIABLES Question 25************                                                                 *
 *       String                                                                                                      *
 *          result[]             -> Array that stores the user's name and all the answers                            *
 *          checkResultArray     -> This stores the amount of check boxes the user ticks                             *
 *       Integer                                                                                                     *
 *          i                    -> A count that tracks where to place the user's input in the array                 *
 *          checkResultInt       -> Counter to store how many check boxes are ticked                                 *
 *       ObservableList<String>                                                                                      *
 *          choiceBoxList        -> The object that allows The list of options to be displayed on the screen         *
 *                                                                                                                   *
 ********************************************************************************************************************/
//</editor-fold>




package Questions.Question25;

import Questions.Question26.Question26;
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

public class Question25 implements Initializable {

//    Variable Declaration
    String results[];
    int i, checkResultInt = 0;
    String checkResultArray;

//    Pulls items from the .fxml file
    @FXML
    private Button btnSubmit;
    @FXML
    private CheckBox checkFood;
    @FXML
    private CheckBox checkPaper;
    @FXML
    private CheckBox checkGlass;
    @FXML
    private CheckBox checkCans;
    @FXML
    private CheckBox checkPlastic;
    @FXML
    private CheckBox checkElec;




//    When the user clicks submit
    @FXML
    void submit(ActionEvent event) {

        try {
//            Call the checkbox counter method to see how many are checked
            checkResultArray = checkBoxes(checkFood, checkPaper, checkGlass, checkCans, checkPlastic, checkElec);

//            Adds the answer of this question to array and prepares the next answer
//            to be added to the next position position
            results[i] =  checkResultArray;
            i++;

//            Creates the next question's Stage, Root and Scene
            FXMLLoader fxmlLoader = new FXMLLoader(Question26.class.getResource("Question26.fxml"));
            Parent questionRoot = fxmlLoader.load();
            Stage questionStage = new Stage();
            questionStage.setScene(new Scene(questionRoot));
            questionStage.setTitle("Question 26");
            questionStage.show();

//            Sends the answer and array index to the next question
            Question26 question26 = fxmlLoader.getController();
            question26.sendToNext(results, i);

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

//    No data is preloaded onto the scene
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

//    Method to see how many checkboxes are checked
//    If checked, adds one to the counter
    private String checkBoxes (CheckBox checkFood, CheckBox checkPaper, CheckBox checkGlass, CheckBox checkCans,
                               CheckBox checkPlastic, CheckBox checkElec){

        if (checkFood.isSelected())
            checkResultInt++;
        if (checkPaper.isSelected())
            checkResultInt++;
        if (checkGlass.isSelected())
            checkResultInt++;
        if (checkCans.isSelected())
            checkResultInt++;
        if (checkPlastic.isSelected())
            checkResultInt++;
        if (checkElec.isSelected())
            checkResultInt++;

//        Convert that result into a String to be put in the array
        checkResultArray = Integer.toString(checkResultInt);
        return checkResultArray;
    }
}
