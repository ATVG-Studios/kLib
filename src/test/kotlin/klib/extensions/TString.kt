package klib.extensions

import com.atvgstudios.klib.exceptions.InvalidValueException
import com.atvgstudios.klib.exceptions.RequireValueException
import com.atvgstudios.klib.extensions.asSha256
import com.atvgstudios.klib.extensions.deny
import com.atvgstudios.klib.extensions.require
import org.junit.Test
import kotlin.test.assertFailsWith
import kotlin.test.assertTrue

class TString {
    @Test
    fun deny(){
        assertFailsWith(InvalidValueException::class) {
            "This is a very invalid test string containing a §" deny "§"
        }

        assertTrue {
            "This is a very valid test string containing no .." deny "§"
            true
        }
    }

    @Test
    fun require(){
        assertFailsWith(RequireValueException::class) {
            "This is a very invalid test string containing no .." require "§"
        }

        assertTrue {
            "This is a very valid test string containing a §" require "§"
            true
        }
    }

    @Test
    fun asSha256(){
        assert("This is a test string for sha".asSha256() == "b1c5fff05aa05fcd7e0602215a3148b5d18ed0fdd46bbf02d7f6faaf70559b9d")
    }
}