/*
 * This file belongs to the source code of: kLib
 *
 * Copyright© 2015-2021 Thomas Obernosterer, ATVG-Studios
 * Copyright© 2019-2021 all kLib Contributors
 *
 * This Source Code Form is subject to the terms of the Mozilla Public License, v. 2.0.
 * If a copy of the MPL was not distributed with this file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package klib.encoding

import klib.encoding.base.Base58e
import org.junit.Test
import java.nio.charset.Charset
import kotlin.test.assertEquals

class Base58Test {
    private val encodedString = "bu3A7hSL932y2MenWyPK698z7BtGsrwBZEUwsNkSSd2jVtpmAmYbd4qhA1uUbm9y"
    private val unencodedString = "Hello, this is a test for encoding using Base58"

    @Test
    fun `Encode String`() {
        val newEncoded = Base58e.encode(unencodedString)
        assertEquals(encodedString, newEncoded)
    }

    @Test
    fun `Encode ByteArray`() {
        val newEncoded = Base58e.encode(unencodedString.toByteArray(Charset.defaultCharset()))
        assertEquals(encodedString, newEncoded)
    }

    @Test
    fun `Decode string`() {
        val newDecoded = Base58e.decode(encodedString).toString(Charset.defaultCharset())
        assertEquals(unencodedString, newDecoded)
    }

    @Test
    fun `Encode and Decode string`() {
        val newEncoded = Base58e.encode(unencodedString)
        assertEquals(encodedString, newEncoded)

        val newDecoded = Base58e.decode(newEncoded).toString(Charset.defaultCharset())
        assertEquals(unencodedString, newDecoded)
    }
}
