/*
 * This file belongs to the source code of: kLib
 *
 * Copyright© 2015-2021 Thomas Obernosterer, ATVG-Studios
 * Copyright© 2019-2021 all kLib Contributors
 *
 * This Source Code Form is subject to the terms of the Mozilla Public License, v. 2.0.
 * If a copy of the MPL was not distributed with this file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package klib.extensions

import klib.exceptions.InvalidValueException
import klib.exceptions.RequireValueException
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertTrue

class TString {
    @Test
    fun deny() {
        assertFailsWith(InvalidValueException::class) {
            "This is a very invalid test string containing a §" deny "§"
        }

        assertTrue {
            "This is a very valid test string containing no .." deny "§"
            true
        }
    }

    @Test
    fun require() {
        assertFailsWith(RequireValueException::class) {
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

    @Test
    fun `toUpperCaseOnUnderscore replaces underscores correctly`() {
        assertEquals("Word word W", "word word_w".toUpperCaseOnUnderscore())

        assertEquals(
            "This Is a Small Test to See if It works",
            "this_is a_small_test to_see if_it works".toUpperCaseOnUnderscore()
        )

        assertEquals(
            "This*Is a*Small*Test to*See if*It works",
            "this_is a_small_test to_see if_it works".toUpperCaseOnUnderscore("*")
        )
    }
}
