package MainProgram;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;




public class Controller {


    @FXML
    private void Test (ActionEvent event) throws Exception{

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("SecondPage.fxml"));
        Parent root2 = (Parent) fxmlLoader.load();
        Stage questions = new Stage();
        questions.setTitle("Welcome");
        questions.setScene(new Scene(root2, 1000, 500));
        questions.show();
    }
}
