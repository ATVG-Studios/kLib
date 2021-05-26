/*
 * This file belongs to the source code of: kLib
 *
 * Copyright© 2015-2021 Thomas Obernosterer, ATVG-Studios
 * Copyright© 2019-2021 all kLib Contributors
 *
 * This Source Code Form is subject to the terms of the Mozilla Public License, v. 2.0.
 * If a copy of the MPL was not distributed with this file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package klib

import klib.exceptions.InvalidTypeException
import org.junit.Test
import kotlin.test.assertFailsWith
import kotlin.test.assertTrue

class SemVerTest {
    @Test
    fun `SemVer is able to parse a valid Version string`() {
        val sv = SemVer.parse("1.3.4-rc+b100")
        assertTrue {
            sv.major == 1 && sv.minor == 3 && sv.patch == 4 && sv.preRelease == "rc" && sv.buildMetadata == "b100"
        }
    }

    @Test
    fun `SemVer throws a InvalidTypeException when trying to parse an invalid Version string`() {
        assertFailsWith<InvalidTypeException> {
            SemVer.parse("1.3.4_-rc+b100")
        }
    }
}
