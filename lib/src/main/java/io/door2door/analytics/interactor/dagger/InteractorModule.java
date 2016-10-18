package io.door2door.analytics.interactor.dagger;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.door2door.analytics.interactor.MobilityAnalyticsInteractor;
import io.door2door.analytics.network.HttpStack;

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
     */
    @Provides
    @Singleton
    public MobilityAnalyticsInteractor provideMobilityAnalyticsInteractor(HttpStack httpStack) {
        return new MobilityAnalyticsInteractor(httpStack);
    }
}
