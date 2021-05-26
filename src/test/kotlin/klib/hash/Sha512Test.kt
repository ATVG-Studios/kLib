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

class Sha512Test {
    private val hashedValue = "FC5F5569C2C3D330E12C0FCEAC250F312BEC416E36EE7D8604D574C489EAEFA3EFF898253273CE92E3CB8E0C3F4B4FE94D24D90DA5E77A3CF1CFB41542D00315"
    private val unhashedValue = "This is a hashing test"

    @Test
    fun `SHA512 from String`() {
        val sha = Sha512.hash(unhashedValue).hex

        assertEquals(hashedValue, sha.uppercase(Locale.getDefault()))
    }

    @Test
    fun `SHA512 from ByteArray`() {
        val sha = Sha512.hash(unhashedValue.toByteArray()).hex

        assertEquals(hashedValue, sha.uppercase(Locale.getDefault()))
    }
}
