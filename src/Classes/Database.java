//<editor-fold desc="About Class"
/*********************************************************************************************************************
 *                                                                                                                   *
 *       ***************ABOUT**********************                                                                  *
 *       This is the class that interacts with the database                                                          *
 *                                                                                                                   *
 *       It does the following:                                                                                      *
 *       Connects to he database                                                                                     *
 *       Checks if the username exists in the database (login)                                                       *
 *       Checks if the password is correct (login)                                                                   *
 *       Creates an account by inputting the new credentials in the database (createAccount)                         *
 *       Inputs the results in the database                                                                          *
 *                                                                                                                   *
 *       It uses prepared statements to prevent SQL injection attacks                                                *
 *                                                                                                                   *
 *       **********VARIABLES Database**************                                                                  *
 *       Connection                                                                                                  *
 *          conn              -> Creates the connection to the database, made private                                *
 *       String                                                                                                      *
 *          url               -> Stores the link to the database, as well as the library used and database language  *
 *          insert            -> Stores the SQLite statement                                                         *
 *          pswd              -> Stores the hashed password pulled from the database                                 *
 *       HashAndCheck                                                                                                *
 *          hashAndCheck      -> The object that allows this page to access the various methods of HashAndCheck      *
 *       PreparedStatement                                                                                           *
 *          pstmt             -> Object that takes 'insert' to be used as a prepared statement                       *
 *                                                                                                                   *
 ********************************************************************************************************************/
//</editor-fold>




package Classes;

import javafx.scene.control.Label;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class Database {

//    Variable declaration
    private Connection conn = null;
    String insert, pswd, url = "jdbc:sqlite:src/Database/database.db";
    HashAndCheck hashAndCheck = new HashAndCheck();
    ResultSet result;
    PreparedStatement pstmt;


    public Connection connect(){

//        Connects to the database using the url
        try {
            conn = DriverManager.getConnection(url);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

//    Check if the username exists in the database (login)
    public boolean checkUsername (String user){

//        SQL query
        insert = "SELECT username, password FROM Users WHERE username LIKE ?";

//        Calls the connection method
//        Creates the final prepared statement
//        Replaces the '?' in the statement with the proper input
//        Retrieves the results and store them in 'results'
        try(Connection conn = this.connect()){
            pstmt = conn.prepareStatement(insert);
            pstmt.setString(1, user);
            ResultSet result = pstmt.executeQuery();

//            No username were found
            if(result.next() == false){
                return false;
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return true;
    }

//    Checks if the password matches the one with the account
    public boolean checkPassword (String user, String pass){

//        SQL query
        insert = "SELECT password FROM Users WHERE username LIKE ?";

//        Calls the connection method
//        Creates the final prepared statement
//        Replaces the '?' in the statement with the proper input
//        Retrieves the results and store them in 'results'
//        Stores the pulled password in 'pswd'
        try (Connection conn = this.connect()){
            pstmt = conn.prepareStatement(insert);
            pstmt.setString(1, user);
            ResultSet result = pstmt.executeQuery();
            String pswd = result.getString("password");

//            Calls the HashAndCheck object to see if the hashed password matches the input password
            if (hashAndCheck.checkHash(pass, pswd)){
                return true;
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return false;
    }

//    Creates a new account
    public void createAcc (String username, String name, String pass){

//        SQL query
        insert = "INSERT INTO Users (username, name, password) VALUES(?,?,?)";

//        Calls the connection method
//        Creates the final prepared statement
//        Replaces the '?' in the statement with the proper inputs
//        Executes query
        try (Connection conn = this.connect()){
            PreparedStatement pstmt = conn.prepareStatement(insert);
            pstmt.setString(1, username);
            pstmt.setString(2, name);
            pstmt.setString(3, pass);
            pstmt.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

//    Inserts the results of the questinnaire
    public void inputData (String[] data){

//    SQL query
        insert = "INSERT INTO Answers VALUES (null,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

//        Calls the connection method
//        Creates the final prepare statement
//        For loop to replaces the '?' in the statement with the proper inputs
//        Execute query
        try (Connection conn = this.connect()){
            PreparedStatement pstmt = conn.prepareStatement(insert);
            for (int i = 0; i < data.length; i++) {
                pstmt.setString(i+1, data[i]);
            }
            pstmt.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
