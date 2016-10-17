package io.door2door.analytics.base;


import javax.inject.Inject;

import io.door2door.analytics.base.model.Event;
import io.door2door.analytics.base.model.InitializationParameters;
import io.door2door.analytics.base.dagger.DaggerMobilityAnalyticsComponent;
import io.door2door.analytics.base.dagger.MobilityAnalyticsModule;
import io.door2door.analytics.interactor.MobilityAnalyticsInteractor;
import io.door2door.analytics.logger.Logger;


/**
 * Class responsible interaction by the integrators of the SDK.
 */
public class MobilityAnalytics {

    @Inject
    MobilityAnalyticsInteractor mobilityAnalyticsInteractor;
    @Inject
    Logger logger;

    /**
     * Constructor.
     *
     * @param initializationParameters a wrapper object for all the parameters that can be set to
     *                                 the SDK.
     */
    public MobilityAnalytics(InitializationParameters initializationParameters) {
        injectDependencies(initializationParameters);
    }

    /**
     * Inject dependencies.
     * @param initializationParameters the initializations parameters to be used by the
     *                                 dependencies.
     */
    protected void injectDependencies(InitializationParameters initializationParameters) {
        MobilityAnalyticsModule mobilityAnalyticsModule = new MobilityAnalyticsModule();
        mobilityAnalyticsModule.setInitializationParameters(initializationParameters);
        DaggerMobilityAnalyticsComponent.builder()
                .mobilityAnalyticsModule(mobilityAnalyticsModule)
                .build()
                .inject(this);
    }

    /**
     * Records an event.
     *
     * @param event the event to be recorded.
     */
    public void recordEvent(Event event) {
        mobilityAnalyticsInteractor.sendEvent(event);
    }
}
