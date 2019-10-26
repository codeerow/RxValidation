package com.codeerow.validation;

public interface Rule<S> {
    boolean execute(S subject);
}
