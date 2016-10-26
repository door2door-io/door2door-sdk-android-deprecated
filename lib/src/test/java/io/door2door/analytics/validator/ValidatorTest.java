package io.door2door.analytics.validator;

import org.junit.Before;
import org.junit.Test;

import io.door2door.analytics.api.exception.ValidationException;
import io.door2door.analytics.api.model.CreateTripEvent;

import static org.mockito.Mockito.mock;

/**
 * Test class for {@link Validator}.
 */
public class ValidatorTest {

    private Validator validator;

    @Before
    public void setUp() {
        validator = new Validator();
    }

    @Test(expected = ValidationException.class)
    public void shouldFailForNullEvent() {
        // given
        CreateTripEvent event = null;

        // when
        validator.validate(event);

        // then exception expected
    }

    @Test
    public void shouldNotFailForValidObject() {
        // given
        CreateTripEvent event = mock(CreateTripEvent.class);

        // when
        validator.validate(event);

        // then no exception expected
    }

}