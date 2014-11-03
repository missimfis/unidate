package bean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Creates a singleton that organizes the error messages by putting keys and
 * associated error texts into a hashmap that can be asked if certain errors
 * occured and if so will return the concerning error texts.
 * <p>
 * The defined Errors are saved in lemas/txt/ErrorText.txt and are read with the
 * HelperClass ErrorTextFileReader.
 *
 * @author missimfis
 */
public class ErrorText {

    private static final HashMap<String, String> errorMap = new HashMap<>();
    private static final ErrorText INSTANCE = new ErrorText();
    private static List<String[]> errorList = new ArrayList<>();
    private static String filePath = "webapps/lemas/txt/ErrorText.txt";

    public static void setFilePathForJUnitTesting(){
        filePath = "web/txt/ErrorText.txt";
    }
    
    /**
     * On call the only ErrorText instance will be delivered and errors can be
     * added or read.
     *
     * @return the ErrorText object on which its methods can be called.
     */
    public static ErrorText getInstance() {
        return INSTANCE;
    }

    /**
     * Makes an entry into the error hashmap. For this the ErrorTextFileReader
     * matches the error that is to be set with the defined Errors in
     * lemas/txt/ErrorText.txt
     *
     * @param string the error that is to be set.
     */
    public void setError(String string) {

        try {
            ErrorTextFileReader errorTextFileReader = new ErrorTextFileReader();
            errorList = errorTextFileReader.parse(filePath);
        } catch (IOException ex) {
            Logger.getLogger(ErrorText.class.getName()).log(Level.SEVERE, null, ex);
        }

        boolean notFound = true;

        for (String[] errorList1 : errorList) {
            if (notFound && errorList1[0].equals(string)) {
                errorMap.put(errorList1[1], errorList1[2]);
                notFound = false;
            }
        }

        if (notFound) {
            for (String[] errorList1 : errorList) {
                if (errorList1[0].equals("default")) {
                    errorMap.put(errorList1[1], errorList1[2]);
                }
            }
        }
    }

    /**
     * Searches and returns an error message associated to a key.
     *
     * @param string key for the error message.
     * @return the error message as String.
     */
    public String getError(String string) {
        return errorMap.get(string);
    }

    /**
     * Deletes all error entries.
     */
    public void deleteAll() {
        errorMap.clear();
    }
}