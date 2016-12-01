package io.door2door.analytics;


import android.content.Context;

import io.door2door.analytics.api.model.InitializationParameters;
import io.door2door.analytics.base.Logger;
import io.door2door.analytics.base.dependency.BaseDependencyManager;
import io.door2door.analytics.interactor.MobilityAnalyticsInteractor;
import io.door2door.analytics.interactor.dependency.InteractorDependencyManager;
import io.door2door.analytics.mapper.dependency.MapperDependencyManager;
import io.door2door.analytics.network.dependency.NetworkDependencyManager;
import io.door2door.analytics.validator.dependency.ValidatorDependencyManager;

/**
 * A dependency manager. All the dependencies have singleton scope and are created lazily.
 */
public class DependencyManager {

    // initial dependencies
    private final Context context;
    private final InitializationParameters initializationParameters;

    // private dependencies
    private BaseDependencyManager baseDependencyManager;
    private MapperDependencyManager mapperDependencyManager;
    private NetworkDependencyManager networkDependencyManager;
    private ValidatorDependencyManager validatorDependencyManager;
    private InteractorDependencyManager interactorDependencyManager;

    /**
     * Instantiates a new Dependency manager.
     *
     * @param context                  the context
     * @param initializationParameters the initialization parameters
     */
    public DependencyManager(Context context, InitializationParameters initializationParameters) {
        this.context = context;
        this.initializationParameters = initializationParameters;
    }

    /**
     * Gets mobility analytics interactor.
     *
     * @return the mobility analytics interactor
     */
    public MobilityAnalyticsInteractor getMobilityAnalyticsInteractor() {
        return getInteractorDependencyManager().getMobilityAnalyticsInteractor();
    }

    /**
     * Gets logger.
     *
     * @return the logger
     */
    public Logger getLogger() {
        return getBaseDependencyManager().getLogger();
    }

    private NetworkDependencyManager getNetworkDependencyManager() {
        if (networkDependencyManager == null) {
            networkDependencyManager = new NetworkDependencyManager(
                    initializationParameters,
                    getMapperDependencyManager().getModelMapper(),
                    getBaseDependencyManager().getGson()
            );
        }
        return networkDependencyManager;
    }

    private BaseDependencyManager getBaseDependencyManager() {
        if (baseDependencyManager == null) {
            baseDependencyManager = new BaseDependencyManager(initializationParameters, context);
        }
        return baseDependencyManager;
    }

    private ValidatorDependencyManager getValidatorDependencyManager() {
        if (validatorDependencyManager == null) {
            validatorDependencyManager = new ValidatorDependencyManager();
        }
        return validatorDependencyManager;
    }

    private MapperDependencyManager getMapperDependencyManager() {
        if (mapperDependencyManager == null) {
            mapperDependencyManager = new MapperDependencyManager(
                    initializationParameters,
                    getBaseDependencyManager().getDeviceIdRetriever());
        }
        return mapperDependencyManager;
    }

    private InteractorDependencyManager getInteractorDependencyManager() {
        if (interactorDependencyManager == null) {
            interactorDependencyManager = new InteractorDependencyManager(
                    getNetworkDependencyManager().getHttpStack(),
                    getBaseDependencyManager().getLogger(),
                    getBaseDependencyManager().getBackgroundScheduler(),
                    getValidatorDependencyManager().getValidator());
        }
        return interactorDependencyManager;
    }
}
