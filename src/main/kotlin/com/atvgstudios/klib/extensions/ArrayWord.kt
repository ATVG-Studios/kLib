package com.atvgstudios.klib.extensions

import com.atvgstudios.klib.types.word.Word

/**
 * Turn Word array into Bytes
 *
 * @since 0.1.0
 * @author Thomas Obernosterer
 */
fun Array<Word>.getBytes() = this.map { it.toByteArray() }.reduce { acc, bytes -> acc.plus(bytes) }