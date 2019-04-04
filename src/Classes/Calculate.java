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
    String result[][];
    Database database = new Database();


//    Pulls the data from database
    public String [][] pull(){
        rsSize = database.getTableLength();
        result = new String[rsSize][29];
        result = database.pullAll();
        return result;
    }


    public int average(){

        result = pull();
        return avg;
    }
}
