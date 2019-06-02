package com.company;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.XMLFormatter;

public class LoggerApp {

    public static void main(String[] args) {
        configureLogging();
    }

    private static void configureLogging() {
        final Logger logClassA = Logger.getLogger("org.stepic.java.logging.ClassA");
        logClassA.setLevel(Level.ALL);
        final Logger logClassB = Logger.getLogger("org.stepic.java.logging.ClassB");
        logClassB.setLevel(Level.WARNING);
        final Logger logger = Logger.getLogger("org.stepic.java");
        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.ALL);
        consoleHandler.setFormatter(new XMLFormatter());
        logger.addHandler(consoleHandler);
        logger.setUseParentHandlers(false);
    }
}
