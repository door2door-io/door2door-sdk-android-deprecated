package io.door2door.analytics.data;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import io.door2door.analytics.base.model.Event;
import io.door2door.analytics.data.model.EventRequest;
import io.door2door.analytics.mapper.ModelMapper;

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
        Event event = new Event();
        EventRequest eventRequest = new EventRequest();
        when(modelMapper.mapEventToEventRequest(event)).thenReturn(eventRequest);

        // when
        httpStack.sendEvent(event);

        // then
        verify(retrofitService).postEvent(null, eventRequest);
    }

}