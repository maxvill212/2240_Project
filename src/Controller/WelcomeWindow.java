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
import javafx.stage.Stage;

public class WelcomeWindow {

    @FXML
    private Button btnStart;
    @FXML
    private TextField txtUsername;
    @FXML
    private TextField txtPass;
    @FXML
    private Label lblError;
    @FXML
    private Label lblError2;
    @FXML
    private TextField txtUser2;
    @FXML
    private TextField txtCreatePass;
    @FXML
    private TextField txtCreatePass2;


    String user, password, checkPass;
    boolean username;

    Database database = new Database();


    public void start() throws Exception{

       Stage primaryStage = new Stage();

       Parent root = FXMLLoader.load(getClass().getResource("/FXML/WelcomeWindow.fxml"));
       primaryStage.setTitle("Welcome");
       primaryStage.setScene(new Scene(root));
       primaryStage.setResizable(false);
       primaryStage.show();
    }

    public void login(ActionEvent e) throws Exception{
//        user = txtUsername.getText();
//        password = txtPass.getText();

            if(!user.isEmpty() && !password.isEmpty()){
                database.connect();
                username = database.checkUsername(user);
                if(!username){
                    lblError.setText("Username isn't recognized");
                    lblError.setVisible(true);
                }
            }else{
                lblError.setText("Please fill all fields");
                lblError.setVisible(true);
            }


//        Hash validate = new Hash();

//        Hashtable<String, String> userPass = new Hashtable<>();
    }

    public void CreateAccount(ActionEvent e) throws Exception {
        user = txtUser2.getText();
        password = txtCreatePass.getText();
        checkPass = txtCreatePass2.getText();

//        (password == checkPass) &&
        if (!user.isEmpty()) {
//            database.connect();
            database.createAcc(user, password, lblError);
        } else {
            lblError2.setText("Passwords don't match");
        }
    }
//            try{
//                if(!user.isEmpty() && !password.isEmpty()){
////                lblError.setVisible(false);
//                    database.connect(user, password);
///***************CHANGE COLOR FROM GREEN/BLACK tO RED******************/
//                    lblError2.setText("Creation");
//                }else{
//                    throw new NoSuchMethodException();
//                }
//            }catch (NoSuchMethodException ex){
//                lblError2.setVisible(true);
//                lblError2.setText("Enter all of the fields");
//            }



}
