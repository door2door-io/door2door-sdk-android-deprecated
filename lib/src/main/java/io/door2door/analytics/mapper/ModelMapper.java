package io.door2door.analytics.mapper;

import java.util.Date;

import io.door2door.analytics.api.model.Event;
import io.door2door.analytics.network.model.EventRequest;
import io.door2door.analytics.network.model.UpdateEvent;

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
        // TODO 2016-10-18 zlatko: Temporary implementation
        // TODO 2016-10-18 zlatko: add tests once the implmentation is final
        EventRequest eventRequest = new EventRequest();
        UpdateEvent updateEvent = new UpdateEvent();
        updateEvent.setTimestamp(new Date());
        updateEvent.setActor(event.getActor());
        updateEvent.setObject(event.getObject());
        eventRequest.setEvent(updateEvent);
        return eventRequest;
    }
}
