package Classes;

import java.sql.*;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.DriverManager;

public class Database {

    private Connection conn = null;
    private Statement stm = null;

    public void connect(String user, String pass){
        try{
            if(!user.isEmpty() && !pass.isEmpty()) {
                String url = "jdbc:sqlite:src/Database/SQLite_database.db";
                conn = DriverManager.getConnection(url);
                System.out.println("Connection to database successful");
            }else{

            }
        } catch (SQLException e){
            System.out.println(e.getMessage());
        } finally {
            try{
                if (conn != null){
                    conn.close();
                }
            }catch (SQLException ex){
                System.out.println(ex.getMessage());
            }
        }
    }
//    String sql = "CREATE TABLE IF NOT EXIST `user`";
}
