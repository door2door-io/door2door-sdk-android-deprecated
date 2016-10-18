package io.door2door.analytics.interactor;

import io.door2door.analytics.network.HttpStack;
import io.door2door.analytics.base.model.Event;

/**
 * Interactor class for the mobility analytics.
 */
public class MobilityAnalyticsInteractor {

    private final HttpStack httpStack;

    /**
     * Constructor.
     *
     * @param httpStack the http stack to be used for sending the events.
     */
    public MobilityAnalyticsInteractor(HttpStack httpStack) {
        this.httpStack = httpStack;
    }

    /**
     * Sends the event to the backend.
     *
     * @param event the event to send.
     */
    public void sendEvent(Event event) {
        httpStack.sendEvent(event);
    }
}
