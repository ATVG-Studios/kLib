package klib.extensions

/**
 * Calculate Double to the power of n
 *
 * @param n The exponent
 * @return Double to the power of n
 *
 * @since 1.0.0
 * @author Thomas Obernosterer
 */
infix fun Double.power(n: Int): Double {
    var tmpInt = this

    if (n == 0)
        return 1.00

    for (i in 1 until n)
        tmpInt *= this

    return tmpInt
}