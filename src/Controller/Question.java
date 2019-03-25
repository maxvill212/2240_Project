package Controller;

import Classes.Database;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;


public class Question {

    @FXML
    private TextField txtQuestion1;
    @FXML
    private Button btnSubmit;


//    public void start() {
//
//       Parent root;
//        try {
//            root = FXMLLoader.load(getClass().getClassLoader().getResource("FXML/Question.fxml"));
//            Stage stage = new Stage();
//            stage.setTitle("Question");
//            stage.setScene(new Scene(root));
//            stage.show();
//        }
//        catch (IOException ex) {
//            ex.printStackTrace();
//        }
//    }


    public void start() throws Exception{

        Stage question = new Stage();

        Parent root = FXMLLoader.load(getClass().getResource("/FXML/Question.fxml"));
        question.setTitle("Welcome");
        question.setScene(new Scene(root));
        question.setResizable(false);
        question.show();
    }








}

