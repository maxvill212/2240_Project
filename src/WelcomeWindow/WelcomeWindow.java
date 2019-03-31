package WelcomeWindow;

import Classes.Database;
import Question.Question;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXML;
import javafx.stage.Stage;

import java.util.concurrent.TimeUnit;

public class WelcomeWindow {

    @FXML
    private BorderPane welcomeWindow;

    @FXML
    private TextField txtUsername;

    @FXML
    private TextField txtPass;

    @FXML
    private Button btnLogin;

    @FXML
    private Label lblError;

    @FXML
    private TextField txtUser2;

    @FXML
    private TextField txtName;

    @FXML
    private TextField txtCreatePass;

    @FXML
    private TextField txtCreatePass2;

    @FXML
    private Label lblError2;

    @FXML
    private Button CreateAccount;

    @FXML
    private Label lblName;

    String user, password, checkPass, name;
    boolean username;

    Database database = new Database();



    @FXML
    void CreateAccount(ActionEvent event) {

        user = txtUser2.getText();
        name = txtName.getText();
        password = txtCreatePass.getText();
        checkPass = txtCreatePass2.getText();


        if (password.equals(checkPass) && !user.isEmpty()) {
            database.connect();
            database.createAcc(user, name, password, lblError);
        } else {
            lblError2.setText("Passwords don't match");
        }
    }


    @FXML
    void login(ActionEvent event) throws Exception {

        user = txtUsername.getText();
        password = txtPass.getText();

//        PULL FROM DATABASE
//        name = txtName.getText();

        if(!user.isEmpty() && !password.isEmpty()){
            database.connect();
            username = database.checkUsername(user);
            if(!username) {
                lblError.setText("Username isn't recognized");
                lblError.setVisible(true);
            }else{
                lblError.setText("Welcome");
                lblError.setStyle("-fx-text-fill: green;");
                lblError.setVisible(true);
                TimeUnit.SECONDS.sleep(1);

                try {

                    FXMLLoader fxmlLoader = new FXMLLoader(Question.class.getResource("Question.fxml"));
                    Parent questionRoot = fxmlLoader.load();
                    Stage questionStage = new Stage();
                    questionStage.setScene(new Scene(questionRoot));
                    questionStage.show();

                }catch (Exception e) {
                    System.out.println("This Sucks BAAAAAALZZZZZ");
                }
            }
        }else{
            lblError.setText("Please fill all fields");
            lblError.setVisible(true);
        }



    }
}
