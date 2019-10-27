package com.codeerow.validation

import com.codeerow.validation
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
            validation(true) { true },
            validation(true) { true }
        )

        print(allIsValid)
    }
}
