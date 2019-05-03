package klib.functions

import com.atvgstudios.klib.functions.requireAllOrFail
import com.atvgstudios.klib.functions.requireOrFail
import org.junit.Test
import kotlin.test.assertFalse

class Failable {
    @Test
    fun requireOrFail() {
        requireOrFail("Not NUll") {
            assertFalse { true}
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