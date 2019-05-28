package klib.functions

/**
 * Print a list of arguments
 *
 * @param messages A list of aguments
 *
 * @since 1.2.0
 * @author Thomas Obernosterer
 */
fun println(vararg messages: Any?) {
    messages.forEach {
        kotlin.io.println(it)
    }
}