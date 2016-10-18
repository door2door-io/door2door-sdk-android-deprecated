package io.door2door.analytics.network;

import io.door2door.analytics.base.model.Event;
import io.door2door.analytics.network.model.EventRequest;
import io.door2door.analytics.mapper.ModelMapper;

/**
 * Http stack for communication with the backend.
 */
public class HttpStack {

    private final RetrofitService retrofitService;
    private final ModelMapper modelMapper;

    /**
     * Constructor.
     * @param retrofitService the retrofit service to be used for communication with the backend.
     * @param modelMapper the model mapper to be used to get the request models from regular models.
     */
    public HttpStack(RetrofitService retrofitService, ModelMapper modelMapper) {
        this.retrofitService = retrofitService;
        this.modelMapper = modelMapper;
    }

    /**
     * Sends the event to the backend.
     *
     * @param event the event to send.
     */
    public void sendEvent(Event event) {
        EventRequest eventRequest = modelMapper.mapEventToEventRequest(event);
        retrofitService.postEvent(null, eventRequest);
    }
}
