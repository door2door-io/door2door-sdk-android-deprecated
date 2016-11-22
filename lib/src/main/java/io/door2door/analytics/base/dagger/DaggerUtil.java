package io.door2door.analytics.base.dagger;

import android.content.Context;

import io.door2door.analytics.api.MobilityAnalytics;
import io.door2door.analytics.api.model.InitializationParameters;
import io.door2door.analytics.interactor.dagger.InteractorModule;
import io.door2door.analytics.base.logger.dagger.LoggerModule;
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
     * @param context the context
     * @param initializationParameters the initialization parameters for the dagger component.
     */
    public static void injectInMobilityAnalytics(MobilityAnalytics target, Context context,
                                           InitializationParameters initializationParameters) {
        DaggerMobilityAnalyticsComponent.builder()
                .baseModule(new BaseModule(context, initializationParameters))
                .interactorModule(new InteractorModule())
                .loggerModule(new LoggerModule())
                .mapperModule(new MapperModule())
                .networkModule(new NetworkModule())
                .build()
                .inject(target);
    }
}
