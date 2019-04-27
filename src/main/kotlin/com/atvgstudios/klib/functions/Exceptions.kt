package com.atvgstudios.klib.functions

/**
 * Run code with Boolean return status inside Try-Catch
 *
 * @param block
 * @return
 *
 * @since 0.1.0
 * @author Thomas Obernosterer
 */
fun exceptionHandled(block: () -> Boolean): Boolean {
    return try {
        block()
    } catch (e: Exception) {
        e.printStackTrace()
        false
    }
}
