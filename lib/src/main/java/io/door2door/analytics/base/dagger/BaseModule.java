package io.door2door.analytics.base.dagger;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.door2door.analytics.api.model.InitializationParameters;
import io.door2door.analytics.base.DateFormattingHelper;

/**
 * Dagger module for providing the base dependencies.
 */
@Module
public class BaseModule {

    private final InitializationParameters initializationParameters;

    /**
     * Constructor.
     * @param initializationParameters the initialization parameters.
     */
    public BaseModule(InitializationParameters initializationParameters) {
        this.initializationParameters = initializationParameters;
    }

    /**
     * Dagger 2 provider method.
     *
     * @return the provided {@link InitializationParameters}
     */
    @Provides
    @Singleton
    InitializationParameters provideInitializationParameters() {
        return initializationParameters;
    }

    /**
     * Dagger 2 provider method.
     *
     * @return the provided {@link DateFormattingHelper}
     */
    @Provides
    @Singleton
    DateFormattingHelper provideDateFormattingHelper() {
        return new DateFormattingHelper();
    }
}
