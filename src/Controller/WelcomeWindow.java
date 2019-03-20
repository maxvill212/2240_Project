package Controller;

import Classes.Database;
import Classes.ValidateLogin;
import java.util.EmptyStackException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.Hashtable;

public class WelcomeWindow {

    @FXML
    private Button btnStart;
    @FXML
    private TextField txtUsername;
    @FXML
    private TextField txtPass;
    @FXML
    private Label lblError;

    String user, password;

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
        user = txtUsername.getText();
        password = txtPass.getText();

        try{
            if(!user.isEmpty() && !password.isEmpty()){
                lblError.setVisible(false);
                database.connect(user, password);
            }else{
                throw new NoSuchMethodException();
            }
        }catch (NoSuchMethodException ex){
            lblError.setVisible(true);
        }



//        ValidateLogin validate = new ValidateLogin();

//        Hashtable<String, String> userPass = new Hashtable<>();
    }


}
