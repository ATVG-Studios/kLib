package com.atvgstudios.klib.extensions

import com.atvgstudios.klib.annotations.Author
import com.atvgstudios.klib.types.word.Word

@Author(name = "Thomas Obernosterer", email = "thomas.obernosterer@atvg-studios.com", company = "ATVG-Studios", homepage = "https://atvg-studios.com")
fun Array<Word>.getBytes() = this.map { it.toByteArray() }.reduce { acc, bytes -> acc.plus(bytes) }