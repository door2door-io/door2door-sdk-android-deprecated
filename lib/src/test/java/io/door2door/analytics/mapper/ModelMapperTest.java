package io.door2door.analytics.mapper;

import org.junit.Before;
import org.junit.Test;

import io.door2door.analytics.base.model.Event;
import io.door2door.analytics.data.model.EventRequest;

import static org.assertj.core.api.Java6Assertions.assertThat;


/**
 * Test class for {@link ModelMapper}.
 */
public class ModelMapperTest {

    private ModelMapper modelMapper;

    @Before
    public void setUp() {
        modelMapper = new ModelMapper();
    }

    @Test
    public void shouldMapEventToEventRequest() {
        // given
        Event event = new Event();

        // when
        EventRequest eventRequest = modelMapper.mapEventToEventRequest(event);

        // then
        assertThat(eventRequest).isNotNull();
    }

}