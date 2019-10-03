package com.codeerow.validation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Validator {
    private List<Validation<?>> validations;
    private List<Handler<Boolean>> handlers;


    public Validator(Validation<?>... validations) {
        this.validations = Arrays.asList(validations);
        handlers = new ArrayList<>();
    }

    public Validator(List<Validation<?>> validations, List<Handler<Boolean>> handlers) {
        this.validations = validations;
        this.handlers = handlers;
    }


    public boolean allIsValid() {
        boolean result = true;

        for (Validation<?> validation : validations) {
            boolean isValid = validation.validate();
            if (!isValid) result = false;
        }

        for (Handler<Boolean> handler : handlers) {
            handler.handle(result);
        }
        return result;
    }


    public static class Builder {
        private List<Validation<?>> validations = new ArrayList<>();
        private List<Handler<Boolean>> handlers = new ArrayList<>();


        public Builder addValidation(Validation<?> validation) {
            this.validations.add(validation);
            return this;
        }

        public Builder addHandler(Handler<Boolean> handler) {
            this.handlers.add(handler);
            return this;
        }

        public Validator build() {
            return new Validator(validations, handlers);
        }
    }
}
