package JavaTest;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class SeleniumLogger {

    private static final Logger logger = Logger.getLogger(SeleniumLogger.class.getName());

    static {
        configureLogger();
    }

    private static void configureLogger() {
        try {
            FileHandler fileHandler = new FileHandler("selenium_logs.log");
            fileHandler.setFormatter(new SimpleFormatter());
            logger.addHandler(fileHandler);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void logInfo(String message) {
        logger.log(Level.INFO, "INFO: " + message);
    }

    public static void logPassed(String message) {
        logger.log(Level.INFO, "PASSED: " + message);
    }

    public static void logFailed(String message) {
        logger.log(Level.SEVERE, "FAILED: " + message);
    }
}
