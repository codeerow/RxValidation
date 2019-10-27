package com.codeerow.validation


fun <S> validation(subject: S, vararg rules: (S) -> Boolean): Validation<S> {
    val builder = Validation.Builder(subject)
    rules.forEach { rule -> builder.addRule(rule) }
    return builder.build()
}