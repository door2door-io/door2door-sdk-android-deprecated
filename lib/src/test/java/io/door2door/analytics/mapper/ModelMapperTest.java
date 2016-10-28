package io.door2door.analytics.mapper;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import io.door2door.analytics.DummyModelsCreatorUtil;
import io.door2door.analytics.api.model.CreateTripEvent;
import io.door2door.analytics.api.model.InitializationParameters;
import io.door2door.analytics.base.DeviceIdRetriever;
import io.door2door.analytics.network.model.Client;
import io.door2door.analytics.network.model.Place;
import io.door2door.analytics.network.model.TripRequest;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.Mockito.when;


/**
 * Test class for {@link ModelMapper}.
 */
public class ModelMapperTest {

    private ModelMapper modelMapper;

    @Mock
    private DeviceIdRetriever deviceIdRetriever;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        InitializationParameters initializationParameters = new InitializationParameters();
        initializationParameters.setApplicationName("someApplication");
        initializationParameters.setVersionName("v1.0.1");
        modelMapper = new ModelMapper(initializationParameters, deviceIdRetriever);
    }

    @Test
    public void shouldMapEventToEventRequest() {
        // given
        CreateTripEvent event = DummyModelsCreatorUtil.getDummyCreateTripEventBuilder()
                .build();
        String deviceId = "f33f79f4-9d06-11e6-80f5-76304dec7eb7";
        when(deviceIdRetriever.getDeviceId()).thenReturn(deviceId);

        // when
        TripRequest eventRequest = modelMapper.mapCreateTripEventToTripEventRequest(event);

        // then
        Client client = eventRequest.getActor().getClient();
        assertThat(client.getApplication()).isEqualTo("someApplication");
        assertThat(client.getVersion()).isEqualTo("v1.0.1");
        assertThat(client.getPlatform()).isEqualTo(Client.PLATFORM);
        assertThat(client.getDeviceId()).isEqualTo(deviceId);

        Place origin = eventRequest.getTrip().getOrigin();
        assertThat(origin.getLatitude()).isEqualTo(52.529919);
        assertThat(origin.getLongitude()).isEqualTo(13.403067);
        assertThat(origin.getName()).isEqualTo("Door2Door HQ");
        assertThat(origin.getStreet()).isEqualTo("Torstrasse 109");
        assertThat(origin.getCity()).isEqualTo("Berlin");
        assertThat(origin.getPostalCode()).isEqualTo("10119");
        assertThat(origin.getCountry()).isEqualTo("Germany");

        Place destination = eventRequest.getTrip().getDestination();
        assertThat(destination.getLatitude()).isEqualTo(52.522258);
        assertThat(destination.getLongitude()).isEqualTo(13.412678);
        assertThat(destination.getName()).isEqualTo("Alexanderplatz");
        assertThat(destination.getStreet()).isEqualTo("AlexanderplatzStreet");
        assertThat(destination.getCity()).isEqualTo("BerlinCity");
        assertThat(destination.getPostalCode()).isEqualTo("10178");
        assertThat(destination.getCountry()).isEqualTo("GermanyCountry");
    }

}