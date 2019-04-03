/**************************************************************************************************************
*                                                                                                             *
*    The hashing algorithm used is made jBCrypt, and OpenBSD's Blowfish password hashing code found here:     *
*                                    http://www.mindrot.org/projects/jBCrypt/                                 *
*                                                                                                             *
**************************************************************************************************************/




package Classes;

import java.util.regex.*;

public class HashAndCheck {

    //    Checking if the password is long enough (6 characters)
    public boolean checkLength(String pass) {
        if (pass.length() <= 5) {
            return false;
        }
        return true;
    }


    public String hashPass(String pass) {

//    HashAndCheck Password for the 1st Time
//    Gensalt's log_rounds parameter determines the complexity
//    the work factor is 2**log_rounds, and the default is 10
        String hashed = org.mindrot.jbcrypt.BCrypt.hashpw(pass, org.mindrot.jbcrypt.BCrypt.gensalt(10));
        return hashed;
    }


    public boolean checkHash(String pass, String hash) {

//        Check that an unencrypted password matches one that has previously been hashed
        if (org.mindrot.jbcrypt.BCrypt.checkpw(pass, hash)){
            return true;
        }return false;
    }

    public boolean checkFullName (String name){
        String pattern = "^([A-z\'\\.-ᶜ]*(\\s))+[A-z\\'\\.-ᶜ]*$";
        Pattern pObj = Pattern.compile(pattern);
        Matcher matcher = pObj.matcher(name);

        if (matcher.find()){
            return true;
        }return false;
    }

    public boolean checkUsername (String username){
        String pattern = "[a-zA-Z0-9\\._\\-]{3,}";
        Pattern pObj = Pattern.compile(pattern);
        Matcher matcher = pObj.matcher(username);

        if (matcher.find()){
            return true;
        }return false;
    }
}




