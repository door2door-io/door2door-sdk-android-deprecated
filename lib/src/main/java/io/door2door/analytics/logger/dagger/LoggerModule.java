package io.door2door.analytics.logger.dagger;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.door2door.analytics.api.model.InitializationParameters;
import io.door2door.analytics.interactor.MobilityAnalyticsInteractor;
import io.door2door.analytics.logger.Logger;

/**
 * Dagger module for providing the logger dependencies.
 */
@Module
public class LoggerModule {

    /**
     * Dagger 2 provider method.
     * @param initializationParameters the initialization parameters.
     *
     * @return the provided {@link MobilityAnalyticsInteractor}
     */
    @Provides
    @Singleton
    Logger provideLogger(InitializationParameters initializationParameters) {
        return new Logger(initializationParameters.isLoggerEnabled());
    }
}
