package io.door2door.analytics.api.exception;

/**
 * A runtime exception that can be thrown if validation fails.
 */
public class ValidationException extends RuntimeException {

    private final String invalidFieldName;

    /**
     * Constructor.
     *
     * @param invalidFieldName the name of the invalid field.
     * @param message          the exception message.
     */
    public ValidationException(String invalidFieldName, String message) {
        super(message);
        this.invalidFieldName = invalidFieldName;
    }

    /**
     * @return the invalid field name.
     */
    public String getInvalidFieldName() {
        return invalidFieldName;
    }
}
