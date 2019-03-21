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
    String url = "jdbc:sqlite:src/Database/SQLite_database.db";


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
        String check = "SELECT UserID, Password FROM Users WHERE UserID LIKE ?";

        try(Connection conn = this.connect()){
            PreparedStatement pstmt = conn.prepareStatement(check);
            pstmt.setString(1, user);
            ResultSet result = pstmt.executeQuery();

            if(result.next() == false){
                System.out.println("No results");
                return false;
            }else{
                do {
                    String data = result.getString("UserID");
                    String pass = result.getString("Password");
                    System.out.println(data + "\t" + pass);
                }while(result.next());
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return true;
    }


    public void createAcc (String user, String pass, Label lblError2){
        String insert = "INSERT INTO Users (UserID, Password) VALUES(?,?)";

        try (Connection conn = this.connect()){
            PreparedStatement pstmt = conn.prepareStatement(insert);
            pstmt.setString(1, user);
            pstmt.setString(2, pass);
            pstmt.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
            lblError2.setText("Didn't pass createAcc");
        }

    }

//    public void



//        try{
//            if(!user.isEmpty() && !pass.isEmpty()) {
//                String url = "jdbc:sqlite:src/Database/SQLite_database.db";
//                conn = DriverManager.getConnection(url);
//                System.out.println("Connection to database successful");
//            }else{
//
//            }
//        } catch (SQLException e){
//            System.out.println(e.getMessage());
//        } finally {
//            try{
//                if (conn != null){
//                    conn.close();
//                }
//            }catch (SQLException ex){
//                System.out.println(ex.getMessage());
//            }
//        }
    }
