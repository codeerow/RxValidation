package com.codeerow.`validation-ktx`

import com.codeerow.validation.Validation


fun <S> validation(subject: S, vararg rules: (S) -> Boolean): Validation<S> {
    val builder = Validation.Builder(subject)
    rules.forEach { rule -> builder.addRule(rule) }
    return builder.build()
}