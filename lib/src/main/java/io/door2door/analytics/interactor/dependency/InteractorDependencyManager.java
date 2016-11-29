package io.door2door.analytics.interactor.dependency;

import io.door2door.analytics.base.Logger;
import io.door2door.analytics.interactor.MobilityAnalyticsInteractor;
import io.door2door.analytics.network.HttpStack;
import io.door2door.analytics.validator.Validator;
import rx.Scheduler;

/**
 * The type Interactor dependency manager.
 */
public class InteractorDependencyManager {

    // external dependencies
    private final HttpStack httpStack;
    private final Logger logger;
    private final Scheduler backgroundScheduler;
    private final Validator validator;

    // public dependencies
    private MobilityAnalyticsInteractor mobilityAnalyticsInteractor;

    /**
     * Instantiates a new Interactor dependency manager.
     *
     * @param httpStack           the http stack
     * @param logger              the logger
     * @param backgroundScheduler the background scheduler
     * @param validator           the validator
     */
    public InteractorDependencyManager(HttpStack httpStack, Logger logger,
                                       Scheduler backgroundScheduler, Validator validator) {
        this.httpStack = httpStack;
        this.logger = logger;
        this.backgroundScheduler = backgroundScheduler;
        this.validator = validator;
    }


    /**
     * Gets mobility analytics interactor.
     *
     * @return the mobility analytics interactor
     */
    public MobilityAnalyticsInteractor getMobilityAnalyticsInteractor() {
        if (mobilityAnalyticsInteractor == null) {
            mobilityAnalyticsInteractor = new MobilityAnalyticsInteractor(httpStack, logger,
                    backgroundScheduler, validator);
        }
        return mobilityAnalyticsInteractor;
    }
}
