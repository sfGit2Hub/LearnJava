package log;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.logging.*;

/**
 * Created by Administrator on 2016/12/29.
 */
public class SFLogger {
    private static Logger logger;
    private static FileHandler fileHandler;
    static {
        try {
            fileHandler = new FileHandler("log\\project.log", true);
            //            ConsoleHandler consoleHandler = new ConsoleHandler();
            fileHandler.setLevel(Level.ALL);
            fileHandler.setEncoding("UTF-8");
            fileHandler.setFormatter(new Formatter() {
                @Override
                public String format(LogRecord record)
                {
                    LocalDateTime dateTime = LocalDateTime.now();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                    String strDateTime = dateTime.format(formatter);
                    return new StringBuilder().append(strDateTime + " ")
                            .append(record.getLoggerName() + " ")
                            .append(record.getLevel() + " : ")
                            .append(record.getMessage() + "\n")
                            .toString();
                }
            });
            logger.addHandler(fileHandler);
//            logger.addHandler(consoleHandler);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public synchronized static void info(String message) {
        logger.setLevel(Level.INFO);
        synchronized (logger) {
            logger.info(message);
        }
    }

    public static Logger getLogger(String className) {
        logger = Logger.getLogger(className);
        return logger;
    }
    public static void main(String []args) {
        System.out.println(System.getProperty("user.dir"));
        getLogger(SFLogger.class.getName());
        info("Test Log info");
        logger.info("------ Test Log info -------");
    }
}
