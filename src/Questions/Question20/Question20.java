package Questions.Question20;

import Questions.Questions28.Question28;
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
    int i, checkResultCounter;
    String checkResultArray;

    ObservableList<String> choiceBoxList = FXCollections.observableArrayList("Energy Lights", "Loft In1-10", "11-30", "31+");

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
            if

            FXMLLoader fxmlLoader = new FXMLLoader(Question28.class.getResource("Question28.fxml"));
            Parent questionRoot = fxmlLoader.load();

//            Next 2 lines sends the username to the first question in the result array

            results[i] =  cBox.getValue().toString();
            i++;

            Question28 question28 = fxmlLoader.getController();
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
        cBox.setItems(choiceBoxList);
        cBox.setValue("Energy Lights");
    }
}
