package io.door2door.analytics.api.model;

/**
 * Model class containing all the parameters that can be set wile initializing the SDK.
 */
public class InitializationParameters {

    private boolean loggerEnabled;
    private String applicationName;
    private String versionName;
    private Environment environment;

    /**
     * Constructor.
     */
    public InitializationParameters() {
        initWithDefaultValues();
    }

    private void initWithDefaultValues() {
        loggerEnabled = false;
        environment = Environment.PRODUCTION;
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

    /**
     * Gets application name.
     *
     * @return the application name
     */
    public String getApplicationName() {
        return applicationName;
    }

    /**
     * Sets application name.
     *
     * @param applicationName the application name
     */
    public void setApplicationName(String applicationName) {
        this.applicationName = applicationName;
    }

    /**
     * Gets version name.
     *
     * @return the version name
     */
    public String getVersionName() {
        return versionName;
    }

    /**
     * Sets version name.
     *
     * @param versionName the version name
     */
    public void setVersionName(String versionName) {
        this.versionName = versionName;
    }

    /**
     * Gets environment.
     *
     * @return the environment
     */
    public Environment getEnvironment() {
        return environment;
    }

    /**
     * Sets environment.
     *
     * @param environment the environment
     */
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
}
