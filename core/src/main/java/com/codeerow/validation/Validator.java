package com.codeerow.validation;

public class Validator {

    public static boolean allIsValid(Validation<?>... validations) {
        for (Validation<?> validation : validations) {
            if (!validation.isValid()) return false;
        }
        return true;
    }
}
