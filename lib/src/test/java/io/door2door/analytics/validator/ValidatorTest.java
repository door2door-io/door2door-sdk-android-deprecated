package io.door2door.analytics.validator;

import org.junit.Before;
import org.junit.Test;

import io.door2door.analytics.DummyModelsCreatorUtil;
import io.door2door.analytics.api.exception.ValidationException;
import io.door2door.analytics.api.model.CreateTripEvent;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Test class for {@link Validator}.
 */
public class ValidatorTest {

    private Validator validator;

    @Before
    public void setUp() {
        validator = new Validator();
    }

    @Test
    public void shouldFailForNullEvent() {
        // given

        // when
        ValidationException exception = validate(null);

        // then
        assertException(exception, "CreateTripEvent", "The root event object can't be null");
    }

    @Test
    public void shouldNotFailForValidObject() {
        // given
        CreateTripEvent event = DummyModelsCreatorUtil.getDummyCreateTripEventBuilder()
                .build();

        // when
        validator.validate(event);

        // then no exception expected
    }

    @Test()
    public void shouldFailForNullOriginLatitude() {
        // given
        CreateTripEvent event = DummyModelsCreatorUtil.getDummyCreateTripEventBuilder()
                .setOriginLatitude(null)
                .build();

        // when
        ValidationException exception = validate(event);

        // then
        assertException(exception, "CreateTripEvent.originLatitude", "Latitude must not be null");
    }

    @Test()
    public void shouldFailForOriginLatitudeBellowMinus90() {
        // given
        CreateTripEvent event = DummyModelsCreatorUtil.getDummyCreateTripEventBuilder()
                .setOriginLatitude(-100.123)
                .build();

        // when
        ValidationException exception = validate(event);

        // then
        assertException(exception, "CreateTripEvent.originLatitude",
                "Latitude must not be bellow -90");
    }

    @Test()
    public void shouldFailForOriginLatitudeAbove90() {
        // given
        CreateTripEvent event = DummyModelsCreatorUtil.getDummyCreateTripEventBuilder()
                .setOriginLatitude(100.123)
                .build();

        // when
        ValidationException exception = validate(event);

        // then
        assertException(exception, "CreateTripEvent.originLatitude",
                "Latitude must not be above 90");
    }

    @Test
    public void shouldFailForNullOriginLongitude() {
        // given
        CreateTripEvent event = DummyModelsCreatorUtil.getDummyCreateTripEventBuilder()
                .setOriginLongitude(null)
                .build();

        // when
        ValidationException exception = validate(event);

        // then
        assertException(exception, "CreateTripEvent.originLongitude", "Longitude must not be null");
    }

    @Test
    public void shouldFailForOriginLongitudeBellowMinus180() {
        // given
        CreateTripEvent event = DummyModelsCreatorUtil.getDummyCreateTripEventBuilder()
                .setOriginLongitude(-200.123)
                .build();

        // when
        ValidationException exception = validate(event);

        // then
        assertException(exception, "CreateTripEvent.originLongitude",
                "Longitude must not be bellow -180");
    }

    @Test
    public void shouldFailForOriginLongitudeAbove180() {
        // given
        CreateTripEvent event = DummyModelsCreatorUtil.getDummyCreateTripEventBuilder()
                .setOriginLongitude(200.123)
                .build();

        // when
        ValidationException exception = validate(event);

        // then
        assertException(exception, "CreateTripEvent.originLongitude",
                "Longitude must not be above 180");
    }

    @Test
    public void shouldFailForNullDestinationLatitude() {
        // given
        CreateTripEvent event = DummyModelsCreatorUtil.getDummyCreateTripEventBuilder()
                .setDestinationLatitude(null)
                .build();

        // when
        ValidationException exception = validate(event);

        // then
        assertException(exception, "CreateTripEvent.destinationLatitude",
                "Latitude must not be null");
    }

    @Test()
    public void shouldFailForDestinationLatitudeBellowMinus90() {
        // given
        CreateTripEvent event = DummyModelsCreatorUtil.getDummyCreateTripEventBuilder()
                .setDestinationLatitude(-100.123)
                .build();

        // when
        ValidationException exception = validate(event);

        // then
        assertException(exception, "CreateTripEvent.destinationLatitude",
                "Latitude must not be bellow -90");
    }

    @Test()
    public void shouldFailForDestinationLatitudeAbove90() {
        // given
        CreateTripEvent event = DummyModelsCreatorUtil.getDummyCreateTripEventBuilder()
                .setDestinationLatitude(100.123)
                .build();

        // when
        ValidationException exception = validate(event);

        // then
        assertException(exception, "CreateTripEvent.destinationLatitude",
                "Latitude must not be above 90");
    }

    @Test
    public void shouldFailForNullDestinationLongitude() {
        // given
        CreateTripEvent event = DummyModelsCreatorUtil.getDummyCreateTripEventBuilder()
                .setDestinationLongitude(null)
                .build();

        // when
        ValidationException exception = validate(event);

        // then
        assertException(exception, "CreateTripEvent.destinationLongitude",
                "Longitude must not be null");
    }

    @Test
    public void shouldFailForDestinationLongitudeBellowMinus180() {
        // given
        CreateTripEvent event = DummyModelsCreatorUtil.getDummyCreateTripEventBuilder()
                .setDestinationLongitude(-200.123)
                .build();

        // when
        ValidationException exception = validate(event);

        // then
        assertException(exception, "CreateTripEvent.destinationLongitude",
                "Longitude must not be bellow -180");
    }

    @Test
    public void shouldFailForDestinationLongitudeAbove180() {
        // given
        CreateTripEvent event = DummyModelsCreatorUtil.getDummyCreateTripEventBuilder()
                .setDestinationLongitude(200.123)
                .build();

        // when
        ValidationException exception = validate(event);

        // then
        assertException(exception, "CreateTripEvent.destinationLongitude",
                "Longitude must not be above 180");
    }

    private ValidationException validate(CreateTripEvent event) {
        ValidationException exception = null;
        try {
            validator.validate(event);
        } catch (ValidationException e) {
            exception = e;
        }
        return exception;
    }

    private void assertException(ValidationException exception, String expected, String expected2) {
        assertThat(exception).isNotNull();
        assertThat(exception.getInvalidFieldName())
                .isEqualTo(expected);
        assertThat(exception.getMessage())
                .isEqualTo(expected2);
    }

}