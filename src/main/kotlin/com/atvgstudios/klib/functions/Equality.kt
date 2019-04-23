package com.atvgstudios.klib.functions

fun equal(a: Any, b: Any): Boolean {
    if (a is String && b is String) {
        return a.equals(b, true)
    }

    return a == b
}
