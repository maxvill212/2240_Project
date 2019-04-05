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


import java.text.DecimalFormat;

import static java.lang.StrictMath.round;

public class Calculate {

    int rsSize;
    double numValue[][];
    int tableAvg, userResults;
    String results[][];
    Database database = new Database();
    private static DecimalFormat df2 = new DecimalFormat(".##");



    public void setUp(){
        rsSize = database.getTableLength();
        results = new String[rsSize][29];
        results = database.pullAll();
        numValue = new double[rsSize][29];
        numValue = convertToInt(results);
    }

    public int sendToEndUser(){
        userResults = UsrResult(numValue);
        return userResults;
    }

    public int sendToEndTable(){
        setUp();
        tableAvg = tableAverage(numValue);
        return tableAvg;
    }


//    Calculates the user's final result
    public int UsrResult(double[][] numValue){

            numValue[rsSize-1][1] *= 6;
            userResults += numValue[rsSize-1][1];

            numValue[rsSize-1][2] *= 6;
            userResults += numValue[rsSize-1][2];

            numValue[rsSize-1][3] *= 5;
            userResults += numValue[rsSize-1][3];

            numValue[rsSize-1][4] *= 6;
            userResults += numValue[rsSize-1][4];

            numValue[rsSize-1][5] *= 3;
            userResults -= numValue[rsSize-1][5];

            numValue[rsSize-1][6] *= 6;
            userResults += numValue[rsSize-1][6];

            numValue[rsSize-1][7] *= 5;
            userResults += numValue[rsSize-1][7];

            numValue[rsSize-1][8] *= 8;
            userResults += numValue[rsSize-1][8];

            numValue[rsSize-1][9] *= 6;
            userResults -= numValue[rsSize-1][9];

            numValue[rsSize-1][10] *= 5;
            userResults += numValue[rsSize-1][10];

            numValue[rsSize-1][11] *= 4;
            userResults -= numValue[rsSize-1][11];

            numValue[rsSize-1][12] *= 3;
            userResults -= numValue[rsSize-1][12];

            numValue[rsSize-1][13] *= 4;
            userResults += numValue[rsSize-1][13];

            numValue[rsSize-1][14] *= 2;
            userResults += numValue[rsSize-1][14];

            numValue[rsSize-1][15] *= 4;
            userResults += numValue[rsSize-1][15];

            numValue[rsSize-1][16] *= 5;
            userResults -= numValue[rsSize-1][16];

            numValue[rsSize-1][17] *= 6;
            userResults -= numValue[rsSize-1][17];

            numValue[rsSize-1][18] *= 4;
            userResults += numValue[rsSize-1][18];

            numValue[rsSize-1][19] *= 7;
            userResults -= numValue[rsSize-1][19];

            numValue[rsSize-1][20] *= 4;
            userResults += numValue[rsSize-1][20];

            numValue[rsSize-1][21] *= 2;
            userResults += numValue[rsSize-1][21];

            numValue[rsSize-1][22] *= 6;
            userResults += numValue[rsSize-1][22];

            numValue[rsSize-1][23] *= 6;
            userResults += numValue[rsSize-1][23];

            numValue[rsSize-1][24] *= 9;
            userResults -= numValue[rsSize-1][24];

            numValue[rsSize-1][25] *= 7;
            userResults += numValue[rsSize-1][25];

            numValue[rsSize-1][26] *= 7;
            userResults += numValue[rsSize-1][26];

            numValue[rsSize-1][27] *= 8;
            userResults += numValue[rsSize-1][27];

            numValue[rsSize-1][28] *= 9;
            userResults += numValue[rsSize-1][28];

//        Averages the user's result for a final score
            userResults = (userResults/rsSize)*10;

        return userResults;
    }

//    Calculates the table average
    public int tableAverage(double[][] numValue){

//        Adds all columns together, finds the average and stores it in at the last row
        for (int i = 1; i < 29; i++) {
            for (int j = 1; j < rsSize; j++) {
                numValue[j][i] += numValue[j-1][i];
            }numValue[rsSize-1][i] /= rsSize;
        }
        numValue[rsSize-1][1] *= 6;
        tableAvg += numValue[rsSize-1][1];

        numValue[rsSize-1][2] *= 6;
        tableAvg += numValue[rsSize-1][2];

        numValue[rsSize-1][3] *= 5;
        tableAvg += numValue[rsSize-1][3];

        numValue[rsSize-1][4] *= 6;
        tableAvg += numValue[rsSize-1][4];

        numValue[rsSize-1][5] *= 3;
        tableAvg -= numValue[rsSize-1][5];

        numValue[rsSize-1][6] *= 6;
        tableAvg += numValue[rsSize-1][6];

        numValue[rsSize-1][7] *= 5;
        tableAvg += numValue[rsSize-1][7];

        numValue[rsSize-1][8] *= 8;
        tableAvg += numValue[rsSize-1][8];

        numValue[rsSize-1][9] *= 6;
        tableAvg -= numValue[rsSize-1][9];

        numValue[rsSize-1][10] *= 5;
        tableAvg += numValue[rsSize-1][10];

        numValue[rsSize-1][11] *= 4;
        tableAvg -= numValue[rsSize-1][11];

        numValue[rsSize-1][12] *= 3;
        tableAvg -= numValue[rsSize-1][12];

        numValue[rsSize-1][13] *= 4;
        tableAvg += numValue[rsSize-1][13];

        numValue[rsSize-1][14] *= 2;
        tableAvg += numValue[rsSize-1][14];

        numValue[rsSize-1][15] *= 4;
        tableAvg += numValue[rsSize-1][15];

        numValue[rsSize-1][16] *= 5;
        tableAvg -= numValue[rsSize-1][16];

        numValue[rsSize-1][17] *= 6;
        tableAvg -= numValue[rsSize-1][17];

        numValue[rsSize-1][18] *= 4;
        tableAvg += numValue[rsSize-1][18];

        numValue[rsSize-1][19] *= 7;
        tableAvg -= numValue[rsSize-1][19];

        numValue[rsSize-1][20] *= 4;
        tableAvg += numValue[rsSize-1][20];

        numValue[rsSize-1][21] *= 2;
        tableAvg += numValue[rsSize-1][21];

        numValue[rsSize-1][22] *= 6;
        tableAvg += numValue[rsSize-1][22];

        numValue[rsSize-1][23] *= 6;
        tableAvg += numValue[rsSize-1][23];

        numValue[rsSize-1][24] *= 9;
        tableAvg -= numValue[rsSize-1][24];

        numValue[rsSize-1][25] *= 7;
        tableAvg += numValue[rsSize-1][25];

        numValue[rsSize-1][26] *= 7;
        tableAvg += numValue[rsSize-1][26];

        numValue[rsSize-1][27] *= 8;
        tableAvg += numValue[rsSize-1][27];

        numValue[rsSize-1][28] *= 9;
        tableAvg += numValue[rsSize-1][28];

//        Averages the entire table for a final score
        tableAvg = (tableAvg/rsSize)*100;

        return tableAvg;
    }
    


//    Method that converts all answers to integer values
    public double[][] convertToInt(String[][] results){
        for (int i = 0; i < rsSize; i++) {
            

            if (results[i][1].equals("1")){
                numValue[i][1] = 1;
            }else if (results[i][1].equals("2")){
                numValue[i][1] = 2;
            }else if (results[i][1].equals("3")){
                numValue[i][1] = 3;
            }else if (results[i][1].equals("4")){
                numValue[i][1] = 4;
            }else if (results[i][1].equals("5")){
                numValue[i][1] = 5;
            }else if (results[i][1].equals("6")){
                numValue[i][1] = 6;
            }else if (results[i][1].equals("7+")){
                numValue[i][1] = 7;
            }else{
                numValue[i][1] = 4;
            }

            if (results[i][2].equals("Apartment")){
                numValue[i][2] = 1;
            }else if (results[i][2].equals("Semi Detached")){
                numValue[i][2] = 2;
            }else if (results[i][2].equals("Town House")){
                numValue[i][2] = 3;
            }else if (results[i][2].equals("Standalone")){
                numValue[i][2] = 4;
            }else{
                numValue[i][2] = 2;
            }

            if (results[i][3].equals("Bus")){
                numValue[i][3] = 1;
            }else if (results[i][3].equals("Gas/Diesel Car")){
                numValue[i][3] = 2;
            }else if (results[i][3].equals("Bike")){
                numValue[i][3] = 3;
            }else if (results[i][3].equals("Walk")){
                numValue[i][3] = 4;
            }else if (results[i][3].equals("Moped")){
                numValue[i][3] = 5;
            }else if (results[i][3].equals("Electric Car/Hybrid")){
                numValue[i][3] = 6;
            }else{
                numValue[i][3] = 3;
            }

            if (results[i][4].equals("0-2")){
                numValue[i][4] = 1;
            }else if (results[i][4].equals("3-5")){
                numValue[i][4] = 2;
            }else if (results[i][4].equals("6-10")){
                numValue[i][4] = 3;
            }else if (results[i][4].equals("11+")){
                numValue[i][4] = 4;
            }else{
                numValue[i][4] = 3;
            }

            if (results[i][5].equals("Never")){
                numValue[i][5] = 1;
            }else if (results[i][5].equals("1-2")){
                numValue[i][5] = 2;
            }else if (results[i][5].equals("3-5")){
                numValue[i][5] = 3;
            }else if (results[i][5].equals("6-7")){
                numValue[i][5] = 4;
            }else{
                numValue[i][5] = 2;
            }

            if (results[i][6].equals("Vegan")){
                numValue[i][6] = 1;
            }else if (results[i][6].equals("Vegetarian")){
                numValue[i][6] = 2;
            }else if (results[i][6].equals("No Meat")){
                numValue[i][6] = 3;
            }else if (results[i][6].equals("Rarely Use Meat")){
                numValue[i][6] = 4;
            }else if (results[i][6].equals("Meat in Some Meals")){
                numValue[i][6] = 5;
            }else if (results[i][6].equals("Meat in Every Meal")){
                numValue[i][6] = 6;
            }else{
                numValue[i][6] = 4;
            }

            if (results[i][7].equals("0")){
                numValue[i][7] = 1;
            }else if (results[i][7].equals("1-10")){
                numValue[i][7] = 2;
            }else if (results[i][7].equals("11-20")){
                numValue[i][7] = 3;
            }else if (results[i][7].equals("21-50")){
                numValue[i][7] = 4;
            }else if (results[i][7].equals("51+")){
                numValue[i][7] = 5;
            }else{
                numValue[i][7] = 3;
            }

            if (results[i][8].equals("0")){
                numValue[i][8] = 1;
            }else if (results[i][8].equals("1-10")){
                numValue[i][8] = 2;
            }else if (results[i][8].equals("11-30")){
                numValue[i][8] = 3;
            }else if (results[i][8].equals("31+")){
                numValue[i][8] = 4;
            }else{
                numValue[i][8] = 2;
            }

            if (results[i][9].equals("Hardly/At All")){
                numValue[i][9] = 1;
            }else if (results[i][9].equals("Sometimes")){
                numValue[i][9] = 2;
            }else if (results[i][9].equals("Very Often")){
                numValue[i][9] = 3;
            }else{
                numValue[i][9] = 2;
            }

            if (results[i][10].equals("Electric")){
                numValue[i][10] = 1;
            }else if (results[i][10].equals("Plug-In Hybrid")){
                numValue[i][10] = 2;
            }else if (results[i][10].equals("Engine Charging Hybrid")){
                numValue[i][10] = 3;
            }else if (results[i][10].equals("Small Diesel/Petrol")){
                numValue[i][10] = 4;
            }else if (results[i][10].equals("Medium Diesel/Petrol")){
                numValue[i][10] = 5;
            }else if (results[i][10].equals("Large Diesel/Petrol")){
                numValue[i][10] = 6;
            }else{
                numValue[i][10] = 3;
            }

            if (results[i][11].equals("0")){
                numValue[i][11] = 1;
            }else if (results[i][11].equals("1-5")){
                numValue[i][11] = 2;
            }else if (results[i][11].equals("6-10")){
                numValue[i][11] = 3;
            }else if (results[i][11].equals("11-15")){
                numValue[i][11] = 4;
            }else if (results[i][11].equals("16-20")){
                numValue[i][11] = 5;
            }else if (results[i][11].equals("21-24")){
                numValue[i][11] = 6;
            }else{
                numValue[i][11] = 4;
            }

            if (results[i][12].equals("0")){
                numValue[i][12] = 1;
            }else if (results[i][12].equals("1-5")){
                numValue[i][12] = 2;
            }else if (results[i][12].equals("6-10")){
                numValue[i][12] = 3;
            }else if (results[i][12].equals("11-15")){
                numValue[i][12] = 4;
            }else if (results[i][12].equals("16-20")){
                numValue[i][12] = 5;
            }else if (results[i][12].equals("21-24")){
                numValue[i][12] = 6;
            }else{
                numValue[i][12] = 3;
            }

            if (results[i][13].equals("0")){
                numValue[i][13] = 1;
            }else if (results[i][13].equals("1-2")){
                numValue[i][13] = 2;
            }else if (results[i][13].equals("3-5")){
                numValue[i][13] = 3;
            }else if (results[i][13].equals("6-10")){
                numValue[i][13] = 4;
            }else if (results[i][13].equals("11+")){
                numValue[i][13] = 5;
            }else{
                numValue[i][13] = 3;
            }

            if (results[i][14].equals("1")){
                numValue[i][14] = 1;
            }else if (results[i][14].equals("2")){
                numValue[i][14] = 2;
            }else if (results[i][14].equals("3")){
                numValue[i][14] = 3;
            }else if (results[i][14].equals("4")){
                numValue[i][14] = 4;
            }else if (results[i][14].equals("5+")){
                numValue[i][14] = 5;
            }else{
                numValue[i][14] = 3;
            }

            if (results[i][15].equals("Wood")){
                numValue[i][15] = 1;
            }else if (results[i][15].equals("Electricity")){
                numValue[i][15] = 2;
            }else if (results[i][15].equals("Natural Gas")){
                numValue[i][15] = 3;
            }else if (results[i][15].equals("Oil")){
                numValue[i][15] = 4;
            }else{
                numValue[i][15] = 2;
            }

            if (results[i][16].equals("Don't Know")){
                numValue[i][16] = 2;
            }else if (results[i][16].equals("No")){
                numValue[i][16] = 1;
            }else if (results[i][16].equals("Yes but not 100% Renewable")){
                numValue[i][16] = 3;
            }else if (results[i][16].equals("Yes")){
                numValue[i][16] = 4;
            }else{
                numValue[i][16] = 2;
            }

            if (results[i][17].equals("No")){
                numValue[i][17] = 1;
            }else if (results[i][17].equals("Yes")){
                numValue[i][17] = 2;
            }else{
                numValue[i][17] = 1;
            }

            if (results[i][18].equals("Bellow 14")){
                numValue[i][18] = 1;
            }else if (results[i][18].equals("14-17")){
                numValue[i][18] = 1;
            }else if (results[i][18].equals("18-21")){
                numValue[i][18] = 3;
            }else if (results[i][18].equals("Over 21")){
                numValue[i][18] = 4;
            }else{
                numValue[i][18] = 2;
            }

            if (results[i][19].equals("0")){
                numValue[i][19] = 1;
            }else if (results[i][19].equals("1")){
                numValue[i][19] = 2;
            }else if (results[i][19].equals("2")){
                numValue[i][19] = 3;
            }else if (results[i][19].equals("3")){
                numValue[i][19] = 4;
            }else if (results[i][19].equals("4")){
                numValue[i][19] = 5;
            }else if (results[i][19].equals("5")){
                numValue[i][19] = 6;
            }else if (results[i][19].equals("6")){
                numValue[i][19] = 7;
            }else if (results[i][19].equals("7")){
                numValue[i][19] = 8;
            }else if (results[i][19].equals("8")){
                numValue[i][19] = 9;
            }else{
                numValue[i][19] = 4;
            }

            if (results[i][20].equals("0-20")){
                numValue[i][20] = 1;
            }else if (results[i][20].equals("21-50")){
                numValue[i][20] = 2;
            }else if (results[i][20].equals("51-90")){
                numValue[i][20] = 3;
            }else if (results[i][20].equals("91-150")){
                numValue[i][20] = 4;
            }else if (results[i][20].equals("151-200")){
                numValue[i][20] = 5;
            }else if (results[i][20].equals("201+")){
                numValue[i][20] = 6;
            }else{
                numValue[i][20] = 4;
            }

            if (results[i][21].equals("0-50")){
                numValue[i][21] = 1;
            }else if (results[i][21].equals("51-100")){
                numValue[i][21] = 2;
            }else if (results[i][21].equals("101-150")){
                numValue[i][21] = 3;
            }else if (results[i][21].equals("151-250")){
                numValue[i][21] = 4;
            }else if (results[i][21].equals("251-300")){
                numValue[i][21] = 5;
            }else if (results[i][21].equals("301+")){
                numValue[i][21] = 6;
            }else{
                numValue[i][21] = 3;
            }

            if (results[i][22].equals("0-20")){
                numValue[i][22] = 1;
            }else if (results[i][22].equals("21-40")){
                numValue[i][22] = 2;
            }else if (results[i][22].equals("41-70")){
                numValue[i][22] = 3;
            }else if (results[i][22].equals("71-100")){
                numValue[i][22] = 4;
            }else if (results[i][22].equals("100+")){
                numValue[i][22] = 5;
            }else{
                numValue[i][22] = 3;
            }

            if (results[i][23].equals("0-50")){
                numValue[i][23] = 1;
            }else if (results[i][23].equals("51-100")){
                numValue[i][23] = 2;
            }else if (results[i][23].equals("101-150")){
                numValue[i][23] = 3;
            }else if (results[i][23].equals("151-200")){
                numValue[i][23] = 4;
            }else if (results[i][23].equals("201-250")){
                numValue[i][23] = 5;
            }else if (results[i][23].equals("251-300")){
                numValue[i][23] = 6;
            }else if (results[i][23].equals("301+")){
                numValue[i][23] = 7;
            }else{
                numValue[i][23] = 4;
            }

            if (results[i][24].equals("0")){
                numValue[i][24] = 1;
            }else if (results[i][24].equals("1")){
                numValue[i][24] = 2;
            }else if (results[i][24].equals("2")){
                numValue[i][24] = 3;
            }else if (results[i][24].equals("3")){
                numValue[i][24] = 4;
            }else if (results[i][24].equals("4")){
                numValue[i][24] = 5;
            }else if (results[i][24].equals("5")){
                numValue[i][24] = 6;
            }else if (results[i][24].equals("6")){
                numValue[i][24] = 7;
            }else{
                numValue[i][24] = 4;
            }

            if (results[i][25].equals("0")){
                numValue[i][25] = 1;
            }else if (results[i][25].equals("1")){
                numValue[i][25] = 2;
            }else if (results[i][25].equals("2")){
                numValue[i][25] = 3;
            }else if (results[i][25].equals("3")){
                numValue[i][25] = 4;
            }else if (results[i][25].equals("4+")){
                numValue[i][25] = 5;
            }else{
                numValue[i][25] = 3;
            }

            if (results[i][26].equals("0-2")){
                numValue[i][26] = 1;
            }else if (results[i][26].equals("3")){
                numValue[i][26] = 2;
            }else if (results[i][26].equals("4")){
                numValue[i][26] = 3;
            }else if (results[i][26].equals("5")){
                numValue[i][26] = 4;
            }else if (results[i][26].equals("6")){
                numValue[i][26] = 5;
            }else if (results[i][26].equals("7")){
                numValue[i][26] = 6;
            }else{
                numValue[i][26] = 3;
            }

            if (results[i][27].equals("No")){
                numValue[i][27] = 1;
            }else if (results[i][27].equals("Yes")){
                numValue[i][27] = 2;
            }else{
                numValue[i][27] = 2;
            }

            int waterPerWeek = Integer.parseInt(results[i][28]);
            if (waterPerWeek <= 500){
                numValue[i][28] = 0;
            }else if (waterPerWeek > 500 && waterPerWeek <= 1000){
                numValue[i][28] = 1;
            }else if (waterPerWeek > 1000 && waterPerWeek <= 1500){
                numValue[i][28] = 2;
            }else if (waterPerWeek > 1500 && waterPerWeek <= 2000){
                numValue[i][28] = 3;
            }else if (waterPerWeek > 2500 && waterPerWeek <= 3000){
                numValue[i][28] = 4;
            }else if (waterPerWeek > 3000 && waterPerWeek <= 3500){
                numValue[i][28] = 5;
            }else if (waterPerWeek > 3500 && waterPerWeek <= 4000){
                numValue[i][28] = 6;
            }else if (waterPerWeek > 4000){
                numValue[i][28] = 7;
            }else{
                numValue[i][28] = 2;
            }

        }
        return numValue;
    }
}
