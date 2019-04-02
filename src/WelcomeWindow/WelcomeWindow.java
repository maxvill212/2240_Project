package WelcomeWindow;

import Classes.Database;
//import Classes.UserSession;
import Questions.Question1.Question1;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXML;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

public class WelcomeWindow implements Initializable {

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
    int i = 0;
    String[] results = new String[40];
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

            try {

                FXMLLoader fxmlLoader = new FXMLLoader(Question1.class.getResource("Questions.fxml"));
                Parent questionRoot = fxmlLoader.load();
                Stage questionStage = new Stage();
                questionStage.setScene(new Scene(questionRoot));
                questionStage.show();


            }catch (Exception e) {
                System.out.println("Didn't want to open Questions");
            }

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
//                UserSession.getInstance(user);
                lblError.setText("Welcome");
                lblError.setStyle("-fx-text-fill: green;");
                lblError.setVisible(true);
                TimeUnit.SECONDS.sleep(1);

                try {
                    FXMLLoader fxmlLoader = new FXMLLoader(Question1.class.getResource("Question1.fxml"));
                    Parent question1Root = fxmlLoader.load();

//                    Next 2 lines sends the username to the first question1 in the result array
                    results[i] = user;
                    i++;
                    Question1 question1 = fxmlLoader.getController();
                    question1.sendToNext(results, i);

                    Stage questionStage = new Stage();
                    questionStage.setScene(new Scene(question1Root));
                    questionStage.setTitle("Question 1");
                    questionStage.show();

//                    Closing the stage
                    Stage currStage = (Stage) btnLogin.getScene().getWindow();
                    currStage.close();


                }catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        }else{
            lblError.setText("Please fill all fields");
            lblError.setVisible(true);
        }



    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
