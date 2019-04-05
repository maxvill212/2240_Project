//<editor-fold desc="About Class"
/*********************************************************************************************************************
 *                                                                                                                   *
 *       ***************ABOUT**********************                                                                  *
 *       This is the class that hashes the password and uses REGEX to check name and username on createAccount       *
 *                                                                                                                   *
 *       The hashing algorithm used is made jBCrypt, and OpenBSD's Blowfish password hashing code found here:        *
 *       http://www.mindrot.org/projects/jBCrypt/                                                                    *
 *                                                                                                                   *
 *       **********VARIABLES HashAndCheck**********                                                                  *
 *       String                                                                                                      *
 *          pattern             -> Store the required REGEX pattern                                                  *
 *       Integer                                                                                                     *
 *          i                    -> A count that tracks where to place the user's input in the array                 *
 *       ObservableList<String>                                                                                      *
 *          choiceBoxList        -> The object that allows The list of options to be displayed on the screen         *
 *                                                                                                                   *
 ********************************************************************************************************************/
//</editor-fold>



package Classes;

import java.util.regex.*;

public class HashAndCheck {


    String pattern;

    //    Checking if the password is long enough (6 characters)
    public boolean checkLength(String pass) {
        if (pass.length() <= 5) {
            return false;
        }
        return true;
    }

//    HashAndCheck Password for the 1st Time
//    Gensalt's log_rounds parameter determines the complexity
//    the work factor is 2**log_rounds, and the default is 10
    public String hashPass(String pass) {
        String hashed = jBCryptLibrary.BCrypt.hashpw(pass, jBCryptLibrary.BCrypt.gensalt(10));
        return hashed;
    }


//    Check that an unencrypted password matches one that has previously been hashed
    public boolean checkHash(String pass, String hash) {
        if (jBCryptLibrary.BCrypt.checkpw(pass, hash)){
            return true;
        }return false;
    }

//    Checks to make sure the full name follows the REGEX pattern
    public boolean checkFullName (String name){
        pattern = "^([A-z\'\\.-ᶜ]*(\\s))+[A-z\\'\\.-ᶜ]*$";
        Pattern pObj = Pattern.compile(pattern);
        Matcher matcher = pObj.matcher(name);

        if (matcher.find()){
            return true;
        }return false;
    }

//    Checks to make sure the username follows the REGEX pattern
    public boolean checkUsername (String username){
        pattern = "[a-zA-Z0-9\\._\\-]{3,}";
        Pattern pObj = Pattern.compile(pattern);
        Matcher matcher = pObj.matcher(username);

        if (matcher.find()){
            return true;
        }return false;
    }

//    Check question 29 to makes sure its a integer
    public boolean checknum29(String input){
        try
        {
            Integer.parseInt(input);
            return true;
        }
        catch( Exception e)
        {
            return false;
        }
    }
}





