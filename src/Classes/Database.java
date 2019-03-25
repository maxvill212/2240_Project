package Classes;

import Controller.WelcomeWindow;
import javafx.scene.control.Label;

import java.sql.*;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;

public class Database {

    private Connection conn = null;
//    private Statement stm = null;
    String url = "jdbc:sqlite:src/Database/database.db";


    public Connection connect(){

        try {
            conn = DriverManager.getConnection(url);
            System.out.println("Connection");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public boolean checkUsername (String user){
        String check = "SELECT username, password FROM Users WHERE username LIKE ?";

//        https://stackoverflow.com/questions/27582757/catch-duplicate-entry-exception
//        SQLIntegrityConstraintViolationException


        try(Connection conn = this.connect()){
            PreparedStatement pstmt = conn.prepareStatement(check);
            pstmt.setString(1, user);
            ResultSet result = pstmt.executeQuery();

            if(result.next() == false){
                System.out.println("No results");
                return false;
            }else{
                do {
                    String data = result.getString("username");
                    String pass = result.getString("password");
                    System.out.println(data + "\t" + pass);
                }while(result.next());
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return true;
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
}
