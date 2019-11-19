package devtests

import klib.extensions.toSnakeCase

fun main() {
    val normal = "This is a Test"

    val snakeCased = normal.toSnakeCase()

    println(normal)
    println(snakeCased)
}