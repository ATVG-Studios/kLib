package com.atvgstudios.klib.functions

fun exceptionHandled(block: () -> Boolean): Boolean {
    return try {
        block()
    } catch (e: Exception) {
        e.printStackTrace()
        false
    }
}
