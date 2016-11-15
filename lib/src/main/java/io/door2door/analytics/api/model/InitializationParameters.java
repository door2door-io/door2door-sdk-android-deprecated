package io.door2door.analytics.api.model;

import io.door2door.analytics.base.model.Environment;

/**
 * Model class containing all the parameters that can be set wile initializing the SDK.
 */
public class InitializationParameters {

    private final boolean loggerEnabled;
    private final String applicationName;
    private final String versionName;
    private final Environment environment;

    /**
     * Instantiates a new Initialization parameters.
     *
     * @param loggerEnabled   the logger enabled
     * @param applicationName the application name
     * @param versionName     the version name
     * @param environment     the environment
     */
    InitializationParameters(boolean loggerEnabled, String applicationName,
                                    String versionName, Environment environment) {
        this.loggerEnabled = loggerEnabled;
        this.applicationName = applicationName;
        this.versionName = versionName;
        this.environment = environment;
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
     * Gets application name.
     *
     * @return the application name
     */
    public String getApplicationName() {
        return applicationName;
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
     * Gets environment.
     *
     * @return the environment
     */
    public Environment getEnvironment() {
        return environment;
    }

    /**
     * The type Initialization parameters builder.
     */
    public static class InitializationParametersBuilder {

        private boolean loggerEnabled = false;
        private String applicationName;
        private String versionName;
        private Environment environment = Environment.PRODUCTION;

        /**
         * Sets logger enabled.
         *
         * @param loggerEnabled the logger enabled
         * @return the logger enabled
         */
        public InitializationParametersBuilder setLoggerEnabled(boolean loggerEnabled) {
            this.loggerEnabled = loggerEnabled;
            return this;
        }

        /**
         * Sets application name.
         *
         * @param applicationName the application name
         * @return the application name
         */
        public InitializationParametersBuilder setApplicationName(String applicationName) {
            this.applicationName = applicationName;
            return this;
        }

        /**
         * Sets version name.
         *
         * @param versionName the version name
         * @return the version name
         */
        public InitializationParametersBuilder setVersionName(String versionName) {
            this.versionName = versionName;
            return this;
        }

        /**
         * Sets environment.
         *
         * @param environment the environment
         * @return the environment
         */
        public InitializationParametersBuilder setEnvironment(Environment environment) {
            this.environment = environment;
            return this;
        }

        /**
         * Build initialization parameters.
         *
         * @return the initialization parameters
         */
        public InitializationParameters build() {
            return new InitializationParameters(loggerEnabled, applicationName, versionName,
                    environment);
        }
    }

}
