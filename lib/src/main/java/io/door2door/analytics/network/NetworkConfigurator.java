package io.door2door.analytics.network;

import java.util.HashMap;
import java.util.Map;

import io.door2door.analytics.api.model.Environment;
import io.door2door.analytics.api.model.InitializationParameters;

/**
 * Class responsible for environment configuration.
 */
public class NetworkConfigurator {

    private static final Map<Environment, String> BASE_URLS = new HashMap<>();
    private static final String API_VERSION = "v1";
    private static final String SCHEME = "https";
    private static final int TIMEOUT_SECONDS = 30;

    private final Environment environment;

    static {
        BASE_URLS.put(Environment.TEST, "events-dev.d2di.net");
        BASE_URLS.put(Environment.PRODUCTION, "events-dev.d2di.net");
    }

    /**
     * Instantiates a new Environment selector.
     *
     * @param initializationParameters the initialization parameters
     */
    public NetworkConfigurator(InitializationParameters initializationParameters) {
        environment = initializationParameters.getEnvironment();
    }

    /**
     * Gets base url.
     *
     * @return the base url
     */
    public String getBaseUrlWithVersion() {
        String baseUrl = BASE_URLS.get(environment);
        return String.format("%s://%s/%s/", SCHEME, baseUrl, API_VERSION);
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
