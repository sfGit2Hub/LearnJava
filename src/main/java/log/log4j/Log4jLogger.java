package log.log4j;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by SF on 2016/12/30.
 */
public class Log4jLogger {
    private  static Logger logger = LogManager.getLogger(Log4jLogger.class);
    public static void main(String []args) {
        logger.info(">>>>>> Test Log4j!  <<<<<");
        try {
            logger.info(">>>>>> Thread sleep <<<<<");
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
