package io.door2door.analytics.validator.dagger;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.door2door.analytics.validator.Validator;

/**
 * Dagger module for providing the validator dependencies.
 */
@Module
public class ValidatorModule {

    /**
     * Dagger 2 provider method.
     *
     * @return the provided {@link Validator}
     */
    @Provides
    @Singleton
    Validator provideValidator() {
        return new Validator();
    }
}
