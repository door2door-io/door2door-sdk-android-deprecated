package io.door2door.analytics.base.dagger;


import javax.inject.Singleton;

import dagger.Component;
import io.door2door.analytics.base.MobilityAnalytics;

/**
 * Dagger component interface.
 */
@Singleton
@Component(modules = MobilityAnalyticsModule.class)
public interface MobilityAnalyticsComponent {

    /**
     * Dagger inject method for a given target.
     *
     * @param target the target
     */
    void inject(MobilityAnalytics target);
}
