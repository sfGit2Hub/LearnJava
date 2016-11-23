package exception;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Logger;

/**
 * Created by SF on 2016/5/18.
 */
public class LoggingException extends Exception {
    private static Logger logger = Logger.getLogger("LoggingException");
    public LoggingException(){
        StringWriter trance = new StringWriter();
        printStackTrace(new PrintWriter(trance));
        logger.severe(trance.toString());
    }
    public static void main(String[] args) {
        try {
            throw new LoggingException();
        } catch (LoggingException e) {
            System.err.println("Caught " + e);
        }

        try {
            throw new LoggingException();
        } catch (LoggingException e) {
            System.err.println("Caught " + e);
        }
    }

}
