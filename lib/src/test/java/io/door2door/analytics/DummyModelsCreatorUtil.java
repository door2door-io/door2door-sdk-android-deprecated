package io.door2door.analytics;

import io.door2door.analytics.api.model.CreateTripEvent;

/**
 * Utility class for creating dummy models in the tests.
 */
public class DummyModelsCreatorUtil {

    private DummyModelsCreatorUtil() {
        // hide the constructor of the util class.
    }

    /**
     * Sets dummy create trip event builder.
     *
     * @return the dummy create trip event builder
     */
    public static CreateTripEvent.CreateTripEventBuilder getDummyCreateTripEventBuilder() {
        return new CreateTripEvent.CreateTripEventBuilder()
                .setOriginLatitude(52.529919f)
                .setOriginLongitude(13.403067f)
                .setOriginName("Door2Door HQ")
                .setOriginStreet("Torstrasse 109")
                .setOriginCity("Berlin")
                .setOriginPostalCode("10119")
                .setOriginCountry("Germany")
                .setDestinationLatitude(52.522258f)
                .setDestinationLongitude(13.412678f)
                .setDestinationName("Alexanderplatz")
                .setDestinationStreet("AlexanderplatzStreet")
                .setDestinationCity("BerlinCity")
                .setDestinationPostalCode("10178")
                .setDestinationCountry("GermanyCountry");
    }
}
