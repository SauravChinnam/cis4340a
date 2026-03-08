import java.util.logging.Logger;
import java.util.regex.Pattern;


public class R00_IDS03_J {
    private static final Logger logger = Logger.getLogger(R00_IDS03_J.class.getName());


    public static void main(String[] args) {


        compliantMain(args);
    }


    private static String sanitizeUser(String username) {
        return Pattern.matches("[A-Za-z0-9]+", username) ? username : "unauthorized user";
    }


    public static void compliantMain(String[] args) {
        String username = args.length > 0 ? args[0] : "guest";
        boolean loginSuccessful = false;


        String safeUser = sanitizeUser(username);
        if (loginSuccessful) {
            logger.severe("User login succeeded for: " + safeUser);
        } else {
            logger.severe("User login failed for: " + safeUser);
        }
    }
}
