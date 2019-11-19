package klib.functions

/**
 * Read Int from STDIN
 *
 * @param default The default when input was null (Default: -1)
 * @return User input as Integer or default
 *
 * @since 4.0.0
 * @author Thomas Obernosterer
 */
fun readInt(default: String = "-1"): Int {
    val input = readLine() ?: default
    return Integer.parseInt(input)
}

/**
 * Read Long from STDIN
 *
 * @param default The default when input was null (Default: -1)
 * @return User input as Long or default
 *
 * @since 4.0.0
 * @author Thomas Obernosterer
 */
fun readLong(default: String = "-1"): Long {
    val input = readLine() ?: default
    return Integer.parseUnsignedInt(input).toLong()
}