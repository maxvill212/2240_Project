package Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class WelcomeWindow {

    @FXML
    private Button btnStart;


    public void start() throws Exception{

       Stage primaryStage = new Stage();

       Parent root = FXMLLoader.load(getClass().getResource("/FXML/WelcomeWindow.fxml"));
       primaryStage.setTitle("Welcome");
       primaryStage.setScene(new Scene(root));
       primaryStage.setResizable(false);
       primaryStage.show();
    }




}
