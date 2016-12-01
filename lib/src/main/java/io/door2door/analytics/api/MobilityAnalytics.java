package io.door2door.analytics.api;


import android.content.Context;

import io.door2door.analytics.api.exception.ValidationException;
import io.door2door.analytics.api.model.InitializationParameters;
import io.door2door.analytics.api.model.SearchTripEvent;
import io.door2door.analytics.base.DependencyManager;

/**
 * Class responsible interaction by the integrators of the SDK.
 */
public class MobilityAnalytics {

    private static final String TAG = MobilityAnalytics.class.getSimpleName();

    private final DependencyManager dependencyManager;

    /**
     * Constructor.
     *
     * @param context the context
     * @param initializationParameters a wrapper object for all the parameters that can be set to
     *                                 the SDK.
     */
    public MobilityAnalytics(Context context, InitializationParameters initializationParameters) {
        dependencyManager = new DependencyManager(context, initializationParameters);
    }

    /**
     * Records an event.
     *
     * @param event the event to be recorded.
     * @throws ValidationException if the sent event is not valid.
     */
    public void recordEvent(SearchTripEvent event) throws ValidationException {
        dependencyManager.getLogger().d(TAG, "Search trip event about to be recorded");
        dependencyManager.getMobilityAnalyticsInteractor().processTripEvent(event);
    }
}
