package io.door2door.analytics.mapper;

import java.util.Date;

import io.door2door.analytics.api.model.CreateTripEvent;
import io.door2door.analytics.api.model.InitializationParameters;
import io.door2door.analytics.base.DeviceIdRetriever;
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
    private final DeviceIdRetriever deviceIdRetriever;

    /**
     * Instantiates a new Model mapper.
     *
     * @param initializationParameters the initialization parameters
     * @param deviceIdRetriever the device id retriever
     */
    public ModelMapper(InitializationParameters initializationParameters,
                       DeviceIdRetriever deviceIdRetriever) {
        this.initializationParameters = initializationParameters;
        this.deviceIdRetriever = deviceIdRetriever;
    }

    /**
     * Maps model from {@link CreateTripEvent} to {@link TripRequest}.
     *
     * @param createTripEvent the createTripEvent
     * @return the {@link TripRequest} result
     */
    public TripRequest mapCreateTripEventToTripEventRequest(CreateTripEvent createTripEvent) {
        Trip trip = mapCreateTripEventToTrip(createTripEvent);

        Person actor = setupPerson();

        TripRequest tripRequest = new TripRequest();
        tripRequest.setStage(TripStage.CREATE);
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

    private Trip mapCreateTripEventToTrip(CreateTripEvent createTripEvent) {
        Place origin = new Place();
        origin.setCity(createTripEvent.getOriginCity());
        origin.setCountry(createTripEvent.getOriginCountry());
        origin.setName(createTripEvent.getOriginName());
        origin.setLatitude(createTripEvent.getOriginLatitude());
        origin.setLongitude(createTripEvent.getOriginLongitude());
        origin.setPostalCode(createTripEvent.getOriginPostalCode());
        origin.setStreet(createTripEvent.getOriginStreet());

        Place destination = new Place();
        destination.setCity(createTripEvent.getDestinationCity());
        destination.setCountry(createTripEvent.getDestinationCountry());
        destination.setName(createTripEvent.getDestinationName());
        destination.setLatitude(createTripEvent.getDestinationLatitude());
        destination.setLongitude(createTripEvent.getDestinationLongitude());
        destination.setPostalCode(createTripEvent.getDestinationPostalCode());
        destination.setStreet(createTripEvent.getDestinationStreet());

        Trip trip = new Trip();
        trip.setDestination(destination);
        trip.setOrigin(origin);
        return trip;
    }
}
