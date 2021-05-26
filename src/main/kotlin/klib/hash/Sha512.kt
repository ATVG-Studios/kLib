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

import java.nio.charset.Charset

/**
 * Custom Sha256 Hasher-Interface Implementation
 *
 * @since 4.1.0
 * @author Thomas Obernosterer
 */
object Sha512 : Hasher {
    /**
     * Charset to use
     *
     * @see Charset.defaultCharset()
     *
     * @since 4.1.0
     * @author Thomas Obernosterer
     */
    var defaultCharset: Charset = Charset.defaultCharset()

    /**
     * Hash a byte array in SHA256
     *
     * @param data
     * @return
     *
     * @since 4.1.0
     * @author Thomas Obernosterer
     */
    fun hash(data: ByteArray): HashResult = super.hash(data, "SHA-512")

    /**
     * Hash a string in SHA256 (Use defaultCharset)
     *
     * @param data
     * @return
     * @see defaultCharset
     *
     * @since 4.1.0
     * @author Thomas Obernosterer
     */
    fun hash(data: String): HashResult = super.hash(data.toByteArray(defaultCharset), "SHA-512")
}
