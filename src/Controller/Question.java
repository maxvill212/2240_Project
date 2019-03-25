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

//    private static BorderPane layout;
//    private static Stage stage;
//    private static Scene scene;


    public void start() throws Exception{

        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("FXML/Question.fxml"));
        loader.setController(this);
        BorderPane scene = loader.load();
        Stage stage = new Stage();
        stage.setTitle("Question");
        stage.setScene(new Scene(scene));
        stage.show();



    }

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


//    public void start() throws Exception{
//
//        Stage question = new Stage();
//
//        Parent root = FXMLLoader.load(getClass().getResource("/FXML/Question.fxml"));
//        question.setTitle("Welcome");
//        question.setScene(new Scene(root));
//        question.setResizable(false);
//        question.show();
//    }








}

