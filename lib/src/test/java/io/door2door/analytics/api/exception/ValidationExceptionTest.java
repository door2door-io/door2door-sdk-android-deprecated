package io.door2door.analytics.api.exception;

import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Test class for {@code ValidationException}.
 */
public class ValidationExceptionTest {

    @Test
    public void shouldGetInvalidFieldFromException() {
        // given
        String invalidFieldName = "some field";

        // when
        ValidationException validationException = new ValidationException(invalidFieldName, null);

        // then
        assertThat(validationException.getInvalidFieldName()).isEqualTo(invalidFieldName);
    }

    @Test
    public void shouldGetMessageException() {
        // given
        String message = "some message";

        // when
        ValidationException validationException = new ValidationException(null, message);

        // then
        assertThat(validationException.getMessage()).isEqualTo(message);
    }

}