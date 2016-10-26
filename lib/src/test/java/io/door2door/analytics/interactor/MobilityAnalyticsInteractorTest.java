package io.door2door.analytics.interactor;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import io.door2door.analytics.api.model.CreateTripEvent;
import io.door2door.analytics.logger.Logger;
import io.door2door.analytics.network.HttpStack;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Test class for {@link MobilityAnalyticsInteractor}.
 */
@RunWith(RobolectricTestRunner.class)
@Config(sdk = 23)
public class MobilityAnalyticsInteractorTest {

    private MobilityAnalyticsInteractor mobilityAnalyticsInteractor;

    @Mock
    private HttpStack httpStack;
    @Mock
    private Logger logger;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mobilityAnalyticsInteractor = new MobilityAnalyticsInteractor(httpStack, logger,
                AndroidSchedulers.mainThread());
    }

    @Test
    public void shouldSendEvent() {
        // given
        CreateTripEvent event = mock(CreateTripEvent.class);
        when(httpStack.sendTripEvent(event)).thenReturn(Observable.<Void>just(null));

        // when
        mobilityAnalyticsInteractor.sendTripEvent(event);

        // then
        verify(httpStack).sendTripEvent(event);
        verify(logger).d("MobilityAnalyticsInteractor",
                "Event was sent to the backend successfully");
    }

    @Test
    public void shouldHandleErrorWhileSendingEvent() {
        // given
        CreateTripEvent event = mock(CreateTripEvent.class);
        RuntimeException exception = new RuntimeException();
        when(httpStack.sendTripEvent(event)).thenReturn(Observable.<Void>error(exception));

        // when
        mobilityAnalyticsInteractor.sendTripEvent(event);

        // then
        verify(httpStack).sendTripEvent(event);
        verify(logger).e("MobilityAnalyticsInteractor",
                "Event was not sent to the backend successfully", exception);
    }

}