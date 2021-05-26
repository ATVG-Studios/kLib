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

import klib.extensions.inBoundsOf

/**
 * HashResults gets return from the Hasher with the Hex Hash and the used Algorithm
 *
 * @param hex
 * @param algo
 *
 * @since 0.1.2
 * @author Thomas Obernosterer
 */
class HashResult(val hex: String, val algo: String) {

    /**
     * Get the first 4 bytes (8 characters) from the Hash
     *
     * @since 2.0.0
     * @author Thomas Obernosterer
     */
    val checksum = takeBytes(4)

    /**
     * Get a set amount of Bytes from the hash
     *
     * @param amount Byte count
     * @return Bytes from 0 to amount*2
     *
     * @since 2.0.0
     * @author Thomas Obernosterer
     */
    fun takeBytes(amount: Int): String {
        if (amount * 2 inBoundsOf hex) {
            return hex.substring(0, amount * 2)
        } else {
            throw IndexOutOfBoundsException()
        }
    }

    /**
     * Returns Hex Value
     *
     * @return
     *
     * @since 0.1.2
     * @author Thomas Obernosterer
     */
    override fun toString(): String = hex
}
