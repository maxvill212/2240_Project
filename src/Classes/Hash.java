/**************************************************************************************************************
*                                                                                                             *
*    The hashing algorithm used is made jBCrypt, and OpenBSD's Blowfish password hashing code found here:     *
*                                    http://www.mindrot.org/projects/jBCrypt/                                 *
*                                                                                                             *
***************************************************************************************************************/




package Classes;

public class Hash {

    //    Checking if the password is long enough (6 characters)
    public boolean checkLength(String pass) {
        if (pass.length() <= 5) {
            return false;
        }
        return true;
    }


    public String hashPass(String pass) {

//    Hash Password for the 1st Time
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
}




