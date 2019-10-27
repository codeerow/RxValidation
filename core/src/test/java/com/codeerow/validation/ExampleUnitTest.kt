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
        val allIsValid = Validator.allIsValid(
            Validation.Builder(1)
                .addRule { _ -> true }
                .build(),
            Validation.Builder(true)
                .addRule { _ -> true }
                .build()
        )

        print(allIsValid)
    }
}
