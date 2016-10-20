package io.door2door.analytics.interactor.dagger;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.door2door.analytics.interactor.MobilityAnalyticsInteractor;
import io.door2door.analytics.logger.Logger;
import io.door2door.analytics.network.HttpStack;
import rx.schedulers.Schedulers;

/**
 * Dagger module for providing the interactor dependencies.
 */
@Module
public class InteractorModule {

    /**
     * Dagger 2 provider method.
     *
     * @return the provided {@link MobilityAnalyticsInteractor}
     * @param httpStack the HTTP stack to be used by the interactor.
     * @param logger the logger.
     */
    @Provides
    @Singleton
    MobilityAnalyticsInteractor provideMobilityAnalyticsInteractor(HttpStack httpStack,
                                                                   Logger logger) {
        return new MobilityAnalyticsInteractor(httpStack, logger, Schedulers.io());
    }
}
