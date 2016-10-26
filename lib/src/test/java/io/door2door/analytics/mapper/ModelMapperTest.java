package io.door2door.analytics.mapper;

import org.junit.Before;
import org.junit.Test;


import io.door2door.analytics.api.model.CreateTripEvent;
import io.door2door.analytics.api.model.InitializationParameters;
import io.door2door.analytics.network.model.Client;
import io.door2door.analytics.network.model.Place;
import io.door2door.analytics.network.model.TripRequest;

import static org.assertj.core.api.Java6Assertions.assertThat;


/**
 * Test class for {@link ModelMapper}.
 */
public class ModelMapperTest {

    private ModelMapper modelMapper;

    @Before
    public void setUp() {
        InitializationParameters initializationParameters = new InitializationParameters();
        initializationParameters.setApplicationName("someApplication");
        initializationParameters.setVersionName("v1.0.1");
        modelMapper = new ModelMapper(initializationParameters);
    }

    @Test
    public void shouldMapEventToEventRequest() {
        // given
        CreateTripEvent event = new CreateTripEvent.CreateTripEventBuilder()
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
                .setDestinationCountry("GermanyCountry")
                .build();

        // when
        TripRequest eventRequest = modelMapper.mapCreateTripEventToTripEventRequest(event);

        // then
        Client client = eventRequest.getActor().getClient();
        assertThat(client.getApplication()).isEqualTo("someApplication");
        assertThat(client.getVersion()).isEqualTo("v1.0.1");
        assertThat(client.getPlatform()).isEqualTo(Client.PLATFORM);

        Place origin = eventRequest.getTrip().getOrigin();
        assertThat(origin.getLatitude()).isEqualTo(52.529919f);
        assertThat(origin.getLongitude()).isEqualTo(13.403067f);
        assertThat(origin.getName()).isEqualTo("Door2Door HQ");
        assertThat(origin.getStreet()).isEqualTo("Torstrasse 109");
        assertThat(origin.getCity()).isEqualTo("Berlin");
        assertThat(origin.getPostalCode()).isEqualTo("10119");
        assertThat(origin.getCountry()).isEqualTo("Germany");

        Place destination = eventRequest.getTrip().getDestination();
        assertThat(destination.getLatitude()).isEqualTo(52.522258f);
        assertThat(destination.getLongitude()).isEqualTo(13.412678f);
        assertThat(destination.getName()).isEqualTo("Alexanderplatz");
        assertThat(destination.getStreet()).isEqualTo("AlexanderplatzStreet");
        assertThat(destination.getCity()).isEqualTo("BerlinCity");
        assertThat(destination.getPostalCode()).isEqualTo("10178");
        assertThat(destination.getCountry()).isEqualTo("GermanyCountry");
    }

}