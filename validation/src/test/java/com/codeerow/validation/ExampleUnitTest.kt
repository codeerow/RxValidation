package com.codeerow.validation

import org.junit.Test

/**
 * Validation local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {


    @Test
    fun addition_isCorrect() {
        val validator = Validator.Builder()
            .addValidation(Validation.Builder { true }
                .addRule { _ -> true }
                .addHandler { }
                .build()
            )
            .build()

        validator.allIsValid()
    }
}
