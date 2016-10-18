package io.door2door.analytics.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import io.door2door.analytics.api.model.Event;
import io.door2door.analytics.api.model.InitializationParameters;
import io.door2door.analytics.interactor.MobilityAnalyticsInteractor;
import io.door2door.analytics.logger.Logger;

import static org.mockito.Mockito.verify;

/**
 * Test class for {@link MobilityAnalytics}.
 */
public class MobilityAnalyticsTest {

    private MobilityAnalytics mobilityAnalytics;

    @Mock
    private MobilityAnalyticsInteractor mobilityAnalyticsInteractor;
    @Mock
    private Logger logger;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mobilityAnalytics = new TestMobilityAnalytics(null);
    }

    @Test
    public void shouldRecordEvent() {
        // given
        Event event = new Event();

        // when
        mobilityAnalytics.recordEvent(event);

        // then
        verify(mobilityAnalyticsInteractor).sendEvent(event);
    }

    /**
     * MobilityAnalytics class with injected test dependencies.
     */
    private class TestMobilityAnalytics extends MobilityAnalytics {

        /**
         * Constructor.
         *
         * @param initializationParameters a wrapper object for all the parameters that can be set
         *                                 to the SDK.
         */
        TestMobilityAnalytics(InitializationParameters initializationParameters) {
            super(initializationParameters);
        }

        @Override
        protected void injectDependencies(InitializationParameters initializationParameters) {
            mobilityAnalyticsInteractor = MobilityAnalyticsTest.this.mobilityAnalyticsInteractor;
            logger = MobilityAnalyticsTest.this.logger;
        }
    }

}