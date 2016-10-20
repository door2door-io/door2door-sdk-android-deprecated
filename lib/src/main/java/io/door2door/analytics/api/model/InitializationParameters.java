package io.door2door.analytics.api.model;

/**
 * Model class containing all the parameters that can be set wile initializing the SDK.
 */
public class InitializationParameters {

    private boolean loggerEnabled;

    /**
     * Constructor.
     */
    public InitializationParameters() {
        initWithDefaultValues();
    }

    private void initWithDefaultValues() {
        loggerEnabled = false;
    }

    /**
     * Getter for the flag for enabling logging from the library.
     *
     * @return {@code true} if logging should be enabled, {@code false} if not.
     */
    public boolean isLoggerEnabled() {
        return loggerEnabled;
    }

    /**
     * Setter for the flag for enabling logging from the library.
     *
     * @param loggerEnabled {@code true} if logging should be enabled, {@code false} if not.
     */
    public void setLoggerEnabled(boolean loggerEnabled) {
        this.loggerEnabled = loggerEnabled;
    }
}
