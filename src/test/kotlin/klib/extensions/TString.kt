package klib.extensions

import kotlin.test.assertFailsWith
import kotlin.test.assertTrue
import org.junit.Test

class TString {
    @Test
    fun deny() {
        assertFailsWith(klib.exceptions.InvalidValueException::class) {
            "This is a very invalid test string containing a §" deny "§"
        }

        assertTrue {
            "This is a very valid test string containing no .." deny "§"
            true
        }
    }

    @Test
    fun require() {
        assertFailsWith(klib.exceptions.RequireValueException::class) {
            "This is a very invalid test string containing no .." require "§"
        }

        assertTrue {
            "This is a very valid test string containing a §" require "§"
            true
        }
    }

    @Test
    fun asSha256() {
        assert("This is a test string for sha".asSha256() == "b1c5fff05aa05fcd7e0602215a3148b5d18ed0fdd46bbf02d7f6faaf70559b9d")
    }
}
