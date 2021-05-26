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

/**
 * Byte-Byte multiply
 *
 * @param b
 * @return
 *
 * @since 0.1.0
 * @author Thomas Obernosterer
 */
infix fun Byte.mul(b: Byte): Byte {
    var tmpA = this.toInt()
    var tmpB = b.toInt()

    var p = 0
    var hiBitSet: Int

    for (i in 0 until 8) {
        if ((tmpB and 0x01) == 1) {
            p = (p xor tmpA) and 0xff
        }

        hiBitSet = tmpA and 0x80
        tmpA = tmpA shl 1

        if (hiBitSet == 0x80) {
            tmpA = tmpA xor 0x1b
        }

        tmpB = (tmpB shr 1) and 0x7f
    }

    return p.toByte()
}

/**
 * Convert Byte into a Hex String
 *
 * @since 3.1.0
 * @author Thomas Obernosterer
 */
fun Byte.toHex(): String {
    return this.toString(16)
}
