package com.atvgstudios.klib.extensions

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