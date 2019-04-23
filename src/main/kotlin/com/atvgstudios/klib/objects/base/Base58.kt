package com.atvgstudios.klib.objects.base

import java.math.BigInteger

object Base58 {
    private const val ALPHABET = "123456789ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnopqrstuvwxyz"
    private val big0 = BigInteger.ZERO
    private val big58 = BigInteger.valueOf(58L)

    fun convert(hash: String, base: Int = 16): String {
        var x = if (base == 16 && hash.take(2) == "0x") BigInteger(hash.drop(2), 16)
        else BigInteger(hash, base)
        val sb = StringBuilder()
        while (x > big0) {
            val r = (x % big58).toInt()
            sb.append(ALPHABET[r])
            x /= big58
        }
        return sb.toString().reversed()
    }
}
