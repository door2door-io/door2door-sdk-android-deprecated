package io.door2door.analytics.api.model;

import io.door2door.analytics.api.exception.ValidationException;
import java.util.HashMap;
import java.util.Map;

import io.door2door.analytics.base.model.Environment;

/**
 * Model class containing all the parameters that can be set wile initializing the SDK.
 */
public class InitializationParameters {

    private static final Map<Environment, String> BASE_URLS = new HashMap<>();

    private final boolean loggerEnabled;
    private final String applicationName;
    private final String versionName;
    private final String authorizationKey;
    private final Environment environment;

    static {
        BASE_URLS.put(Environment.TEST, "https://events-dev.d2di.net");
        BASE_URLS.put(Environment.PRODUCTION, "https://events.d2di.net");
    }

    /**
     * Instantiates a new Initialization parameters.
     *  @param loggerEnabled   the logger enabled
     * @param applicationName the application name
     * @param versionName     the version name
     * @param authorizationKey the authorization key
     * @param environment     the environment
     */
    InitializationParameters(boolean loggerEnabled, String applicationName, String versionName,
        String authorizationKey, Environment environment) {
        this.loggerEnabled = loggerEnabled;
        this.applicationName = applicationName;
        this.versionName = versionName;
        this.authorizationKey = authorizationKey;
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
     * Gets base url.
     *
     * @return the base url
     */
    public String getBaseUrl() {
        return BASE_URLS.get(environment);
    }

    /**
     * Gets the authorization key.
     *
     * @return the authorization key
     */
    public String getAuthorizationKey() {
        return authorizationKey;
    }

    /**
     * The type Initialization parameters builder.
     */
    public static class InitializationParametersBuilder {

        private boolean loggerEnabled = false;
        private String applicationName;
        private String versionName;
        private String authorizationKey;
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
         * @param authorizationKey the authorization key
         * @return the environment
         */
        public InitializationParametersBuilder setAuthorizationKey(String authorizationKey) {
          this.authorizationKey = authorizationKey;
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
            if (authorizationKey == null) {
                throw new ValidationException("authorizationKey", "The authorization key must not be null when "
                    + "building the InitializationParameters. For more information on how to get an authorization "
                    + "key please refer to the SDK documentation.");
            }
            return new InitializationParameters(loggerEnabled, applicationName, versionName, authorizationKey,
                environment);
        }
    }

}
