package Questions.Questions28;

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
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Question28 implements Initializable {


    String results[];
    int i;
    ObservableList<String> choiceBoxList = FXCollections.observableArrayList("Test");
    Database database = new Database();

    @FXML
    private Label lblQuestion1;

    @FXML
    private TextField txtField1;

    @FXML
    private Button btnSubmit;

    @FXML
    private ChoiceBox cBox;




    @FXML
    void submit(ActionEvent event) {

        results[i] =  cBox.getValue().toString();
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
        cBox.setItems(choiceBoxList);
        cBox.setValue("Test");
    }
}
