package io.door2door.analytics.network.model;

/**
 * Network model for creating events.
 */
public class CreateEvent extends BaseEvent {

    private static final String TYPE = "create";

    /**
     * Constructor.
     */
    public CreateEvent() {
        setType(TYPE);
    }
}
