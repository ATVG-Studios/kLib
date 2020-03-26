package klib.functions

import kotlin.test.assertFalse
import org.junit.Test

class Failable {
    @Test
    fun requireOrFail() {
        requireOrFail("Not NUll") {
            assertFalse { true }
        }

        requireOrFail(null) {
            assert(true)
        }
    }

    @Test
    fun requireAllOrFail() {
        requireAllOrFail("Not Null", "Not Null either") {
            assertFalse { true }
        }

        requireAllOrFail("Not NUll", null, "But this is not null") {
            assert(true)
        }
    }
}
