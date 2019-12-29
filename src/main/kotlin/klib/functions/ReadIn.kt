package klib.functions

import klib.extensions.asIntOr
import klib.extensions.asLongOr

/**
 * Read Int from STDIN
 *
 * @param default The default when input was null (Default: -1)
 * @return User input as Integer or default
 *
 * @since 4.0.0
 * @author Thomas Obernosterer
 */
fun readInt(default: Int = -1): Int {
    return readLine() asIntOr default
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
fun readLong(default: Long = -1L): Long {
    return readLine() asLongOr default
}
