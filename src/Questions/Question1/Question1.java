package Questions.Question1;

import Questions.Question2.Question2;
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

public class Question1 implements Initializable {


    String results[];
    int i;
    ObservableList<String> choiceBoxList = FXCollections.observableArrayList("1", "2", "3", "4", "5", "6", "7+");

    @FXML
    private Label lblQuestion1;
    @FXML
    private TextField txtField1;
    @FXML
    private Button btnSubmit;
    @FXML
    private ChoiceBox cBoxQ1;




    @FXML
    void submit(ActionEvent event) {


        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Question2.class.getResource("Question2.fxml"));
            Parent questionRoot = fxmlLoader.load();

//            Next 2 lines sends the username to the first question in the result array
            results[i] =  cBoxQ1.getValue().toString();
            i++;
            Question2 question2 = fxmlLoader.getController();
            question2.sendToNext(results, i);



            Stage questionStage = new Stage();
            questionStage.setScene(new Scene(questionRoot));
            questionStage.setTitle("Question 2");
            questionStage.show();

//            Closing the stage
            Stage currStage = (Stage) btnSubmit.getScene().getWindow();
            currStage.close();


        }catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }


//    This grabs the username and array counter from the Welcome Screen
    public void sendToNext(String[] results, int i){
        this.results = results;
        this.i = i;
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cBoxQ1.setItems(choiceBoxList);
        cBoxQ1.setValue("1");
    }
}
