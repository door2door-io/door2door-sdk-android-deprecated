package io.door2door.analytics.interactor;

import io.door2door.analytics.api.model.Event;
import io.door2door.analytics.logger.Logger;
import io.door2door.analytics.network.HttpStack;
import rx.Scheduler;
import rx.functions.Action1;

/**
 * Interactor class for the mobility analytics.
 */
public class MobilityAnalyticsInteractor {

    private static final String TAG = MobilityAnalyticsInteractor.class.getSimpleName();

    private final HttpStack httpStack;
    private final Logger logger;
    private final Scheduler backgroundScheduler;

    /**
     * Constructor.
     * @param httpStack the http stack to be used for sending the events.
     * @param logger the logger for logging.
     * @param backgroundScheduler the rx scheduler for executing on a background thread.
     */
    public MobilityAnalyticsInteractor(HttpStack httpStack, Logger logger,
                                       Scheduler backgroundScheduler) {
        this.httpStack = httpStack;
        this.logger = logger;
        this.backgroundScheduler = backgroundScheduler;
    }

    /**
     * Sends the event to the backend.
     *
     * @param event the event to send.
     */
    public void sendEvent(Event event) {
        // TODO 2016-10-18 zlatko: validate the event
        httpStack.sendEvent(event)
                .subscribeOn(backgroundScheduler)
                .subscribe(new Action1<Void>() {
            @Override
            public void call(Void baseResponse) {
                logger.d(TAG, "Event was sent to the backend successfully");
            }
        }, new Action1<Throwable>() {
            @Override
            public void call(Throwable throwable) {
                logger.e(TAG, "Event was not sent to the backend successfully", throwable);
            }
        });
    }
}
