package klib.functions

import java.io.Closeable

/**
 *  .Net like function that proxies Kotlin's .use
 *
 *  @param receiver The Closable input
 *  @param block The function that uses receiver
 *  @return Some data from block
 *
 * @since 4.0.0
 * @author Thomas Obernosterer
 */
inline fun <T : Closeable?, R> using(receiver: T, block: (T) -> R): R {
    return receiver.use(block)
}
