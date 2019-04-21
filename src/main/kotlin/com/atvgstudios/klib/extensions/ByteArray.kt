package com.atvgstudios.klib.extensions

import com.atvgstudios.klib.annotations.Author
import kotlin.experimental.xor

@Author(name = "Thomas Obernosterer", email = "thomas.obernosterer@atvg-studios.com", company = "ATVG-Studios", homepage = "https://atvg-studios.com")
fun ByteArray.asHexString() = this.map { String.format("%02x ", it) }.reduce { acc, s -> acc + s }

@Author(name = "Thomas Obernosterer", email = "thomas.obernosterer@atvg-studios.com", company = "ATVG-Studios", homepage = "https://atvg-studios.com")
infix fun ByteArray.xor(byteArray: ByteArray): ByteArray {
    val result = ByteArray(this.size)

    for (i in this.indices) {
        result[i] = this[i] xor byteArray[i]
    }

    return result
}