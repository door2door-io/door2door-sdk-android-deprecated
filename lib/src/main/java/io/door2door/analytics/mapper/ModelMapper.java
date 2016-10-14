package io.door2door.analytics.mapper;

import io.door2door.analytics.base.model.Event;
import io.door2door.analytics.data.model.EventRequest;

/**
 * Mapper class for mapping between models.
 */
public class ModelMapper {

    /**
     * Maps model from {@link Event} to {@link EventRequest}.
     *
     * @param event the {@link Event} to be mapped.
     * @return the {@link EventRequest} result.
     */
    public EventRequest mapEventToEventRequest(Event event) {
        EventRequest eventRequest = new EventRequest();
        return eventRequest;
    }
}
