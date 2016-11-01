package io.door2door.analytics.base.dagger;


import javax.inject.Singleton;

import dagger.Component;
import io.door2door.analytics.api.MobilityAnalytics;
import io.door2door.analytics.interactor.dagger.InteractorModule;
import io.door2door.analytics.logger.dagger.LoggerModule;
import io.door2door.analytics.mapper.dagger.MapperModule;
import io.door2door.analytics.network.dagger.NetworkModule;
import io.door2door.analytics.validator.dagger.ValidatorModule;

/**
 * Dagger component interface.
 */
@Singleton
@Component(modules = {
        BaseModule.class,
        InteractorModule.class,
        LoggerModule.class,
        MapperModule.class,
        NetworkModule.class,
        ValidatorModule.class
})
public interface MobilityAnalyticsComponent {

    /**
     * Dagger inject method for a given target.
     *
     * @param target the target
     */
    void inject(MobilityAnalytics target);
}
