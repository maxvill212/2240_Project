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
 *       Pulls all the answers from the database                                                                     *
 *       Founds out the current length of the table                                                                  *
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
 *          rsArray           -> The multidimensional array that stores all results from the database                *
 *       HashAndCheck                                                                                                *
 *          hashAndCheck      -> The object that allows this page to access the various methods of HashAndCheck      *
 *       PreparedStatement                                                                                           *
 *          pstmt             -> Object that takes 'insert' to be used as a prepared statement                       *
 *       Integer                                                                                                     *
 *          i                 -> Changes the column for the pullAll method                                           *
 *          rsSize            -> Stores the length of the table in the pullAll method                                *
 *                                                                                                                   *
 ********************************************************************************************************************/
//</editor-fold>




package Classes;

import javafx.scene.control.Label;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;

public class Database {

//    Variable declaration
    private Connection conn = null;
    String insert, pswd, url = "jdbc:sqlite:src/Database/database.db";
    String[][] rsArray;
    HashAndCheck hashAndCheck = new HashAndCheck();
    ResultSet result;
    PreparedStatement pstmt;
    int i = 0, rsSize = 0;



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
            result = pstmt.executeQuery();

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
            result = pstmt.executeQuery();
            pswd = result.getString("password");

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
            pstmt = conn.prepareStatement(insert);
            pstmt.setString(1, username);
            pstmt.setString(2, name);
            pstmt.setString(3, pass);
            pstmt.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

//    Inserts the results of the questionnaire
    public void inputData (String[] data){

//        SQL query
        insert = "INSERT INTO Answers VALUES (null,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

//        Calls the connection method
//        Creates the final prepare statement
//        For loop to replaces the '?' in the statement with the proper inputs
//        Execute query
        try (Connection conn = this.connect()){
            pstmt = conn.prepareStatement(insert);
            for (int i = 0; i < data.length; i++) {
                pstmt.setString(i+1, data[i]);
            }
            pstmt.executeUpdate();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

//    Method to pull all results from the database
    public String[][] pullAll(){

//        Uses getTableLength to set the array column size
        rsSize = getTableLength();
        rsArray = new String[rsSize][29];

//        SQL query
        insert = "SELECT question1, question2, question3, question4, question5, question6, question7, question8," +
                "question9, question10, question11, question12, question13, question14, question15, question16," +
                "question17, question18, question19, question20, question21, question22, question23, question24," +
                "question25, question26, question27, question28, question29 FROM Answers";

//        Connection to the database and execution of the query
        try(Connection conn = this.connect()){
            pstmt = conn.prepareStatement(insert);
            result = pstmt.executeQuery();

//            Populates the array
            while (result.next()) {
                    for (int j = 1; j < 30; j++) {
                        rsArray[i][j-1] = result.getString(j);
                    }i++;
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return rsArray;
    }

//    Method to get the table column length
    public int getTableLength(){

        ResultSet countResult;
        try (Connection conn = this.connect()) {
            insert = "SELECT COUNT (entryID) FROM Answers";
            pstmt = conn.prepareStatement(insert);
            countResult = pstmt.executeQuery();
            rsSize = countResult.getInt(1);
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return rsSize;
    }
}
