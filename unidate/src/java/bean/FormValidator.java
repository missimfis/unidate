package bean;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Creates a Singleton that can be used to validate the entries into forms or
 * any String for a certain Pattern.
 *
 */
public class FormValidator {

    private static final FormValidator INSTANCE = new FormValidator();

    /**
     * On call the FormValidator instance will be devilered and its methods can
     * be accessed.
     *
     * @return the FormValidator instance on which its methods can be called.
     */
    public static FormValidator getInstance() {
        return INSTANCE;
    }

    /**
     * Takes a string and checks if it meets the necessary pattern to be a valid
     * email adress.
     *
     * @param email to be validated.
     * @param type of the checked string will be used for setting the right
     * error.
     * @return true if the input meets the required specifications.
     */
    public boolean checkEmail(String email, String type) {
        ErrorText errors = ErrorText.getInstance();
        if (email != null && email.length() > 0) {
            Pattern p = Pattern.compile("^[a-zA-Z0-9]+((\\.|!|_|\\+|\\-)[a-zA-Z0-9]+)*@([a-zA-Z0-9]+(\\.|\\-))+[a-zA-Z0-9]{2,}$");
            Matcher m = p.matcher(email);
            if (!m.matches()) {
                errors.setError(type);
            }
            return m.matches();
        } else {
            errors.setError(type + "Empty");
            return false;
        }
    }

    /**
     * Takes a String and checks if it meets the given patterns.
     * <p>
     * Momentary used patterns are: Allowed are only letters and numbers and no
     * other symbols. Length must be between 1 and 255.
     *
     * @param string to be validated.
     * @param type will be used to set the right error when validation failes.
     * @return true if the input meets the required specifications.
     */
    public boolean checkString(String string, String type) { 
        ErrorText errors = ErrorText.getInstance();
        if (string != null && string.length() > 0) {
            Pattern p = Pattern.compile("[a-zA-Z0-9ÁáÃãâÂêëËÊÉéÀàÈèöäüÄÜÖßÇçÅåæðøÆíÍìÌïÏîÎÑñÓóÒòÔôÕõÚúÙùÛûÝýÿØÐÞþ\\!\"#\\$\\&\\%\\'\\(\\)\\*\\+\\,\\-\\.\\/\\:\\<\\=\\>\\?\\_]{1,255}");
            Matcher m = p.matcher(string);
            if (!m.matches()) {
                errors.setError(type);
            }
            return m.matches();
        } else {
            errors.setError(type + "Empty");
            return false;
        }
    }
}