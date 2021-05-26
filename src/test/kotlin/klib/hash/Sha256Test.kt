/*
 * This file belongs to the source code of: kLib
 *
 * Copyright© 2015-2021 Thomas Obernosterer, ATVG-Studios
 * Copyright© 2019-2021 all kLib Contributors
 *
 * This Source Code Form is subject to the terms of the Mozilla Public License, v. 2.0.
 * If a copy of the MPL was not distributed with this file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package klib.hash

import org.junit.Test
import java.util.Locale
import kotlin.test.assertEquals

class Sha256Test {
    private val hashedValue = "43541CC5E3E1F5BF3918DD77AACDD5AB94CCCDA706EF2656674569CE02CE6061"
    private val unhashedValue = "This is a hashing test"

    @Test
    fun `SHA256 from String`() {
        val sha = Sha256.hash(unhashedValue).hex

        assertEquals(hashedValue, sha.uppercase(Locale.getDefault()))
    }

    @Test
    fun `SHA256 from ByteArray`() {
        val sha = Sha256.hash(unhashedValue.toByteArray()).hex

        assertEquals(hashedValue, sha.uppercase(Locale.getDefault()))
    }
}
