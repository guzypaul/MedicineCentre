package by.guzypaul.medicinecentre.validator;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidator {
    public static final Logger logger = LogManager.getLogger();
    private static final String EMAIL_REGEX = "\\w+@\\p{Alpha}+\\.\\p{Alpha}{2,}";
    private static final String NAME_REGEX = "[\\p{Alpha}А-Яа-я\\s-]{1,15}";
    private static final String PASSWORD_REGEX = "[a-zA-Z\\d]{1,15}";

    public static boolean isValidName(String name) {
        logger.log(Level.DEBUG, "name: " + name);
        if (name == null || name.isEmpty()) {
            return false;
        }
        return name.matches(NAME_REGEX);
    }

    public static boolean isValidEmail(String email) {
        logger.log(Level.DEBUG, "email: " + email);
        boolean isValid = true;
        if (!email.isEmpty()) {
            Pattern pattern = Pattern.compile(EMAIL_REGEX);
            Matcher matcher = pattern.matcher(email);
            isValid = matcher.matches();
        } else {
            isValid = false;
        }
        return isValid;
    }

    public static boolean isValidPassword(String password) {
        if (password == null || password.isEmpty()) {
            return false;
        }
        return password.matches(PASSWORD_REGEX);
    }
}
