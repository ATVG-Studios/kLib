package devtests

import klib.extensions.or
import klib.extensions.orNullable

fun main() {
    val test: String? = null

    println(test or "not null")
    println(test orNullable null)
}
