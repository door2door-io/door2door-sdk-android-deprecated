package io.door2door.analytics.network;

import io.door2door.analytics.api.model.SearchTripEvent;
import io.door2door.analytics.network.mapper.NetworkModelMapper;
import io.door2door.analytics.network.model.TripRequest;
import rx.Observable;

/**
 * Http stack for communication with the backend.
 */
public class HttpStack {

    private final RetrofitService retrofitService;
    private final NetworkModelMapper networkModelMapper;

    /**
     * Constructor.
     *
     * @param retrofitService the retrofit service to be used for communication with the backend.
     * @param networkModelMapper     the model mapper to be used to get the request models from regular network models.
     */
    public HttpStack(RetrofitService retrofitService, NetworkModelMapper networkModelMapper) {
        this.retrofitService = retrofitService;
        this.networkModelMapper = networkModelMapper;
    }

    /**
     * Send trip event.
     *
     * @param event the event to send.
     * @return the backend response as observable.
     */
    public Observable<Void> sendTripEvent(SearchTripEvent event) {
        TripRequest tripRequest = networkModelMapper.mapSearchTripEventToTripEventRequest(event);
        return retrofitService.postTripEvent(tripRequest);
    }
}
