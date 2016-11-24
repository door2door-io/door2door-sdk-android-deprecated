package io.door2door.analytics.validator;

import org.junit.Before;
import org.junit.Test;

import io.door2door.analytics.DummyModelsCreatorUtil;
import io.door2door.analytics.api.exception.ValidationException;
import io.door2door.analytics.api.model.SearchTripEvent;

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
        assertException(exception, "SearchTripEvent", "The root event object can't be null");
    }

    @Test
    public void shouldNotFailForValidObject() {
        // given
        SearchTripEvent event = DummyModelsCreatorUtil.getDummySearchTripEventBuilder()
                .build();

        // when
        validator.validate(event);

        // then no exception expected
    }

    @Test()
    public void shouldFailForNullDepartureLatitude() {
        // given
        SearchTripEvent event = DummyModelsCreatorUtil.getDummySearchTripEventBuilder()
                .setDepartureLatitude(null)
                .build();

        // when
        ValidationException exception = validate(event);

        // then
        assertException(exception, "SearchTripEvent.departureLatitude",
                "Latitude must not be null");
    }

    @Test()
    public void shouldFailForDepartureLatitudeBellowMinus90() {
        // given
        SearchTripEvent event = DummyModelsCreatorUtil.getDummySearchTripEventBuilder()
                .setDepartureLatitude(-100.123)
                .build();

        // when
        ValidationException exception = validate(event);

        // then
        assertException(exception, "SearchTripEvent.departureLatitude",
                "Latitude must not be bellow -90");
    }

    @Test()
    public void shouldFailForDepartureLatitudeAbove90() {
        // given
        SearchTripEvent event = DummyModelsCreatorUtil.getDummySearchTripEventBuilder()
                .setDepartureLatitude(100.123)
                .build();

        // when
        ValidationException exception = validate(event);

        // then
        assertException(exception, "SearchTripEvent.departureLatitude",
                "Latitude must not be above 90");
    }

    @Test
    public void shouldFailForNullDepartureLongitude() {
        // given
        SearchTripEvent event = DummyModelsCreatorUtil.getDummySearchTripEventBuilder()
                .setDepartureLongitude(null)
                .build();

        // when
        ValidationException exception = validate(event);

        // then
        assertException(exception, "SearchTripEvent.departureLongitude",
                "Longitude must not be null");
    }

    @Test
    public void shouldFailForDepartureLongitudeBellowMinus180() {
        // given
        SearchTripEvent event = DummyModelsCreatorUtil.getDummySearchTripEventBuilder()
                .setDepartureLongitude(-200.123)
                .build();

        // when
        ValidationException exception = validate(event);

        // then
        assertException(exception, "SearchTripEvent.departureLongitude",
                "Longitude must not be bellow -180");
    }

    @Test
    public void shouldFailForDepartureLongitudeAbove180() {
        // given
        SearchTripEvent event = DummyModelsCreatorUtil.getDummySearchTripEventBuilder()
                .setDepartureLongitude(200.123)
                .build();

        // when
        ValidationException exception = validate(event);

        // then
        assertException(exception, "SearchTripEvent.departureLongitude",
                "Longitude must not be above 180");
    }

    @Test
    public void shouldFailForNullArrivalLatitude() {
        // given
        SearchTripEvent event = DummyModelsCreatorUtil.getDummySearchTripEventBuilder()
                .setArrivalLatitude(null)
                .build();

        // when
        ValidationException exception = validate(event);

        // then
        assertException(exception, "SearchTripEvent.arrivalLatitude",
                "Latitude must not be null");
    }

    @Test()
    public void shouldFailForArrivalLatitudeBellowMinus90() {
        // given
        SearchTripEvent event = DummyModelsCreatorUtil.getDummySearchTripEventBuilder()
                .setArrivalLatitude(-100.123)
                .build();

        // when
        ValidationException exception = validate(event);

        // then
        assertException(exception, "SearchTripEvent.arrivalLatitude",
                "Latitude must not be bellow -90");
    }

    @Test()
    public void shouldFailForArrivalLatitudeAbove90() {
        // given
        SearchTripEvent event = DummyModelsCreatorUtil.getDummySearchTripEventBuilder()
                .setArrivalLatitude(100.123)
                .build();

        // when
        ValidationException exception = validate(event);

        // then
        assertException(exception, "SearchTripEvent.arrivalLatitude",
                "Latitude must not be above 90");
    }

    @Test
    public void shouldFailForNullArrivalLongitude() {
        // given
        SearchTripEvent event = DummyModelsCreatorUtil.getDummySearchTripEventBuilder()
                .setArrivalLongitude(null)
                .build();

        // when
        ValidationException exception = validate(event);

        // then
        assertException(exception, "SearchTripEvent.arrivalLongitude",
                "Longitude must not be null");
    }

    @Test
    public void shouldFailForArrivalLongitudeBellowMinus180() {
        // given
        SearchTripEvent event = DummyModelsCreatorUtil.getDummySearchTripEventBuilder()
                .setArrivalLongitude(-200.123)
                .build();

        // when
        ValidationException exception = validate(event);

        // then
        assertException(exception, "SearchTripEvent.arrivalLongitude",
                "Longitude must not be bellow -180");
    }

    @Test
    public void shouldFailForArrivalLongitudeAbove180() {
        // given
        SearchTripEvent event = DummyModelsCreatorUtil.getDummySearchTripEventBuilder()
                .setArrivalLongitude(200.123)
                .build();

        // when
        ValidationException exception = validate(event);

        // then
        assertException(exception, "SearchTripEvent.arrivalLongitude",
                "Longitude must not be above 180");
    }

    private ValidationException validate(SearchTripEvent event) {
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