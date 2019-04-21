package com.atvgstudios.klib.functions

import com.atvgstudios.klib.annotations.Author

@Author(name = "Thomas Obernosterer", email = "thomas.obernosterer@atvg-studios.com", company = "ATVG-Studios", homepage = "https://atvg-studios.com")
fun exceptionHandled(block: () -> Boolean): Boolean {
    return try {
        block()
    } catch (e: Exception) {
        e.printStackTrace()
        false
    }
}
