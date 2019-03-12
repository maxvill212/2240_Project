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
        BorderPane window = FXMLLoader.load(getClass().getResource("../FXML/WelcomeWindow"));

        Stage stage = new Stage();

        stage.setTitle("Welcome");
        stage.setScene(new Scene(window));
        stage.setResizable(false);

        stage.show();
    }




}
