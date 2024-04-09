package com.quantum.utils;

import org.apache.logging.log4j.LogManager;

public class Logger {

    public static org.apache.logging.log4j.Logger logger = LogManager.getLogger(Logger.class.getName());

    //Creating these below methods so that we can use the log
    public static void logComment(String message) {
        logger.info("INFO: " + message);
    }
    public static void logWarning(String message) { logger.warn("WARNING: " + message);
    }
    public static void logStep(String message) {logger.info("STEP: " + message);
    }
    public static void logAction(String message) {logger.warn("ACTION: " + message);
    }
}
