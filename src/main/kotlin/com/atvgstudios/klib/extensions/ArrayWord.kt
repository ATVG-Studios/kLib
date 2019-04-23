package com.atvgstudios.klib.extensions

import com.atvgstudios.klib.types.word.Word

fun Array<Word>.getBytes() = this.map { it.toByteArray() }.reduce { acc, bytes -> acc.plus(bytes) }