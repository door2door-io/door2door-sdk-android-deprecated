package io.door2door.analytics.interactor;

import io.door2door.analytics.api.model.SearchTripEvent;
import io.door2door.analytics.base.logger.Logger;
import io.door2door.analytics.network.HttpStack;
import io.door2door.analytics.validator.Validator;
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
    private final Validator validator;

    /**
     * Constructor.
     *
     * @param httpStack           the http stack to be used for sending the events.
     * @param logger              the logger for logging.
     * @param backgroundScheduler the rx scheduler for executing on a background thread.
     * @param validator           the validator
     */
    public MobilityAnalyticsInteractor(HttpStack httpStack, Logger logger,
                                       Scheduler backgroundScheduler, Validator validator) {
        this.httpStack = httpStack;
        this.logger = logger;
        this.backgroundScheduler = backgroundScheduler;
        this.validator = validator;
    }

    /**
     * Processes the event.
     *
     * @param event the event
     */
    public void processTripEvent(SearchTripEvent event) {
        validator.validate(event);

        httpStack.sendTripEvent(event)
                .subscribeOn(backgroundScheduler)
                .subscribe(new Action1<Void>() {
                    @Override
                    public void call(Void baseResponse) {
                        logger.d(TAG, "Event was recorded successfully");
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        logger.e(TAG, "Event was not recorded successfully", throwable);
                    }
                });
    }
}
