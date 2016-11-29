package io.door2door.analytics.mapper;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import java.util.Date;
import java.util.List;

import io.door2door.analytics.DummyModelsCreatorUtil;
import io.door2door.analytics.api.model.SearchTripEvent;
import io.door2door.analytics.api.model.InitializationParameters;
import io.door2door.analytics.base.DeviceIdRetriever;
import io.door2door.analytics.base.model.ModeOfTransportation;
import io.door2door.analytics.network.model.Action;
import io.door2door.analytics.network.model.Client;
import io.door2door.analytics.network.model.Place;
import io.door2door.analytics.network.model.PlaceAtTime;
import io.door2door.analytics.network.model.Trip;
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
        InitializationParameters initializationParameters =
                DummyModelsCreatorUtil.getDummyInitializationParametersBuilder()
                        .build();
        modelMapper = new ModelMapper(initializationParameters, deviceIdRetriever);
    }

    @Test
    public void shouldMapSearchTripEventToTripEventRequest() {
        // given
        SearchTripEvent event = DummyModelsCreatorUtil.getDummySearchTripEventBuilder()
                .build();
        String deviceId = "f33f79f4-9d06-11e6-80f5-76304dec7eb7";
        when(deviceIdRetriever.getDeviceId()).thenReturn(deviceId);

        // when
        TripRequest eventRequest = modelMapper.mapSearchTripEventToTripEventRequest(event);

        // then
        assertThat(eventRequest.getAction()).isEqualTo(Action.SEARCH);
        assertThat(eventRequest.getTimestamp()).isNotNull();

        Client client = eventRequest.getActor().getClient();
        assertThat(client.getApplication()).isEqualTo("Cool Application");
        assertThat(client.getVersion()).isEqualTo("1.0.1");
        assertThat(client.getPlatform()).isEqualTo(Client.PLATFORM);
        assertThat(client.getDeviceId()).isEqualTo(deviceId);

        Trip trip = eventRequest.getTrip();
        List<ModeOfTransportation> modeOfTransportation = trip.getModeOfTransportation();
        assertThat(modeOfTransportation.size()).isEqualTo(2);
        assertThat(modeOfTransportation.get(0)).isEqualTo(ModeOfTransportation.BIKE_SHARING);
        assertThat(modeOfTransportation.get(1)).isEqualTo(ModeOfTransportation.CAR_SHARING);


        PlaceAtTime departureAtTime = trip.getDeparture();
        assertThat(departureAtTime.getTimestamp()).isEqualTo(new Date(1479126912363L));

        Place departure = departureAtTime.getPlace();
        assertThat(departure.getLatitude()).isEqualTo(52.529919);
        assertThat(departure.getLongitude()).isEqualTo(13.403067);
        assertThat(departure.getName()).isEqualTo("Door2Door HQ");
        assertThat(departure.getStreet()).isEqualTo("Torstrasse 109");
        assertThat(departure.getCity()).isEqualTo("Berlin");
        assertThat(departure.getPostalCode()).isEqualTo("10119");
        assertThat(departure.getCountry()).isEqualTo("Germany");

        PlaceAtTime arrivalAtTime = trip.getArrival();
        assertThat(arrivalAtTime.getTimestamp()).isEqualTo(new Date(1479126932489L));

        Place arrival = arrivalAtTime.getPlace();
        assertThat(arrival.getLatitude()).isEqualTo(52.522258);
        assertThat(arrival.getLongitude()).isEqualTo(13.412678);
        assertThat(arrival.getName()).isEqualTo("Alexanderplatz");
        assertThat(arrival.getStreet()).isEqualTo("AlexanderplatzStreet");
        assertThat(arrival.getCity()).isEqualTo("BerlinCity");
        assertThat(arrival.getPostalCode()).isEqualTo("10178");
        assertThat(arrival.getCountry()).isEqualTo("GermanyCountry");
    }

    @Test
    public void shouldMapSearchTripEventToTripEventRequestWithOnlyRequiredFields() {
        // given
        SearchTripEvent event = DummyModelsCreatorUtil
                .getDummySearchTripEventBuilderWithOnlyRequiredFields()
                .build();
        String deviceId = "f33f79f4-9d06-11e6-80f5-76304dec7eb7";
        when(deviceIdRetriever.getDeviceId()).thenReturn(deviceId);

        // when
        TripRequest eventRequest = modelMapper.mapSearchTripEventToTripEventRequest(event);

        // then
        assertThat(eventRequest.getAction()).isEqualTo(Action.SEARCH);
        assertThat(eventRequest.getTimestamp()).isNotNull();

        Client client = eventRequest.getActor().getClient();
        assertThat(client.getApplication()).isEqualTo("Cool Application");
        assertThat(client.getVersion()).isEqualTo("1.0.1");
        assertThat(client.getPlatform()).isEqualTo(Client.PLATFORM);
        assertThat(client.getDeviceId()).isEqualTo(deviceId);

        Trip trip = eventRequest.getTrip();
        List<ModeOfTransportation> modeOfTransportation = trip.getModeOfTransportation();
        assertThat(modeOfTransportation.size()).isEqualTo(0);


        PlaceAtTime departureAtTime = trip.getDeparture();
        assertThat(departureAtTime.getTimestamp()).isNull();

        Place departure = departureAtTime.getPlace();
        assertThat(departure.getLatitude()).isEqualTo(52.529919);
        assertThat(departure.getLongitude()).isEqualTo(13.403067);
        assertThat(departure.getName()).isNull();
        assertThat(departure.getStreet()).isNull();
        assertThat(departure.getCity()).isNull();
        assertThat(departure.getPostalCode()).isNull();
        assertThat(departure.getCountry()).isNull();

        PlaceAtTime arrivalAtTime = trip.getArrival();
        assertThat(arrivalAtTime.getTimestamp()).isNull();

        Place arrival = arrivalAtTime.getPlace();
        assertThat(arrival.getLatitude()).isEqualTo(52.522258);
        assertThat(arrival.getLongitude()).isEqualTo(13.412678);
        assertThat(arrival.getName()).isNull();
        assertThat(arrival.getStreet()).isNull();
        assertThat(arrival.getCity()).isNull();
        assertThat(arrival.getPostalCode()).isNull();
        assertThat(arrival.getCountry()).isNull();
    }

}