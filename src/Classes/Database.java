package Classes;

import WelcomeWindow.WelcomeWindow;
import javafx.scene.control.Label;

import java.sql.*;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;
import java.util.StringJoiner;

public class Database {

    private Connection conn = null;
    String url = "jdbc:sqlite:src/Database/database.db";
    Hash hash = new Hash();


    public Connection connect(){

        try {
            conn = DriverManager.getConnection(url);
//            System.out.println("Connection to DB");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public boolean checkUsername (String user){

        String check = "SELECT username, password FROM Users WHERE username LIKE ?";

        try(Connection conn = this.connect()){
            PreparedStatement pstmt = conn.prepareStatement(check);
            pstmt.setString(1, user);
            ResultSet result = pstmt.executeQuery();

            if(result.next() == false){
                System.out.println("No results");
                return false;
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return true;
    }

    public boolean checkPassword (String user, String pass){
        String check = "SELECT password FROM Users WHERE username LIKE ?";

        try (Connection conn = this.connect()){
            PreparedStatement pstmt = conn.prepareStatement(check);
            pstmt.setString(1, user);
            ResultSet result = pstmt.executeQuery();
            String pswd = result.getString("password");

            if (hash.checkHash(pass, pswd)){
                return true;
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

        System.out.println("Incorrect Password");
        return false;
    }


    public void createAcc (String username, String name, String pass, Label lblError2){
        String insert = "INSERT INTO Users (username, name, password) VALUES(?,?,?)";

        try (Connection conn = this.connect()){
            PreparedStatement pstmt = conn.prepareStatement(insert);
            pstmt.setString(1, username);
            pstmt.setString(2, name);
            pstmt.setString(3, pass);
            pstmt.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
            lblError2.setText("Didn't pass createAcc");
        }
    }


    public void inputData (String[] data){


        String insert = "INSERT INTO Answers (username, question1, question2, question3, question4, question5," +
                " question6, question7, question8, question9, question10) VALUES (?,?,?,?,?,?,?,?,?,?,?)";

        try (Connection conn = this.connect()){
            PreparedStatement pstmt = conn.prepareStatement(insert);
            for (int i = 0; i < 11; i++) {
                pstmt.setString(i+1, data[i]);
            }


            pstmt.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
