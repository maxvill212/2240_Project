//<editor-fold desc="About Class"
/*********************************************************************************************************************
 *                                                                                                                   *
 *       ***************ABOUT*************************                                                               *
 *       This is the first window the user sees                                                                      *
 *                                                                                                                   *
 *       It allows the user to login or create a new account                                                         *
 *                                                                                                                   *
 *                                                                                                                   *
 *       **********VARIABLES WelcomeWindow************                                                               *
 *       String                                                                                                      *
 *          result[]      -> Array that stores the user's name and all the answers                                   *
 *          user          -> Stores the input of the user's username (login and createAccount method)                *
 *          name          -> Stores the input of the user's first and last name (createAccount method)               *
 *          password      -> Stores the input of the user's password (login) and 1st password field (createAccount)  *
 *          checkPass     -> Stores the input of the user's confirmation password field (createAccount)              *
 *       Boolean                                                                                                     *
 *          username      -> Checks if the username exists in the database                                           *
 *       Integer                                                                                                     *
 *          i             -> A count that tracks where to place the user's input in the array                        *
 *       Database                                                                                                    *
 *          database      -> The object that allows this page to long onto the database                              *
 *       HashAndCheck                                                                                                *
 *          hashAndCheck  -> The object that allows this page to access the various methods of HashAndCheck          *
 *                                                                                                                   *
 ********************************************************************************************************************/
//</editor-fold>




package WelcomeWindow;

import Classes.Database;
import Classes.HashAndCheck;
import EndScreen.EndScreen;
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

//    Pulls items from the .fxml file
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
    private Button btnPrevResults;


//    Variable declaration
    String user, password, checkPass, name;
    String[] results = new String[30];
    boolean username;
    int i = 0;
    Database database = new Database();
    HashAndCheck hashAndCheck = new HashAndCheck();

//    This method is called when the user submits a new account
    @FXML
    void CreateAccount(ActionEvent event) {

//        Fills user, name, password and checkPass with user's input
        user = txtUser2.getText();
        name = txtName.getText();
        password = txtCreatePass.getText();
        checkPass = txtCreatePass2.getText();

//        Calls the method in HashAndCheck to make sure the name contains first and last
        if (hashAndCheck.checkFullName(name)) {

//            Calls the method in HashAndCheck to make sure the username is of proper format and isn't empty
            if (hashAndCheck.checkUsername(user) && !user.isEmpty()) {

//                Calls the method in HashAndCheck to make sure the password is at leased 6 characters
                if (hashAndCheck.checkLength(password)) {

//                    Makes sure both entered passwords are the same
                    if (password.equals(checkPass)) {

//                        Calls the method in Database to make check if the username is already taken
                        if (database.checkUsername(user)) {
//                            If username already used, then outputs error message and makes label visible
                            lblError2.setText("Username already in use");
                            lblError2.setVisible(true);

//                          if username doesn't exist
                        } else {

//                            Calls the method in HashAndCheck to hash the password
                            password = hashAndCheck.hashPass(password);
//                            Connects to the database and adds user through the Database object
                            database.connect();
                            database.createAcc(user, name, password);

//                            Adds username as the first element of the array and prepares the first answer
//                            to be added to the second position
                            results[i] = user;
                            i++;


                            try {
//                                Creates the Stage, Root and Scene for the first question
                                FXMLLoader fxmlLoader = new FXMLLoader(Question1.class.getResource("Question1.fxml"));
                                Parent question1Root = fxmlLoader.load();
                                Stage questionStage = new Stage();
                                questionStage.setScene(new Scene(question1Root));
                                questionStage.setTitle("Question 1");
                                questionStage.show();

 //                                Loads the first question and sends it the array and index indicator
                                Question1 question1 = fxmlLoader.getController();
                                question1.sendToNext(results, i);

//                                Closes the current stage
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

//    This method is called when the user log-ins in with an existing account
    @FXML
    void login(ActionEvent event){

//        Fills user and password with user's input
        user = txtUsername.getText();
        password = txtPass.getText();

//        If one or both fields are empty
        if(!user.isEmpty() || !password.isEmpty()){

//            Connects to the database and check if the username exists
            database.connect();
            username = database.checkUsername(user);
//            If no username was found
            if(!username) {
                lblError.setText("Username or Password Incorrect");
                lblError.setVisible(true);
//            if username exists
            }else {

//                 Calls the method in Database to check if the password is correct
                if (database.checkPassword(user, password)) {

//                    If The login button is pressed, it brings up the first question
                    if (btnLogin.isPressed()) {

//                        Adds username as the first element of the array and prepares the first answer
//                        to be added to the second position
                        results[i] = user;
                        i++;

                        try {
//                            Creates the Stage, Root and Scene for the first question
                            FXMLLoader fxmlLoader = new FXMLLoader(Question1.class.getResource("Question1.fxml"));
                            Parent question1Root = fxmlLoader.load();
                            Stage questionStage = new Stage();
                            questionStage.setScene(new Scene(question1Root));
                            questionStage.setTitle("Question 1");
                            questionStage.show();

//                            Loads the first question and sends it the array and index indicator
                            Question1 question1 = fxmlLoader.getController();
                            question1.sendToNext(results, i);

//                            Closes the current stage
                            Stage currStage = (Stage) btnLogin.getScene().getWindow();
                            currStage.close();
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
//                    If the check previous results button is pressed, it brings the results page
                    }else{
                        try {
                            FXMLLoader fxmlLoader = new FXMLLoader(EndScreen.class.getResource("EndScreen.fxml"));
                            Parent endSRoot = fxmlLoader.load();

                            Stage endStage = new Stage();
                            endStage.setScene(new Scene(endSRoot));
                            endStage.setTitle("Thank You");
                            endStage.show();

//                            Closing the stage
                            Stage currStage = (Stage) btnPrevResults.getScene().getWindow();
                            currStage.close();
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
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
