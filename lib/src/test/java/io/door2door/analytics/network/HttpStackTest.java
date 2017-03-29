package io.door2door.analytics.network;

import io.door2door.analytics.api.model.InitializationParameters;
import io.door2door.analytics.network.mapper.NetworkModelMapper;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import io.door2door.analytics.api.model.SearchTripEvent;
import io.door2door.analytics.network.model.TripRequest;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Test class for {@link HttpStack}.
 */
public class HttpStackTest {

    private HttpStack httpStack;

    @Mock
    private RetrofitService retrofitService;
    @Mock
    private NetworkModelMapper networkModelMapper;
    @Mock
    private InitializationParameters initializationParameters;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        httpStack = new HttpStack(retrofitService, networkModelMapper, initializationParameters);
    }

    @Test
    public void shouldSendEvent() {
        // given
        TripRequest tripRequest = new TripRequest();
        String someKey = "de99a0adeefac13bbd23949b0ade7eea1cfcbc3a57e6d589bcbcc5be51da0a8f";
        SearchTripEvent event = mock(SearchTripEvent.class);
        when(networkModelMapper.mapSearchTripEventToTripEventRequest(event)).thenReturn(tripRequest);
        when(initializationParameters.getAuthorizationKey()).thenReturn(someKey);

        // when
        httpStack.sendTripEvent(event);

        // then
        verify(retrofitService).postTripEvent(String.format("Bearer %s", someKey), tripRequest);
    }

}