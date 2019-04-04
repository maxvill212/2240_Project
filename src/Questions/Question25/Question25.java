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


    String results[];
    int i, checkResultInt = 0;
    String checkResultArray;

    @FXML
    private Label lblQuestion1;

    @FXML
    private TextField txtField1;

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





    @FXML
    void submit(ActionEvent event) {

        try {
//            Call the checkbox counter method to see how many are checked
            checkResultArray = checkBoxes(checkFood, checkPaper, checkGlass, checkCans, checkPlastic, checkElec);

            FXMLLoader fxmlLoader = new FXMLLoader(Question26.class.getResource("Question26.fxml"));
            Parent questionRoot = fxmlLoader.load();

//            Next 2 lines sends the username to the first question in the result array

            results[i] =  checkResultArray;
            i++;

            Question26 question26 = fxmlLoader.getController();
            question26.sendToNext(results, i);

            Stage questionStage = new Stage();
            questionStage.setScene(new Scene(questionRoot));
            questionStage.setTitle("Question 26");
            questionStage.show();

//            Closing the stage
            Stage currStage = (Stage) btnSubmit.getScene().getWindow();
            currStage.close();


        }catch (Exception e) {
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
    }

    //    Method to see how many checkboxes are checked
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
