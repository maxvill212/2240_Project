package Questions.Question20;

import Questions.Question27.Question27;
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

public class Question20 implements Initializable {


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
    private CheckBox checkLights;

    @FXML
    private CheckBox checkCavity;

    @FXML
    private CheckBox checkInsulation;

    @FXML
    private CheckBox checkGlazing;

    @FXML
    private CheckBox checkBoiler;

    @FXML
    private CheckBox checkLowFlow;

    @FXML
    private CheckBox checkSolarPanels;

    @FXML
    private CheckBox checkWater;





    @FXML
    void submit(ActionEvent event) {

        try {
//            Call the checkbox counter method to see how many are checked
            checkResultArray = checkBoxes(checkLights, checkCavity, checkInsulation, checkGlazing, checkBoiler, checkLowFlow, checkSolarPanels, checkWater);

            FXMLLoader fxmlLoader = new FXMLLoader(Question27.class.getResource("Question27.fxml"));
            Parent questionRoot = fxmlLoader.load();

//            Next 2 lines sends the username to the first question in the result array
            results[i] =  checkResultArray;
            i++;

            Question27 question28 = fxmlLoader.getController();
            question28.sendToNext(results, i);

            Stage questionStage = new Stage();
            questionStage.setScene(new Scene(questionRoot));
            questionStage.setTitle("Question 10");
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
    private String checkBoxes (CheckBox checkLights, CheckBox checkCavity, CheckBox checkInsulation,
                               CheckBox checkGlazing, CheckBox checkBoiler, CheckBox checkLowFlow,
                               CheckBox checkSolarPanels, CheckBox checkWater){

        if (checkLights.isSelected())
            checkResultInt++;
        if (checkCavity.isSelected())
            checkResultInt++;
        if (checkInsulation.isSelected())
            checkResultInt++;
        if (checkGlazing.isSelected())
            checkResultInt++;
        if (checkBoiler.isSelected())
            checkResultInt++;
        if (checkLowFlow.isSelected())
            checkResultInt++;
        if (checkSolarPanels.isSelected())
            checkResultInt++;
        if (checkWater.isSelected())
            checkResultInt++;

//        Convert that result into a String to be put in the array
        checkResultArray = Integer.toString(checkResultInt);
        return checkResultArray;
    }
}
