package devtests

import klib.extensions.asIntOr
import klib.extensions.asLongOr

fun main() {
    println("10009273".toIntOrNull() ?: 2)
    println("10009273" asIntOr 2)

    println("1000z!9273".toIntOrNull() ?: 2)
    println("1000z!9273" asIntOr 2)

    println("10009273".toLongOrNull() ?: 2)
    println("10009273" asLongOr 2)

    println("1000z!9273".toLongOrNull() ?: 2)
    println("1000z!9273" asLongOr 2L)
}
