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


//    Method that converts all answers to integer values
    public double[][] numValue(String[][] results){
        for (int i = 0; i < rsSize; i++) {

            if (results[i][1] == "1"){
                numValue[i][1] = 1;
            }else if (results[i][1] == "2"){
                numValue[i][1] = 2;
            }else if (results[i][1] == "3"){
                numValue[i][1] = 3;
            }else if (results[i][1] == "4"){
                numValue[i][1] = 4;
            }else if (results[i][1] == "5"){
                numValue[i][1] = 5;
            }else if (results[i][1] == "6"){
                numValue[i][1] = 6;
            }else if (results[i][1] == "7+"){
                numValue[i][1] = 7;
            }

            if (results[i][2] == "Apartment"){
                numValue[i][2] = 1;
            }else if (results[i][2] == "Semi Detached"){
                numValue[i][2] = 2;
            }else if (results[i][2] == "Town House"){
                numValue[i][2] = 3;
            }else if (results[i][2] == "Standalone"){
                numValue[i][2] = 4;
            }

            if (results[i][3] == "Bus"){
                numValue[i][3] = 1;
            }else if (results[i][3] == "Gas/Diesel Car"){
                numValue[i][3] = 2;
            }else if (results[i][3] == "Bike"){
                numValue[i][3] = 3;
            }else if (results[i][3] == "Walk"){
                numValue[i][3] = 4;
            }else if (results[i][3] == "Moped"){
                numValue[i][3] = 5;
            }else if (results[i][3] == "Electric Car/Hybrid"){
                numValue[i][3] = 6;
            }

            if (results[i][4] == "0-2"){
                numValue[i][4] = 1;
            }else if (results[i][4] == "3-5"){
                numValue[i][4] = 2;
            }else if (results[i][4] == "6-10"){
                numValue[i][4] = 3;
            }else if (results[i][4] == "11+"){
                numValue[i][4] = 4;
            }

            if (results[i][5] == "Never"){
                numValue[i][5] = 1;
            }else if (results[i][5] == "1-2"){
                numValue[i][5] = 2;
            }else if (results[i][5] == "3-5"){
                numValue[i][5] = 3;
            }else if (results[i][5] == "6-7"){
                numValue[i][5] = 4;
            }

            if (results[i][6] == "Vegan"){
                numValue[i][6] = 1;
            }else if (results[i][6] == "Vegetarian"){
                numValue[i][6] = 2;
            }else if (results[i][6] == "No Meat"){
                numValue[i][6] = 3;
            }else if (results[i][6] == "Rarely Use Meat"){
                numValue[i][6] = 4;
            }else if (results[i][6] == "Meat in Some Meals"){
                numValue[i][6] = 5;
            }else if (results[i][6] == "Meat in Every Meal"){
                numValue[i][6] = 6;
            }

            if (results[i][7] == "0"){
                numValue[i][7] = 1;
            }else if (results[i][7] == "1-10"){
                numValue[i][7] = 2;
            }else if (results[i][7] == "11-20"){
                numValue[i][7] = 3;
            }else if (results[i][7] == "21-50"){
                numValue[i][7] = 4;
            }else if (results[i][7] == "51+"){
                numValue[i][7] = 5;
            }

            if (results[i][8] == "0"){
                numValue[i][8] = 1;
            }else if (results[i][8] == "1-10"){
                numValue[i][8] = 2;
            }else if (results[i][8] == "11-30"){
                numValue[i][8] = 3;
            }else if (results[i][8] == "31+"){
                numValue[i][8] = 4;
            }

            if (results[i][9] == "Hardly/At All"){
                numValue[i][9] = 1;
            }else if (results[i][9] == "Sometimes"){
                numValue[i][9] = 2;
            }else if (results[i][9] == "Very Often"){
                numValue[i][9] = 3;
            }

            if (results[i][10] == "Electric"){
                numValue[i][10] = 1;
            }else if (results[i][10] == "Plug-In Hybrid"){
                numValue[i][10] = 2;
            }else if (results[i][10] == "Engine Charging Hybrid"){
                numValue[i][10] = 3;
            }else if (results[i][10] == "Small Diesel/Petrol"){
                numValue[i][10] = 4;
            }else if (results[i][10] == "Medium Diesel/Petrol"){
                numValue[i][10] = 5;
            }else if (results[i][10] == "Large Diesel/Petrol"){
                numValue[i][10] = 6;
            }

            if (results[i][11] == "0"){
                numValue[i][11] = 1;
            }else if (results[i][11] == "1-5"){
                numValue[i][11] = 2;
            }else if (results[i][11] == "6-10"){
                numValue[i][11] = 3;
            }else if (results[i][11] == "11-15"){
                numValue[i][11] = 4;
            }else if (results[i][11] == "16-20"){
                numValue[i][11] = 5;
            }else if (results[i][11] == "21-24"){
                numValue[i][11] = 6;
            }

            if (results[i][12] == "0"){
                numValue[i][12] = 1;
            }else if (results[i][12] == "1-5"){
                numValue[i][12] = 2;
            }else if (results[i][12] == "6-10"){
                numValue[i][12] = 3;
            }else if (results[i][12] == "11-15"){
                numValue[i][12] = 4;
            }else if (results[i][12] == "16-20"){
                numValue[i][12] = 5;
            }else if (results[i][12] == "21-24"){
                numValue[i][12] = 6;
            }

            if (results[i][13] == "0"){
                numValue[i][13] = 1;
            }else if (results[i][13] == "1-2"){
                numValue[i][13] = 2;
            }else if (results[i][13] == "3-5"){
                numValue[i][13] = 3;
            }else if (results[i][13] == "6-10"){
                numValue[i][13] = 4;
            }else if (results[i][13] == "11+"){
                numValue[i][13] = 5;
            }

            if (results[i][14] == "1"){
                numValue[i][14] = 1;
            }else if (results[i][14] == "2"){
                numValue[i][14] = 2;
            }else if (results[i][14] == "3"){
                numValue[i][14] = 3;
            }else if (results[i][14] == "4"){
                numValue[i][14] = 4;
            }else if (results[i][14] == "5+"){
                numValue[i][14] = 5;
            }

            if (results[i][15] == "Wood"){
                numValue[i][15] = 1;
            }else if (results[i][15] == "Electricity"){
                numValue[i][15] = 2;
            }else if (results[i][15] == "Natural Gas"){
                numValue[i][15] = 3;
            }else if (results[i][15] == "Oil"){
                numValue[i][15] = 4;
            }

            if (results[i][16] == "Don't Know"){
                numValue[i][16] = 2;
            }else if (results[i][16] == "No"){
                numValue[i][16] = 1;
            }else if (results[i][16] == "Yes but not 100% Renewable"){
                numValue[i][16] = 3;
            }else if (results[i][16] == "Yes"){
                numValue[i][16] = 4;
            }

            if (results[i][17] == "No"){
                numValue[i][17] = 1;
            }else if (results[i][17] == "Yes"){
                numValue[i][17] = 2;
            }

            if (results[i][20] == "Bellow 14"){
                numValue[i][20] = 1;
            }else if (results[i][20] == "14-17"){
                numValue[i][20] = 1;
            }else if (results[i][20] == "18-21"){
                numValue[i][20] = 3;
            }else if (results[i][20] == "Over 21"){
                numValue[i][20] = 4;
            }

            if (results[i][21] == "0"){
                numValue[i][21] = 1;
            }else if (results[i][21] == "1"){
                numValue[i][21] = 2;
            }else if (results[i][21] == "2"){
                numValue[i][21] = 3;
            }else if (results[i][21] == "3"){
                numValue[i][21] = 4;
            }else if (results[i][21] == "4"){
                numValue[i][21] = 5;
            }else if (results[i][21] == "5"){
                numValue[i][21] = 6;
            }else if (results[i][21] == "6"){
                numValue[i][21] = 7;
            }else if (results[i][21] == "7"){
                numValue[i][21] = 8;
            }else if (results[i][21] == "8"){
                numValue[i][21] = 9;
            }

            if (results[i][22] == "0-20"){
                numValue[i][22] = 1;
            }else if (results[i][22] == "21-50"){
                numValue[i][22] = 2;
            }else if (results[i][22] == "51-90"){
                numValue[i][22] = 3;
            }else if (results[i][22] == "91-150"){
                numValue[i][22] = 4;
            }else if (results[i][22] == "151-200"){
                numValue[i][22] = 5;
            }else if (results[i][22] == "201+"){
                numValue[i][22] = 6;
            }

            if (results[i][23] == "0-50"){
                numValue[i][23] = 1;
            }else if (results[i][23] == "51-100"){
                numValue[i][23] = 2;
            }else if (results[i][23] == "101-150"){
                numValue[i][23] = 3;
            }else if (results[i][23] == "151-250"){
                numValue[i][23] = 4;
            }else if (results[i][23] == "251-300"){
                numValue[i][23] = 5;
            }else if (results[i][23] == "301+"){
                numValue[i][23] = 6;
            }

            if (results[i][24] == "0-20"){
                numValue[i][24] = 1;
            }else if (results[i][24] == "21-40"){
                numValue[i][24] = 2;
            }else if (results[i][24] == "41-70"){
                numValue[i][24] = 3;
            }else if (results[i][24] == "71-100"){
                numValue[i][24] = 4;
            }else if (results[i][24] == "100+"){
                numValue[i][24] = 5;
            }

            if (results[i][25] == "0-50"){
                numValue[i][25] = 1;
            }else if (results[i][25] == "51-100"){
                numValue[i][25] = 2;
            }else if (results[i][25] == "101-150"){
                numValue[i][25] = 3;
            }else if (results[i][25] == "151-200"){
                numValue[i][25] = 4;
            }else if (results[i][25] == "201-250"){
                numValue[i][25] = 5;
            }else if (results[i][25] == "251-300"){
                numValue[i][25] = 6;
            }else if (results[i][25] == "301+"){
                numValue[i][25] = 7;
            }

            if (results[i][26] == "0"){
                numValue[i][26] = 1;
            }else if (results[i][26] == "1"){
                numValue[i][26] = 2;
            }else if (results[i][26] == "2"){
                numValue[i][26] = 3;
            }else if (results[i][26] == "3"){
                numValue[i][26] = 4;
            }else if (results[i][26] == "4"){
                numValue[i][26] = 5;
            }else if (results[i][26] == "5"){
                numValue[i][26] = 6;
            }else if (results[i][26] == "6"){
                numValue[i][26] = 7;
            }

            if (results[i][27] == "0"){
                numValue[i][27] = 1;
            }else if (results[i][27] == "1"){
                numValue[i][27] = 2;
            }else if (results[i][27] == "2"){
                numValue[i][27] = 3;
            }else if (results[i][27] == "3"){
                numValue[i][27] = 4;
            }else if (results[i][27] == "4+"){
                numValue[i][27] = 5;
            }

            if (results[i][28] == "0-2"){
                numValue[i][28] = 1;
            }else if (results[i][28] == "3"){
                numValue[i][28] = 2;
            }else if (results[i][28] == "4"){
                numValue[i][28] = 3;
            }else if (results[i][28] == "5"){
                numValue[i][28] = 4;
            }else if (results[i][28] == "6"){
                numValue[i][28] = 5;
            }else if (results[i][28] == "7"){
                numValue[i][28] = 6;
            }

            if (results[i][29] == "No"){
                numValue[i][29] = 1;
            }else if (results[i][29] == "Yes") {
                numValue[i][29] = 2;
            }

            int waterPerWeek = Integer.parseInt(results[i][29]);
            if (waterPerWeek <= 500){
                numValue[i][29] = 0;
            }else if (waterPerWeek > 500 && waterPerWeek <= 1000){
                numValue[i][29] = 1;
            }else if (waterPerWeek > 1000 && waterPerWeek <= 1500){
                numValue[i][29] = 2;
            }else if (waterPerWeek > 1500 && waterPerWeek <= 2000){
                numValue[i][29] = 3;
            }else if (waterPerWeek > 2500 && waterPerWeek <= 3000){
                numValue[i][29] = 4;
            }else if (waterPerWeek > 3000 && waterPerWeek <= 3500){
                numValue[i][29] = 5;
            }else if (waterPerWeek > 3500 && waterPerWeek <= 4000){
                numValue[i][29] = 6;
            }else if (waterPerWeek > 4000){
                numValue[i][29] = 7;
            }

        }
        return numValue;
    }
}
