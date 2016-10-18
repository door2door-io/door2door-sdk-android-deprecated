package io.door2door.analytics.base.dagger;

import io.door2door.analytics.api.MobilityAnalytics;
import io.door2door.analytics.api.model.InitializationParameters;
import io.door2door.analytics.interactor.dagger.InteractorModule;
import io.door2door.analytics.logger.dagger.LoggerModule;
import io.door2door.analytics.mapper.dagger.MapperModule;
import io.door2door.analytics.network.dagger.NetworkModule;

/**
 * Util class for preparing dagger components and injecting dependencies.
 */
public final class DaggerUtil {

    private DaggerUtil() {
        // hide the constructor since this is a util class
    }

    /**
     * Prepares dagger component and injects dependencies.
     * @param target the target for injecting the dependencies.
     * @param initializationParameters the initialization parameters for the dagger component.
     */
    public static void injectInMobilityAnalytics(MobilityAnalytics target,
                                           InitializationParameters initializationParameters) {
        DaggerMobilityAnalyticsComponent.builder()
                .baseModule(new BaseModule(initializationParameters))
                .interactorModule(new InteractorModule())
                .loggerModule(new LoggerModule())
                .mapperModule(new MapperModule())
                .networkModule(new NetworkModule())
                .build()
                .inject(target);
    }
}
