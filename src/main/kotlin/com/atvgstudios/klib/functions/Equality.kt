package com.atvgstudios.klib.functions

/**
 * Check if a and b are equal
 *
 * @param a
 * @param b
 * @return
 *
 * @since 0.1.0
 * @author Thomas Obernosterer
 */
fun equal(a: Any, b: Any): Boolean {
    if (a is String && b is String) {
        return a.equals(b, true)
    }

    return a == b
}
