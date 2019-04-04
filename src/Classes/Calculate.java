//<editor-fold desc="About Class"
/*********************************************************************************************************************
 *                                                                                                                   *
 *       ***************ABOUT**********************                                                                  *
 *       This is the class that does all the calculations for the carbon footprint                                   *
 *                                                                                                                   *
 *       User answers and passed to the next question                                                                *
 *       The result is saved in the result array and passed to the next question                                     *
 *                                                                                                                   *
 *       **********VARIABLES Calculate*************                                                                  *
 *       String                                                                                                      *
 *          result         -> Stores the result from the query sent to the database                                  *
 *       Database                                                                                                    *
 *          database       -> The object that allows this page to interact with the database                         *
 *       Integer                                                                                                     *
 *          rsSize         -> Stores the length of the table in the pullAll method in Database                       *
 *          avg            -> Stores the average score of others in the database                                     *
 *                                                                                                                   *
 ********************************************************************************************************************/
//</editor-fold>




package Classes;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Calculate {

    int rsSize, avg;
    String results[][];
    Database database = new Database();
    double numValue[][];



//    Pulls the data from database
    public String[][] pull(){

        rsSize = database.getTableLength();
        results = new String[rsSize][29];
        numValue = new double[rsSize][29];
        results = database.pullAll();
        numValue(results);
        return results;
    }


//    public int average(){
//
//        result = pull();
//        numValue(result);
//
//
//        return avg;
//    }


    public double[][] numValue(String [][] results){
        for (int i = 0; i < rsSize; i++) {

            if (results[i][2] == "1"){
                numValue[i][2] = 1;
            }else if (results[i][2] == "2"){
                numValue[i][2] = 2;
            }else if (results[i][2] == "3"){
                numValue[i][2] = 3;
            }else if (results[i][2] == "4"){
                numValue[i][2] = 4;
            }else if (results[i][2] == "5"){
                numValue[i][2] = 5;
            }else if (results[i][2] == "6"){
                numValue[i][2] = 6;
            }else if (results[i][2] == "7+"){
                numValue[i][2] = 7;
            }


            if (results[i][3] == "Apartment"){
                numValue[i][3] = 1;
            }else if (results[i][3] == "Semi Detached"){
                numValue[i][3] = 2;
            }else if (results[i][3] == "Town House"){
                numValue[i][3] = 3;
            }else if (results[i][3] == "Standalone"){
                numValue[i][3] = 4;
            }


            if (results[i][4] == "Bus"){
                numValue[i][4] = 1;
            }else if (results[i][4] == "Gas/Diesel Car"){
                numValue[i][4] = 2;
            }else if (results[i][4] == "Bike"){
                numValue[i][4] = 3;
            }else if (results[i][4] == "Walk"){
                numValue[i][4] = 4;
            }else if (results[i][4] == "Moped"){
                numValue[i][4] = 5;
            }else if (results[i][4] == "Electric Car/Hybrid"){
                numValue[i][4] = 6;
            }


            if (results[i][5] == "0-2"){
                numValue[i][5] = 1;
            }else if (results[i][5] == "3-5"){
                numValue[i][5] = 2;
            }else if (results[i][5] == "6-10"){
                numValue[i][5] = 3;
            }else if (results[i][5] == "11+"){
                numValue[i][5] = 4;
            }









            switch (results[i][2]){
                case "1":
                    numValue[i][2] = 1;
                    break;
                case "2":
                    numValue[i][2] = 2;
                    break;
                case "3":
                    numValue[i][2] = 3;
                    break;
                case "4":
                    numValue[i][2] = 4;
                    break;
                case "5":
                    numValue[i][2] = 5;
                    break;
                case "6":
                    numValue[i][2] = 6;
                    break;
                case "7+":
                    numValue[i][2] = 7;
                    break;
            }
        }

        for (int i = 0; i < rsSize ; i++) {
            switch (results[i][3]){

            }
        }

        return numValue;
    }












}
