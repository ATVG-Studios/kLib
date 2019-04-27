package com.atvgstudios.klib.extensions

/**
 * Type Check and Type Cast made easy
 *
 * @param block Code to execute when Any is T; With Any as T as argument
 *
 * @since 0.1.4
 * @author Thomas Obernosterer
 */
inline fun <reified T> Any.ofType(block: (T) -> Unit) {
    if (this is T) {
        block(this as T)
    }
}