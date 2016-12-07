package io.door2door.analytics.validator.dependency;

import io.door2door.analytics.validator.Validator;

/**
 * The type Validator dependency manager.
 */
public class ValidatorDependencyManager {

    private Validator validator;

    /**
     * Gets validator.
     *
     * @return the validator
     */
    public Validator getValidator() {
        if (validator == null) {
            validator = new Validator();
        }
        return validator;
    }
}
