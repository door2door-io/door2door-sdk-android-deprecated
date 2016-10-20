package io.door2door.analytics.validator;

import org.junit.Before;
import org.junit.Test;

import io.door2door.analytics.api.exception.ValidationException;
import io.door2door.analytics.api.model.Event;

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
        Event event = null;

        // when
        validator.validate(event);

        // then exception expected
    }

    @Test
    public void shouldNotFailForValidObject() {
        // given
        Event event = new Event();

        // when
        validator.validate(event);

        // then no exception expected
    }

}