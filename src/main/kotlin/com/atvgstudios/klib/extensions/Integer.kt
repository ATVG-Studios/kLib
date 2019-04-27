package com.atvgstudios.klib.extensions

/**
 * Create char n times where n is the integer
 *
 * @param char
 * @return
 *
 * @since 0.1.2
 * @author Thomas Obernosterer
 */
infix fun Int.timesAs(char: String): String = char.repeat(this)

/**
 * Calculate x to the power of n
 *
 * @param n
 * @return
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