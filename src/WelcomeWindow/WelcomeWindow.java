//<editor-fold desc="About Class"
/*************************************************************************************************************
 *                                                                                                           *
 *       ***************ABOUT*************************                                                       *
 *       This is the first window the user sees                                                              *
 *                                                                                                           *
 *       It allows the user to login or create a new account                                                 *
 *                                                                                                           *
 *                                                                                                           *
 *       **********VARIABLES WelcomeWindow************                                                       *
 *       String                                                                                              *
 *          result[]      -> Array that stores the user's name and all the answers                           *
 *       Boolean                                                                                             *
 *          username      -> Checks if the username exists in the database                                   *
 *       Integer                                                                                             *
 *          i             -> A count that tracks where to place the user's input in the array                *
 *       Database                                                                                            *
 *          database      -> The object that allows this page to long onto the database                      *
 *       HashAndCheck                                                                                        *
 *          hashAndCheck  -> The object that allows this page to access the various methods of HashAndCheck  *
 *                                                                                                           *
 ************************************************************************************************************/
//</editor-fold>




package WelcomeWindow;

import Classes.Database;
import Classes.HashAndCheck;
import Questions.Question1.Question1;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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

public class WelcomeWindow implements Initializable {

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
    String[] results = new String[30];
    Database database = new Database();
    HashAndCheck hashAndCheck = new HashAndCheck();

//    The method that is called when the user submits a new account
    @FXML
    void CreateAccount(ActionEvent event) {

        user = txtUser2.getText();
        name = txtName.getText();
        password = txtCreatePass.getText();
        checkPass = txtCreatePass2.getText();
        if (hashAndCheck.checkFullName(name)) {
            if (hashAndCheck.checkUsername(user)) {
                if (hashAndCheck.checkLength(password)) {
                    if (password.equals(checkPass) && !user.isEmpty()) {
                        if (database.checkUsername(user)) {
                            lblError2.setText("Username already in use");
                            lblError2.setVisible(true);
                        } else {
                            password = hashAndCheck.hashPass(password);
                            database.connect();
                            database.createAcc(user, name, password, lblError);

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


                            } catch (Exception e) {
                                System.out.println(e.getMessage());
                            }
                        }

                    } else {
                        lblError2.setText("Passwords don't match");
                        lblError2.setVisible(true);
                    }
                } else {
                    lblError2.setText("Password must be at leased 6 characters");
                    lblError2.setVisible(true);
                }
            }else{
                lblError2.setText("Invalid username");
                lblError2.setVisible(true);
            }
        }else{
            lblError2.setText("Invalid name (for a '-' use '_'");
            lblError2.setVisible(true);
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
            }else {

                if (database.checkPassword(user, password)) {

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


                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }else{
                    lblError.setText("Username or Password Incorrect");
                    lblError.setVisible(true);
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
