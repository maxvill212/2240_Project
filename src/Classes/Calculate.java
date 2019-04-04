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
 *       ResultSet                                                                                                   *
 *          result         -> Stores the result from the query sent to the database                                  *
 *       Database                                                                                                    *
 *          database       -> The object that allows this page to interact with the database                         *
 *                                                                                                                   *
 ********************************************************************************************************************/
//</editor-fold>




package Classes;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Calculate {

    ResultSet result;
    Database database = new Database();

//    Pulls the data from database and splits it into
    public void pullSplit(){
        result = database.pullAll();

    }
}
