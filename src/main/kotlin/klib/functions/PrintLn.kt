package klib.functions

/**
 * Print a list of arguments
 *
 * @param messages A list of aguments
 *
 * @since <NEXT_VERSION>
 * @author Thomas Obernosterer
 */
fun println(vararg messages: Any?) {
    messages.forEach { println(it) }
}