package io.door2door.analytics.interactor;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import io.door2door.analytics.base.model.Event;
import io.door2door.analytics.data.HttpStack;

import static org.mockito.Mockito.verify;

/**
 * Test class for {@link MobilityAnalyticsInteractor}.
 */
public class MobilityAnalyticsInteractorTest {

    private MobilityAnalyticsInteractor mobilityAnalyticsInteractor;

    @Mock
    private HttpStack httpStack;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mobilityAnalyticsInteractor = new MobilityAnalyticsInteractor(httpStack);
    }

    @Test
    public void shouldSendEvent() {
        // given
        Event event = new Event();

        // when
        mobilityAnalyticsInteractor.sendEvent(event);

        // then
        verify(httpStack).sendEvent(event);
    }

}