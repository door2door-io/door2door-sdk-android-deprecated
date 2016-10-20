package io.door2door.analytics.mapper.dagger;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.door2door.analytics.mapper.ModelMapper;

/**
 * Dagger module for providing the mapper dependencies.
 */
@Module
public class MapperModule {

    /**
     * Dagger 2 provider method.
     *
     * @return the provided {@link ModelMapper}
     */
    @Provides
    @Singleton
    ModelMapper provideModelMapper() {
        return new ModelMapper();
    }
}
