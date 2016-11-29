package io.door2door.analytics.interactor;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import io.door2door.analytics.api.model.SearchTripEvent;
import io.door2door.analytics.base.Logger;
import io.door2door.analytics.network.HttpStack;
import io.door2door.analytics.validator.Validator;
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
    private Validator validator;
    @Mock
    private Logger logger;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        mobilityAnalyticsInteractor = new MobilityAnalyticsInteractor(httpStack, logger,
                AndroidSchedulers.mainThread(), validator);
    }

    @Test
    public void shouldSendEvent() {
        // given
        SearchTripEvent event = mock(SearchTripEvent.class);
        when(httpStack.sendTripEvent(event)).thenReturn(Observable.<Void>just(null));

        // when
        mobilityAnalyticsInteractor.processTripEvent(event);

        // then
        verify(httpStack).sendTripEvent(event);
        verify(validator).validate(event);
        verify(logger).d("MobilityAnalyticsInteractor", "Event was recorded successfully");
    }

    @Test
    public void shouldHandleErrorWhileSendingEvent() {
        // given
        SearchTripEvent event = mock(SearchTripEvent.class);
        RuntimeException exception = new RuntimeException();
        when(httpStack.sendTripEvent(event)).thenReturn(Observable.<Void>error(exception));

        // when
        mobilityAnalyticsInteractor.processTripEvent(event);

        // then
        verify(httpStack).sendTripEvent(event);
        verify(logger).e("MobilityAnalyticsInteractor", "Event was not recorded successfully",
                exception);
    }

}