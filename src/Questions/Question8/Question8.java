package Questions.Question8;

import Questions.Question3.Question3;
import Questions.Question9.Question9;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Question8 implements Initializable {


    String results[];
    int i;

    @FXML
    private Label lblQuestion1;

    @FXML
    private TextField txtField1;

    @FXML
    private Button btnSubmit;




    @FXML
    void submit(ActionEvent event) {

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Question9.class.getResource("Question9.fxml"));
            Parent questionRoot = fxmlLoader.load();

//            Next 2 lines sends the username to the first question in the result array
            String ans = txtField1.getText();
            results[i] = ans;
            i++;

            Question9 question9 = fxmlLoader.getController();
            question9.sendToNext(results, i);

            Stage questionStage = new Stage();
            questionStage.setScene(new Scene(questionRoot));
            questionStage.setTitle("Question 9");
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
}
