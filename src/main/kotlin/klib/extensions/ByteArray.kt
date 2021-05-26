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

import klib.hash.Sha1
import klib.hash.Sha256
import klib.hash.Sha512
import kotlin.experimental.xor

/**
 * ByteArray to Hex
 * @since 0.1.0
 * @author Thomas Obernosterer
 */
fun ByteArray.asHexString() = this.map { String.format("%02x ", it) }.reduce { acc, s -> acc + s }

/**
 * xor two byte arrays
 *
 * @param byteArray
 * @return
 *
 * @since 0.1.0
 * @author Thomas Obernosterer
 */
infix fun ByteArray.xor(byteArray: ByteArray): ByteArray {
    val result = ByteArray(this.size)

    for (i in this.indices) {
        result[i] = this[i] xor byteArray[i]
    }

    return result
}

/**
 * Calculates the SHA-256 hash of the array, and then hashes the resulting hash again. This is
 * standard procedure in BitCoin.
 *
 * @return The doubleHash of the ByteArray
 * @source Google BitcoinJ-Minimal
 * @see asSha256
 *
 * @since 0.1.5
 * @author Thomas Obernosterer
 */
fun ByteArray.doubleDigest(): String {
    val first = this.asSha256()
    return first.asSha256()
}

/**
 * SHA256 Hash the byte array
 *
 * @return The Hash of the Array
 *
 * @since 0.1.5
 * @author Thomas Obernosterer
 */
fun ByteArray.asSha256(): String {
    return Sha256.hash(this).hex
}

/**
 * SHA1 Hash the byte array
 *
 * @return The Hash of the Array
 *
 * @since 2.0.0
 * @author Thomas Obernosterer
 */
fun ByteArray.asSha1(): String {
    return Sha1.hash(this).hex
}

/**
 * SHA512 Hash the byte array
 *
 * @return The Hash of the Array
 *
 * @since 4.1.0
 * @author Thomas Obernosterer
 */
fun ByteArray.asSha512(): String {
    return Sha512.hash(this).hex
}
