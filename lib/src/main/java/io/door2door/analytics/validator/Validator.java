package io.door2door.analytics.validator;

import io.door2door.analytics.api.exception.ValidationException;
import io.door2door.analytics.api.model.SearchTripEvent;

/**
 * Class responsible for checking the validity of the models.
 */
public class Validator {

    /**
     * Checks if a given model is valid and throws an exception if it is not.
     *
     * @param event the model to validate.
     * @throws ValidationException in case the validation fails.
     */
    public void validate(SearchTripEvent event) throws ValidationException {
        String className = SearchTripEvent.class.getSimpleName();
        if (event == null) {
            throw new ValidationException(className, "The root event object can't be null");
        }

        validateLatitude(event.getDepartureLatitude(),
                getFieldPath(className, "departureLatitude"));
        validateLongitude(event.getDepartureLongitude(),
                getFieldPath(className, "departureLongitude"));
        validateLatitude(event.getArrivalLatitude(),
                getFieldPath(className, "arrivalLatitude"));
        validateLongitude(event.getArrivalLongitude(),
                getFieldPath(className, "arrivalLongitude"));
    }

    private String getFieldPath(String className, String fieldName) {
        return String.format("%s.%s", className, fieldName);
    }

    private void validateLatitude(Double latitude, String fieldName) {
        if (latitude == null) {
            throw new ValidationException(fieldName, "Latitude must not be null");
        }

        if (latitude < -90) {
            throw new ValidationException(fieldName, "Latitude must not be bellow -90");
        }

        if (latitude > 90) {
            throw new ValidationException(fieldName, "Latitude must not be above 90");
        }
    }

    private void validateLongitude(Double longitude, String fieldName) {
        if (longitude == null) {
            throw new ValidationException(fieldName, "Longitude must not be null");
        }

        if (longitude < -180) {
            throw new ValidationException(fieldName, "Longitude must not be bellow -180");
        }

        if (longitude > 180) {
            throw new ValidationException(fieldName, "Longitude must not be above 180");
        }
    }
}
