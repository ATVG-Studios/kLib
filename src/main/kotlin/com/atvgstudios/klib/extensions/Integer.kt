package com.atvgstudios.klib.extensions

/**
 * Create char n times where n is the integer
 *
 * @param char String to repeat Int times
 * @return char repeated Int times
 *
 * @since 0.1.2
 * @author Thomas Obernosterer
 */
infix fun Int.timesAs(char: String): String = char.repeat(this)

/**
 * Calculate Int to the power of n
 *
 * @param n The exponent
 * @return Int to the power of n
 *
 * @since 0.1.3
 * @author Thomas Obernosterer
 */
infix fun Int.power(n: Int): Int {
    var tmpInt = this

    if (n == 0)
        return 1

    for (i in 1 until n)
        tmpInt *= this

    return tmpInt
}

/**
 * Get as Hex
 *
 * @param upperCase Makes the Hex uppercase if True (Default is false)
 * @return The hex value of Int
 *
 * @since 0.1.4
 * @author Thomas Obernosterer
 */
fun Int.toHex(upperCase: Boolean = false): String {
    return if (upperCase) this.toString(16).toUpperCase() else this.toString(16)
}