/*
 * This file belongs to the source code of: kLib
 *
 * Copyright© 2015-2021 Thomas Obernosterer, ATVG-Studios
 * Copyright© 2019-2021 all kLib Contributors
 *
 * This Source Code Form is subject to the terms of the Mozilla Public License, v. 2.0.
 * If a copy of the MPL was not distributed with this file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package klib.encoding.base

import java.math.BigInteger

/**
 * Custom Extended Base58 Implementation
 *
 * @source Google BitcoinJ-Minimal (The code as been Modified)
 *
 * @since 0.1.5
 * @author Thomas Obernosterer
 */
object Base58e {
    private const val ALPHABET = "123456789ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnopqrstuvwxyz"
    private val BASE = BigInteger.valueOf(58)

    /**
     * Encode Base58
     *
     * @param input The Input to encode
     * @return The encoded Input
     *
     * @since 0.1.5
     * @author Thomas Obernosterer
     */
    fun encode(input: String): String = encode(input.toByteArray())

    /**
     * Encode Base58
     *
     * @param input The Input to encode
     * @return The encoded Input
     *
     * @since 0.1.5
     * @author Thomas Obernosterer
     */
    fun encode(input: ByteArray): String {
        var bi = BigInteger(1, input)
        val s = StringBuffer()
        while (bi.compareTo(BASE) >= 0) {
            val mod = bi.mod(BASE)
            s.insert(0, ALPHABET[mod.toInt()])
            bi = bi.subtract(mod).divide(BASE)
        }
        s.insert(0, ALPHABET[bi.toInt()])
        for (anInput in input) {
            if (anInput.toInt() == 0)
                s.insert(0, ALPHABET[0])
            else
                break
        }
        return s.toString()
    }

    /**
     * Decode Base58
     *
     * @param input The Input to decode
     * @return The decoded Input
     *
     * @since 0.1.5
     * @author Thomas Obernosterer
     */
    fun decode(input: String): ByteArray {
        val bytes = decodeToBigInteger(input).toByteArray()
        val stripSignByte = bytes.size > 1 && bytes[0].toInt() == 0 && bytes[1] < 0
        var leadingZeros = 0
        var i = 0
        while (input[i] == ALPHABET[0]) {
            leadingZeros++
            i++
        }
        val tmp = ByteArray(bytes.size - (if (stripSignByte) 1 else 0) + leadingZeros)
        System.arraycopy(bytes, if (stripSignByte) 1 else 0, tmp, leadingZeros, tmp.size - leadingZeros)
        return tmp
    }

    /**
     * @param input
     * @return
     *
     * @since 0.1.5
     * @author Thomas Obernosterer
     */
    fun decodeToBigInteger(input: String): BigInteger {
        var bi = BigInteger.valueOf(0)
        for (i in input.length - 1 downTo 0) {
            val alphaIndex = ALPHABET.indexOf(input[i])
            if (alphaIndex == -1) {
                throw Exception("Illegal character " + input[i] + " at " + i)
            }
            bi = bi.add(BigInteger.valueOf(alphaIndex.toLong()).multiply(BASE.pow(input.length - 1 - i)))
        }
        return bi
    }
}
