package com.atvgstudios.klib.objects.base

import java.math.BigInteger

/**
 * Custom Base58 Implementation
 *
 * @deprecated Since 0.1.5
 * @replaced This was replaced by Base58e
 * @see Base58e
 *
 * @since 0.1.2
 * @author Thomas Obernosterer
 */
@Deprecated("Replaced by Base58e", level = DeprecationLevel.ERROR)
object Base58 {
    private const val ALPHABET = "123456789ABCDEFGHJKLMNPQRSTUVWXYZabcdefghijkmnopqrstuvwxyz"
    private val big0 = BigInteger.ZERO
    private val big58 = BigInteger.valueOf(58L)

    /**
     * Convert a Hash (String) to Base58
     *
     * @param hash
     * @param base
     *
     * @since 0.1.2
     * @author Thomas Obernosterer
     */
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