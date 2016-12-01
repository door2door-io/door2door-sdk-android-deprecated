package io.door2door.analytics.api;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;

import io.door2door.analytics.base.DependencyManager;
import io.door2door.analytics.api.model.SearchTripEvent;
import io.door2door.analytics.base.Logger;
import io.door2door.analytics.interactor.MobilityAnalyticsInteractor;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Test class for {@link MobilityAnalytics}.
 */
public class MobilityAnalyticsTest {

    private MobilityAnalytics mobilityAnalytics;

    @Mock
    private DependencyManager dependencyManager;
    @Mock
    private MobilityAnalyticsInteractor mobilityAnalyticsInteractor;
    @Mock
    private Logger logger;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mobilityAnalytics = new MobilityAnalytics(null, null);
        ReflectionTestUtils.setField(mobilityAnalytics, "dependencyManager", dependencyManager);
        when(dependencyManager.getLogger()).thenReturn(logger);
        when(dependencyManager.getMobilityAnalyticsInteractor())
                .thenReturn(mobilityAnalyticsInteractor);
    }

    @Test
    public void shouldRecordEvent() {
        // given
        SearchTripEvent event = mock(SearchTripEvent.class);

        // when
        mobilityAnalytics.recordEvent(event);

        // then
        verify(mobilityAnalyticsInteractor).processTripEvent(event);
        verify(logger).d("MobilityAnalytics", "Search trip event about to be recorded");
    }

}