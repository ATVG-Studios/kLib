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
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class SemVerTest {
    @Test
    fun `Check isInitialDevelopment`() {
        val sv1 = SemVer()
        val sv2 = SemVer(major = 0)

        assertFalse(sv1.isInitialDevelopment)
        assertTrue(sv2.isInitialDevelopment)
    }

    @Test
    fun `SemVer is able to parse a valid Version with PreRelease and Meta string`() {
        val sv = SemVer.parse("1.3.4-rc+b100")
        assertTrue {
            sv.major == 1 && sv.minor == 3 && sv.patch == 4 && sv.preRelease == "rc" && sv.buildMetadata == "b100"
        }
    }

    @Test
    fun `SemVer is able to parse a valid Version string`() {
        val sv = SemVer.parse("1.3.4")
        assertTrue {
            sv.major == 1 && sv.minor == 3 && sv.patch == 4
        }
    }

    @Test
    fun `SemVer toString is correct`() {
        val sv1 = SemVer(1, 3, 4)
        assertEquals("1.3.4", sv1.toString())

        val sv2 = SemVer(1, 3, 4, "rc", "b100")
        assertEquals("1.3.4-rc+b100", sv2.toString())

        val sv3 = SemVer(1, 3, 4, "rc.1", "b100")
        assertEquals("1.3.4-rc.1+b100", sv3.toString())
    }

    @Test
    fun `Compare works`() {
        val sv1 = SemVer()
        val sv2 = SemVer(major = 2)

        val sv10 = SemVer(minor = 1)
        val sv11 = SemVer(patch = 1)
        val sv12 = SemVer(minor = 1, patch = 1)
        val sv16 = SemVer(minor = 1, patch = 2)

        val sv13 = SemVer(minor = 2)
        val sv14 = SemVer(patch = 2)
        val sv15 = SemVer(minor = 2, patch = 1)
        val sv17 = SemVer(minor = 2, patch = 2)

        val sv20 = SemVer(preRelease = "rc.1")
        val sv21 = SemVer(preRelease = "rc.2")
        val sv22 = SemVer(major = 2, preRelease = "rc.1")
        val sv23 = SemVer(major = 2, preRelease = "rc.2")
        val sv24 = SemVer(preRelease = "1")
        val sv25 = SemVer(preRelease = "2")
        val sv26 = SemVer(preRelease = "a")
        val sv27 = SemVer(preRelease = "b")

        // 2.0.0 > 1.0.0
        assertEquals(1, sv2.compareTo(sv1))
        assertEquals(-1, sv1.compareTo(sv2))

        // 1.2.0 > 1.1.0
        assertEquals(1, sv13.compareTo(sv10))
        assertEquals(-1, sv10.compareTo(sv13))

        // 1.0.2 > 1.0.1
        assertEquals(1, sv14.compareTo(sv11))
        assertEquals(-1, sv11.compareTo(sv14))

        // 1.2.1 > 1.1.1
        assertEquals(1, sv15.compareTo(sv12))
        assertEquals(-1, sv12.compareTo(sv15))

        // 1.1.2 > 1.1.1
        assertEquals(1, sv16.compareTo(sv12))
        assertEquals(-1, sv12.compareTo(sv16))

        // 1.2.2 > 1.2.1
        assertEquals(1, sv17.compareTo(sv15))
        assertEquals(-1, sv15.compareTo(sv17))

        // 1.0.0 > 1.0.0-rc.1
        assertEquals(1, sv1.compareTo(sv20))
        assertEquals(-1, sv20.compareTo(sv1))

        // 1.0.0-rc.1 == 1.0.0-rc.1
        assertEquals(0, sv20.compareTo(sv20))

        // 1.0.0-rc.2 > 1.0.0-rc.1
        assertEquals(1, sv21.compareTo(sv20))
        assertEquals(-1, sv20.compareTo(sv21))

        // 1.0.0-2 > 1.0.0-1
        assertEquals(1, sv25.compareTo(sv24))
        assertEquals(-1, sv24.compareTo(sv25))

        // 1.0.0-b > 1.0.0-a
        assertEquals(1, sv27.compareTo(sv26))
        assertEquals(-1, sv26.compareTo(sv27))

        // 1.0.0-a == 1.0.0-a
        assertEquals(0, sv26.compareTo(sv26))

        // 2.0.0-rc.2 > 2.0.0-rc.1
        assertEquals(1, sv23.compareTo(sv22))
        assertEquals(-1, sv22.compareTo(sv23))

        // 2.0.0-rc.1 > 1.0.0-rc.1
        assertEquals(1, sv22.compareTo(sv20))

        // 2.0.0-rc.1 > 1.0.0-rc.2
        assertEquals(1, sv22.compareTo(sv21))

        // 2.0.0-rc.2 > 1.0.0-rc.1
        assertEquals(1, sv23.compareTo(sv20))

        // 2.0.0-rc.2 > 1.0.0-rc.2
        assertEquals(1, sv23.compareTo(sv21))

        // 2.0.0-rc.2 > 2.0.0-rc.1
        assertEquals(1, sv23.compareTo(sv22))
    }

    @Test
    fun `SemVer not allowing negative values`() {
        assertFailsWith(IllegalArgumentException::class) {
            SemVer(major = -1)
        }

        assertFailsWith(IllegalArgumentException::class) {
            SemVer(minor = -1)
        }

        assertFailsWith(IllegalArgumentException::class) {
            SemVer(patch = -1)
        }

        assertFailsWith(IllegalArgumentException::class) {
            SemVer(preRelease = "\uD83D\uDC08")
        }

        assertFailsWith(IllegalArgumentException::class) {
            SemVer(buildMetadata = "\uD83D\uDC08")
        }
    }

    @Test
    fun `SemVer throws a InvalidTypeException when trying to parse an invalid Version string`() {
        assertFailsWith<InvalidTypeException> {
            SemVer.parse("1.3.4_-rc+b100")
        }
    }
}
