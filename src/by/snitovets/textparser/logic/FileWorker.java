package by.snitovets.textparser.logic;

import by.snitovets.textparser.exception.TechnicalException;
import org.apache.log4j.Logger;

import java.io.*;

/**
 * Created by Илья on 25.06.2014.
 */
public class FileWorker {

    private static final Logger LOG = Logger.getLogger(FileWorker.class);

    private FileWorker() {
    }

    public static String getTextFromFile(String fileName) throws TechnicalException {
        StringBuilder result = new StringBuilder();
        File file = new File(fileName);
        try (BufferedReader inputReader = new BufferedReader(new FileReader(file.getAbsoluteFile()))) {
            String line;
            while (null != (line = inputReader.readLine())) {
                result.append(line);
                result.append("\n");
            }
        } catch (FileNotFoundException e) {
            throw new TechnicalException("File " + fileName + " not found", e);
        } catch (IOException e) {
            throw new TechnicalException("IOException file worker", e);
        }
        return result.toString();
    }

    public static void putTextToFile(String text, String fileName) throws TechnicalException {
        PrintWriter out = null;
        try {
            File file = new File(fileName);
            if (!file.exists()) {
                file.createNewFile();
            }
            out = new PrintWriter(file.getAbsoluteFile());
            out.print(text);
        } catch (FileNotFoundException e) {
            throw new TechnicalException("File " + fileName + " not found", e);
        } catch (IOException e) {
            throw new TechnicalException("IOException", e);
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }

}
