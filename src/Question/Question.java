package Question;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class Question{
//    implements Initializable {

//    ObservableList<String> cBoxInhabitantsList = FXCollections.observableArrayList("1", "2", "3", "4", "5", "6", "More than 6");

    String user= "not me";
//    private Connection conn = null;

    @FXML
    private Label lblQuestion1;

    @FXML
    private TextField txtQuestion1;

    @FXML
    private Button btnSubmit;

//    @FXML
//    private ChoiceBox cBoxInhabitants;



    @FXML
    void submit(ActionEvent event) {
//        String insert = "INSERT INTO Users (username, name, password) VALUES(?,?,?)";
//
//        try (Connection conn = this.connect()){
//            PreparedStatement pstmt = conn.prepareStatement(insert);
//            pstmt.setString(1, username);
//            pstmt.setString(2, name);
//            pstmt.setString(3, pass);
//            pstmt.executeUpdate();
//        }catch (SQLException e){
//            System.out.println(e.getMessage());
//        }
    }


//    This grabs the username from the Welcome Screen
    public void setUser(String userName){
        user = userName;
    }


//    @Override
//    public void initialize(URL location, ResourceBundle resources) {
//        cBoxInhabitants.setItems(cBoxInhabitantsList);
//        cBoxInhabitants.setValue("");
//    }
}
