package io.door2door.analytics.mapper;

import java.util.Date;

import io.door2door.analytics.api.model.CreateTripEvent;
import io.door2door.analytics.api.model.InitializationParameters;
import io.door2door.analytics.network.model.Client;
import io.door2door.analytics.network.model.Person;
import io.door2door.analytics.network.model.Place;
import io.door2door.analytics.network.model.Trip;
import io.door2door.analytics.network.model.TripRequest;
import io.door2door.analytics.network.model.TripStage;

/**
 * Mapper class for mapping between models.
 */
public class ModelMapper {

    private final InitializationParameters initializationParameters;

    /**
     * Instantiates a new Model mapper.
     *
     * @param initializationParameters the initialization parameters
     */
    public ModelMapper(InitializationParameters initializationParameters) {
        this.initializationParameters = initializationParameters;
    }

    /**
     * Maps model from {@link CreateTripEvent} to {@link TripRequest}.
     *
     * @param createTripEvent the createTripEvent
     * @return the {@link TripRequest} result
     */
    public TripRequest mapCreateTripEventToTripEventRequest(CreateTripEvent createTripEvent) {
        TripRequest tripRequest = new TripRequest();
        Trip trip = mapTripToCreateTripEvent(createTripEvent);
        Person actor = new Person();
        Client client = setupClient();

        actor.setClient(client);

        tripRequest.setStage(TripStage.CREATE);
        tripRequest.setTrip(trip);
        tripRequest.setTimestamp(new Date());
        tripRequest.setActor(actor);

        return tripRequest;
    }

    private Client setupClient() {
        Client client = new Client();
        client.setApplication(initializationParameters.getApplicationName());
        client.setVersion(initializationParameters.getVersionName());
        client.setPlatform(Client.PLATFORM);
        // TODO 2016-10-25 zlatko: add driverId
        return client;
    }

    private Trip mapTripToCreateTripEvent(CreateTripEvent createTripEvent) {
        Trip trip = new Trip();
        Place destination = new Place();
        trip.setDestination(destination);
        Place origin = new Place();
        trip.setOrigin(origin);

        origin.setCity(createTripEvent.getOriginCity());
        origin.setCountry(createTripEvent.getOriginCountry());
        origin.setName(createTripEvent.getOriginName());
        origin.setLatitude(createTripEvent.getOriginLatitude());
        origin.setLongitude(createTripEvent.getOriginLongitude());
        origin.setPostalCode(createTripEvent.getOriginPostalCode());
        origin.setStreet(createTripEvent.getOriginStreet());

        destination.setCity(createTripEvent.getDestinationCity());
        destination.setCountry(createTripEvent.getDestinationCountry());
        destination.setName(createTripEvent.getDestinationName());
        destination.setLatitude(createTripEvent.getDestinationLatitude());
        destination.setLongitude(createTripEvent.getDestinationLongitude());
        destination.setPostalCode(createTripEvent.getDestinationPostalCode());
        destination.setStreet(createTripEvent.getDestinationStreet());
        return trip;
    }
}
