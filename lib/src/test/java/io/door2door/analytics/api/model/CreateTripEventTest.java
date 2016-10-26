package io.door2door.analytics.api.model;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Test class for {@code CreateTripEvent}.
 */
public class CreateTripEventTest {

    private CreateTripEvent.CreateTripEventBuilder builder;

    @Before
    public void setUp() {
        builder = new CreateTripEvent.CreateTripEventBuilder();
    }

    @Test
    public void shouldBuildCreateTripEvent() {
        // given
        builder.setOriginLatitude(52.529919f)
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

        // when
        CreateTripEvent createTripEvent = builder.build();

        // then
        assertThat(createTripEvent.getOriginLatitude()).isEqualTo(52.529919f);
        assertThat(createTripEvent.getOriginLongitude()).isEqualTo(13.403067f);
        assertThat(createTripEvent.getOriginName()).isEqualTo("Door2Door HQ");
        assertThat(createTripEvent.getOriginStreet()).isEqualTo("Torstrasse 109");
        assertThat(createTripEvent.getOriginCity()).isEqualTo("Berlin");
        assertThat(createTripEvent.getOriginPostalCode()).isEqualTo("10119");
        assertThat(createTripEvent.getOriginCountry()).isEqualTo("Germany");
        assertThat(createTripEvent.getDestinationLatitude()).isEqualTo(52.522258f);
        assertThat(createTripEvent.getDestinationLongitude()).isEqualTo(13.412678f);
        assertThat(createTripEvent.getDestinationName()).isEqualTo("Alexanderplatz");
        assertThat(createTripEvent.getDestinationStreet()).isEqualTo("AlexanderplatzStreet");
        assertThat(createTripEvent.getDestinationCity()).isEqualTo("BerlinCity");
        assertThat(createTripEvent.getDestinationPostalCode()).isEqualTo("10178");
        assertThat(createTripEvent.getDestinationCountry()).isEqualTo("GermanyCountry");
    }

}