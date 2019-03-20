package Classes;

import Controller.WelcomeWindow;

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

    public void createAcc (String user, String pass){
        String insert = "INSERT INTO Users (UserID, Password) VALUES(?,?)";

        try (Connection conn = this.connect()){
            PreparedStatement pstmt = conn.prepareStatement(insert);
            pstmt.setString(1, user);
            pstmt.setString(2, pass);
            pstmt.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
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
