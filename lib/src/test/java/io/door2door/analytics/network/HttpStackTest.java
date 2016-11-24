package io.door2door.analytics.network;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import io.door2door.analytics.api.model.SearchTripEvent;
import io.door2door.analytics.mapper.ModelMapper;
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
    private ModelMapper modelMapper;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        httpStack = new HttpStack(retrofitService, modelMapper);
    }

    @Test
    public void shouldSendEvent() {
        // given
        TripRequest tripRequest = new TripRequest();
        SearchTripEvent event = mock(SearchTripEvent.class);
        when(modelMapper.mapSearchTripEventToTripEventRequest(event)).thenReturn(tripRequest);

        // when
        httpStack.sendTripEvent(event);

        // then
        verify(retrofitService).postTripEvent(tripRequest);
    }

}