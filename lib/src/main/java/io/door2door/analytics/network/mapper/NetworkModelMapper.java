package io.door2door.analytics.network.mapper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import io.door2door.analytics.api.model.SearchTripEvent;
import io.door2door.analytics.api.model.InitializationParameters;
import io.door2door.analytics.base.DeviceIdRetriever;
import io.door2door.analytics.base.model.ModeOfTransportation;
import io.door2door.analytics.network.model.Client;
import io.door2door.analytics.network.model.Person;
import io.door2door.analytics.network.model.Place;
import io.door2door.analytics.network.model.PlaceAtTime;
import io.door2door.analytics.network.model.Trip;
import io.door2door.analytics.network.model.TripRequest;
import io.door2door.analytics.network.model.Action;

/**
 * Mapper class for mapping between models.
 */
public class NetworkModelMapper {

    private final InitializationParameters initializationParameters;
    private final DeviceIdRetriever deviceIdRetriever;

    /**
     * Instantiates a new Model mapper.
     *
     * @param initializationParameters the initialization parameters
     * @param deviceIdRetriever the device id retriever
     */
    public NetworkModelMapper(InitializationParameters initializationParameters,
                       DeviceIdRetriever deviceIdRetriever) {
        this.initializationParameters = initializationParameters;
        this.deviceIdRetriever = deviceIdRetriever;
    }

    /**
     * Maps model from {@link SearchTripEvent} to {@link TripRequest}.
     *
     * @param searchTripEvent the searchTripEvent
     * @return the {@link TripRequest} result
     */
    public TripRequest mapSearchTripEventToTripEventRequest(SearchTripEvent searchTripEvent) {
        Trip trip = mapSearchTripEventToTrip(searchTripEvent);

        Person actor = setupPerson();

        TripRequest tripRequest = new TripRequest();
        tripRequest.setAction(Action.SEARCH);
        tripRequest.setTrip(trip);
        tripRequest.setTimestamp(new Date());
        tripRequest.setActor(actor);
        return tripRequest;
    }

    private Person setupPerson() {
        Client client = new Client();
        client.setApplication(initializationParameters.getApplicationName());
        client.setVersion(initializationParameters.getVersionName());
        client.setPlatform(Client.PLATFORM);
        client.setDeviceId(deviceIdRetriever.getDeviceId());

        Person actor = new Person();
        actor.setClient(client);
        return actor;
    }

    private Trip mapSearchTripEventToTrip(SearchTripEvent searchTripEvent) {
        Place departure = new Place();
        departure.setCity(searchTripEvent.getDepartureCity());
        departure.setCountry(searchTripEvent.getDepartureCountry());
        departure.setName(searchTripEvent.getDepartureName());
        departure.setLatitude(searchTripEvent.getDepartureLatitude());
        departure.setLongitude(searchTripEvent.getDepartureLongitude());
        departure.setPostalCode(searchTripEvent.getDeparturePostalCode());
        departure.setStreet(searchTripEvent.getDepartureStreet());

        PlaceAtTime departureAtTime = new PlaceAtTime();
        departureAtTime.setTimestamp(searchTripEvent.getDepartureTimestamp());
        departureAtTime.setPlace(departure);

        Place arrival = new Place();
        arrival.setCity(searchTripEvent.getArrivalCity());
        arrival.setCountry(searchTripEvent.getArrivalCountry());
        arrival.setName(searchTripEvent.getArrivalName());
        arrival.setLatitude(searchTripEvent.getArrivalLatitude());
        arrival.setLongitude(searchTripEvent.getArrivalLongitude());
        arrival.setPostalCode(searchTripEvent.getArrivalPostalCode());
        arrival.setStreet(searchTripEvent.getArrivalStreet());

        PlaceAtTime arrivalAtTime = new PlaceAtTime();
        arrivalAtTime.setTimestamp(searchTripEvent.getArrivalTimestamp());
        arrivalAtTime.setPlace(arrival);

        List<ModeOfTransportation> modeOfTransportationList = new ArrayList<>();
        modeOfTransportationList.addAll(searchTripEvent.getModeOfTransportationList());

        Trip trip = new Trip();
        trip.setDeparture(departureAtTime);
        trip.setArrival(arrivalAtTime);
        trip.setModeOfTransportation(modeOfTransportationList);
        return trip;
    }
}
