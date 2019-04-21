package com.atvgstudios.klib.functions

import com.atvgstudios.klib.annotations.*

@Author(name = "Thomas Obernosterer", email = "thomas.obernosterer@atvg-studios.com", company = "ATVG-Studios", homepage = "https://atvg-studios.com")
fun equal(a: Any, b: Any): Boolean {
    if (a is String && b is String) {
        if (a.equals(b, true))
            return true
    }

    if (a == b)
        return true

    return false
}
