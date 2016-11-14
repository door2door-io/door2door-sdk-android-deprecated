package io.door2door.analytics.network;

import io.door2door.analytics.api.model.SearchTripEvent;
import io.door2door.analytics.mapper.ModelMapper;
import io.door2door.analytics.network.model.TripRequest;
import rx.Observable;

/**
 * Http stack for communication with the backend.
 */
public class HttpStack {

    private final RetrofitService retrofitService;
    private final ModelMapper modelMapper;

    /**
     * Constructor.
     *
     * @param retrofitService the retrofit service to be used for communication with the backend.
     * @param modelMapper     the model mapper to be used to get the request models from regular
     *                        models.
     */
    public HttpStack(RetrofitService retrofitService, ModelMapper modelMapper) {
        this.retrofitService = retrofitService;
        this.modelMapper = modelMapper;
    }

    /**
     * Send trip event.
     *
     * @param event the event to send.
     * @return the backend response as observable.
     */
    public Observable<Void> sendTripEvent(SearchTripEvent event) {
        TripRequest tripRequest = modelMapper.mapSearchTripEventToTripEventRequest(event);
        return retrofitService.postTripEvent(tripRequest);
    }
}
