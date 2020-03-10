package singleObjects;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;

public class Logger {
    BufferedWriter writer;
    private static boolean stackTrace = false;

    public Logger(String logFPath) {
        try {
            writer = new BufferedWriter(new FileWriter(logFPath, true));
            writer.write("\n<---->\n");
            log("Logger starts!!");
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }


    public synchronized void log(String msg) {
        try {
            StackTraceElement[] stack  = Thread.currentThread().getStackTrace();
            writer.write('<' + new Date().toString() + ">:" +
                    (stackTrace ? Arrays.toString(stack) : "") +
                    msg +
                    "\n");
            writer.flush();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }


    private static Logger logger = null;


    public static synchronized Logger getLogger() {
        if(logger == null)
            logger = new Logger("default.log");

        return logger;
    }


    public static synchronized Logger getLogger(boolean stackTrace) {
        Logger.stackTrace = stackTrace;
        return getLogger();

    }
}