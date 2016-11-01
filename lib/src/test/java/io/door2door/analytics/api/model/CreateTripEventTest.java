package io.door2door.analytics.api.model;

import org.junit.Before;
import org.junit.Test;

import io.door2door.analytics.DummyModelsCreatorUtil;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Test class for {@code CreateTripEvent}.
 */
public class CreateTripEventTest {

    private CreateTripEvent.CreateTripEventBuilder builder;

    @Before
    public void setUp() {
        builder = DummyModelsCreatorUtil.getDummyCreateTripEventBuilder();
    }

    @Test
    public void shouldBuildCreateTripEvent() {
        // given

        // when
        CreateTripEvent createTripEvent = builder.build();

        // then
        assertThat(createTripEvent.getOriginLatitude()).isEqualTo(52.529919);
        assertThat(createTripEvent.getOriginLongitude()).isEqualTo(13.403067);
        assertThat(createTripEvent.getOriginName()).isEqualTo("Door2Door HQ");
        assertThat(createTripEvent.getOriginStreet()).isEqualTo("Torstrasse 109");
        assertThat(createTripEvent.getOriginCity()).isEqualTo("Berlin");
        assertThat(createTripEvent.getOriginPostalCode()).isEqualTo("10119");
        assertThat(createTripEvent.getOriginCountry()).isEqualTo("Germany");
        assertThat(createTripEvent.getDestinationLatitude()).isEqualTo(52.522258);
        assertThat(createTripEvent.getDestinationLongitude()).isEqualTo(13.412678);
        assertThat(createTripEvent.getDestinationName()).isEqualTo("Alexanderplatz");
        assertThat(createTripEvent.getDestinationStreet()).isEqualTo("AlexanderplatzStreet");
        assertThat(createTripEvent.getDestinationCity()).isEqualTo("BerlinCity");
        assertThat(createTripEvent.getDestinationPostalCode()).isEqualTo("10178");
        assertThat(createTripEvent.getDestinationCountry()).isEqualTo("GermanyCountry");
    }

}