package io.door2door.analytics;

import java.util.Date;

import io.door2door.analytics.api.model.InitializationParameters;
import io.door2door.analytics.api.model.SearchTripEvent;
import io.door2door.analytics.base.model.Environment;
import io.door2door.analytics.base.model.ModeOfTransportation;

/**
 * Utility class for creating dummy models in the tests.
 */
public class DummyModelsCreatorUtil {

    private DummyModelsCreatorUtil() {
        // hide the constructor of the util class.
    }

    /**
     * Sets dummy search trip event builder.
     *
     * @return the dummy search trip event builder
     */
    public static SearchTripEvent.SearchTripEventBuilder getDummySearchTripEventBuilder() {
        return new SearchTripEvent.SearchTripEventBuilder()
                .setDepartureTimestamp(new Date(1479126912363L))
                .setDepartureLatitude(52.529919)
                .setDepartureLongitude(13.403067)
                .setDepartureName("Door2Door HQ")
                .setDepartureStreet("Torstrasse 109")
                .setDepartureCity("Berlin")
                .setDeparturePostalCode("10119")
                .setDepartureCountry("Germany")
                .setArrivalTimestamp(new Date(1479126932489L))
                .setArrivalLatitude(52.522258)
                .setArrivalLongitude(13.412678)
                .setArrivalName("Alexanderplatz")
                .setArrivalStreet("AlexanderplatzStreet")
                .setArrivalCity("BerlinCity")
                .setArrivalPostalCode("10178")
                .setArrivalCountry("GermanyCountry")
                .addModeOfTransportation(ModeOfTransportation.BIKE_SHARING)
                .addModeOfTransportation(ModeOfTransportation.CAR_SHARING);
    }

    /**
     * Sets dummy search trip event builder.
     *
     * @return the dummy search trip event builder
     */
    public static SearchTripEvent.SearchTripEventBuilder
    getDummySearchTripEventBuilderWithOnlyRequiredFields() {
        return new SearchTripEvent.SearchTripEventBuilder()
                .setDepartureLatitude(52.529919)
                .setDepartureLongitude(13.403067)
                .setArrivalLatitude(52.522258)
                .setArrivalLongitude(13.412678);
    }

    /**
     * Gets dummy initialization parameters builder.
     *
     * @return the dummy initialization parameters builder
     */
    public static InitializationParameters.InitializationParametersBuilder
    getDummyInitializationParametersBuilder() {
        return new InitializationParameters.InitializationParametersBuilder()
                .setApplicationName("Cool Application")
                .setEnvironment(Environment.TEST)
                .setLoggerEnabled(true)
                .setVersionName("1.0.1");
    }
}
