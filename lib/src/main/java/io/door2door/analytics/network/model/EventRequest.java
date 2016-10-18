package io.door2door.analytics.network.model;

/**
 * Model class for the request body when sending an event to the backend.
 */
public class EventRequest {

    private BaseEvent event;

    /**
     * @return the event.
     */
    public BaseEvent getEvent() {
        return event;
    }

    /**
     * @param event the event to set.
     */
    public void setEvent(BaseEvent event) {
        this.event = event;
    }
}
