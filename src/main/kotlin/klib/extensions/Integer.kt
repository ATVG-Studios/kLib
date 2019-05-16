package klib.extensions

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

/**
 * Tenth of Int
 *
 * @return Tenth of Int
 *
 * @since 1.0.0
 * @author Thomas Obernosterer
 */
val Int.tenth get() = this / 10

/**
 * Fourth of Int
 *
 * @return Fourth of Int
 *
 * @since 1.0.0
 * @author Thomas Obernosterer
 */
val Int.fourth get() = this / 4

/**
 * Quarter of Int
 *
 * @return Quarter of Int
 *
 * @see fourth
 *
 * @since 1.0.0
 * @author Thomas Obernosterer
 */
val Int.quarter get() = fourth

/**
 * Tenth of Int
 *
 * @return Tenth of Int
 *
 * @since 1.0.0
 * @author Thomas Obernosterer
 */
val Int.third get() = this / 3

/**
 * Half of Int
 *
 * @return Half of Int
 *
 * @since 1.0.0
 * @author Thomas Obernosterer
 */
val Int.half get() = this / 2

/**
 * Absolute value of Int
 *
 * @return Absolute value of Int
 *
 * @since 1.1.0
 * @author Thomas Obernosterer
 */
val Int.abs get() = Math.abs(this)

/**
 * Check if the Int is 1
 *
 * @return True if 1
 *
 * @since 1.1.0
 * @author Thomas Obernosterer
 */
val Int.isTrue get() = this == 1

/**
 * Check if the Int is 0
 *
 * @return True if 0
 *
 * @since 1.1.0
 * @author Thomas Obernosterer
 */
val Int.isFalse get() = this == 0