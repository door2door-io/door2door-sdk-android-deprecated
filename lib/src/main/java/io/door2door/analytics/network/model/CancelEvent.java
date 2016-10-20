package io.door2door.analytics.network.model;

/**
 * Network model for canceling events.
 */
public class CancelEvent extends BaseEvent {

    private static final String TYPE = "cancel";

    /**
     * Constructor.
     */
    public CancelEvent() {
        setType(TYPE);
    }

}
