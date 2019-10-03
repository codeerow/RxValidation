package com.codeerow.validation;

interface Rule<S> {
    boolean execute(S subject);
}
