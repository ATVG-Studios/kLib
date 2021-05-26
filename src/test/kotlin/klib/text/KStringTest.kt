/*
 * This file belongs to the source code of: kLib
 *
 * Copyright© 2015-2021 Thomas Obernosterer, ATVG-Studios
 * Copyright© 2019-2021 all kLib Contributors
 *
 * This Source Code Form is subject to the terms of the Mozilla Public License, v. 2.0.
 * If a copy of the MPL was not distributed with this file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package klib.text

import klib.functions.kstring
import org.junit.Test
import kotlin.test.assertEquals

class KStringTest {
    @Test
    fun `Build String 1`() {
        val wantedString = "Hello!\nHow are you doing?\nAny news?"

        val buildString = kstring {
            line("Hello!")
            line("How are you doing?")
            text("Any news?")
        }

        assertEquals(wantedString, buildString)
    }

    @Test
    fun `Build String 2`() {
        val wantedString = "Hello!\nHow are you doing?\nAny news?"

        val stringBuilder = KString()

        stringBuilder + "Hello!"
        stringBuilder + '\n'

        stringBuilder += "How are you doing?"
        stringBuilder += '\n'
        stringBuilder += "Any news?"

        assertEquals(wantedString, stringBuilder.toString())
    }

    @Test
    fun `Build String 3`() {
        val wantedString = "Hello!\nHow are you doing?\nAny news?"

        val buildString = kstring {
            + "Hello!"
            + '\n'

            line("How are you doing?")
            text("Any news?")
        }

        assertEquals(wantedString, buildString)
    }
}
