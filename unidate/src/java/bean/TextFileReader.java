package bean;

import java.io.*;

/**
 * This class reads from external txt files and provides the output as a String.
 *
 * @author missimfis
 */
public class TextFileReader {

    private static BufferedReader reader;
    private static StringBuffer buffer;

    /**
     * Provides the FileReader
     *
     * @param filename the path to the txt File that is to be read.
     * @throws FileNotFoundException if file does not exist
     * @throws IOException if I/O operation failed
     */
    public static void getReader(String filename) throws FileNotFoundException, IOException {
        reader = new BufferedReader(new FileReader(new File(filename)));
    }

    /**
     * This method reads a textfile and returns it as string.
     *
     * @param meineDatei the path to the textfile.
     * @return A String of the content of the textfile
     * @throws FileNotFoundException if file does not exist
     * @throws IOException if I/O operation failed
     */
    public static String parse(String meineDatei) throws FileNotFoundException, IOException {

        if (new File(meineDatei).canRead()) // 
        {
            getReader(meineDatei);
            String content = reader.readLine();
            buffer = new StringBuffer();

            while (content != null) // 
            {
                content = reader.readLine();
                if (content != null) {
                    buffer.append(content);
                }
            }
        }
        reader.close();
        return buffer.toString();
    }
}