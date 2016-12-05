package io.door2door.analytics.network;

import io.door2door.analytics.api.model.InitializationParameters;

/**
 * Class responsible for environment configuration.
 */
public class NetworkConfigurator {

    private static final String API_VERSION = "v1";
    private static final int TIMEOUT_SECONDS = 30;
    private final InitializationParameters initializationParameters;

    /**
     * Instantiates a new Environment selector.
     *
     * @param initializationParameters the initialization parameters
     */
    public NetworkConfigurator(InitializationParameters initializationParameters) {
        this.initializationParameters = initializationParameters;
    }

    /**
     * Gets base url.
     *
     * @return the base url
     */
    public String getBaseUrlWithVersion() {
        String baseUrl = initializationParameters.getBaseUrl();
        return String.format("%s/%s/", baseUrl, API_VERSION);
    }

    /**
     * Gets default timeout in seconds.
     *
     * @return the default timeout in seconds
     */
    public int getDefaultTimeoutInSeconds() {
        return TIMEOUT_SECONDS;
    }

}
