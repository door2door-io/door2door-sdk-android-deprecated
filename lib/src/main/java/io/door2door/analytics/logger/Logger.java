package io.door2door.analytics.logger;

import android.util.Log;

/**
 * Class responsible for logging.
 */
public class Logger {

    private final boolean loggingEnabled;

    /**
     * Constructor.
     * @param loggingEnabled f flag to indicate if the logging should be enabled or not.
     */
    public Logger(boolean loggingEnabled) {
        this.loggingEnabled = loggingEnabled;
    }

    /**
     * Method for logging debug messages.
     * @param tag the log tag.
     * @param message the message.
     * @param throwable the throwable to be logged.
     */
    public void d(String tag, String message, Throwable throwable) {
        if (loggingEnabled) {
            Log.d(tag, message, throwable);
        }
    }

    /**
     * Method for logging debug messages.
     * @param tag the log tag.
     * @param message the message.
     */
    public void w(String tag, String message) {
        w(tag, message, null);
    }

    /**
     * Method for logging warning messages.
     * @param tag the log tag.
     * @param message the message.
     * @param throwable the throwable to be logged.
     */
    public void w(String tag, String message, Throwable throwable) {
        if (loggingEnabled) {
            Log.w(tag, message, throwable);
        }
    }

    /**
     * Method for logging debug messages.
     * @param tag the log tag.
     * @param message the message.
     */
    public void d(String tag, String message) {
        d(tag, message, null);
    }

    /**
     * Method for logging debug error.
     * @param tag the log tag.
     * @param message the message.
     * @param throwable the throwable to be logged.
     */
    public void e(String tag, String message, Throwable throwable) {
        if (loggingEnabled) {
            Log.e(tag, message, throwable);
        }
    }

    /**
     * Method for logging debug messages.
     * @param tag the log tag.
     * @param message the message.
     */
    public void e(String tag, String message) {
        e(tag, message, null);
    }
}
