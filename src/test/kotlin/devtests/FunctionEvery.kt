package devtests

import klib.extensions.every

fun main() {
    {
        println("hi")
    } every 10_000
}