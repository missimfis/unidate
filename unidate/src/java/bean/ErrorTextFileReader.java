package bean;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author missimfis
 */
public class ErrorTextFileReader {

    private BufferedReader reader;
    private final List<String[]> errorList = new ArrayList<>();

    /**
     * Provides the FileReader
     *
     * @param filename the path to the txt File where the Errors are defined.
     * @throws FileNotFoundException
     * @throws IOException
     */
    void getReader(String filename) throws FileNotFoundException, IOException {
        this.reader = new BufferedReader(new FileReader(new File(filename)));
    }

    /**
     * This method reads the ErrorText file and fills it up into an ArrayList.
     *
     * @param meineDatei the path to the txt File where the Errors are defined.
     * @return An ArrayList of Arrays of three Strings. The Strings are
     * ErrorType Reference and Errortext.
     * @throws FileNotFoundException
     * @throws IOException
     */
    public List<String[]> parse(String meineDatei) throws FileNotFoundException, IOException {

        if (new File(meineDatei).canRead()) // 
        {
            this.getReader(meineDatei);
            String content = this.reader.readLine();

            while (content != null) // 
            {
                content = this.reader.readLine();
                if (content != null) {
                    errorList.add(content.split("___+"));
                }
            }
        }
        if (reader != null) {
            reader.close();
        }
        return errorList;
    }
}