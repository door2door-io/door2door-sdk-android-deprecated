package io.door2door.analytics.mapper.dagger;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.door2door.analytics.api.model.InitializationParameters;
import io.door2door.analytics.mapper.ModelMapper;

/**
 * Dagger module for providing the mapper dependencies.
 */
@Module
public class MapperModule {

    /**
     * Dagger 2 provider method.
     *
     * @param initializationParameters the initialization parameters
     * @return the provided {@link ModelMapper}
     */
    @Provides
    @Singleton
    ModelMapper provideModelMapper(InitializationParameters initializationParameters) {
        return new ModelMapper(initializationParameters);
    }
}
