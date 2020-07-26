package klib.extensions

import klib.encoding.base.Base58e
import kotlin.random.Random

/**
 * Generate a random string with only Base58 characters
 *
 * @since 5.1.0
 * @author Thomas Obernosterer
 */
fun Random.string(length: Int): String {
    return Base58e.encode(this.nextBytes(length)).substring(0 until length)
}
