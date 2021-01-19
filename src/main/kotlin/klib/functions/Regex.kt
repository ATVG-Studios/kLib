package klib.functions

/**
 *  Returns a Regex that matches A-Z a-z 0-9
 *
 * @since 5.2.0
 * @author Thomas Obernosterer
 */
fun alphanumericalRegex() = "[^A-Za-z0-9]".toRegex()
