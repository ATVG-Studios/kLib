package devtests

import klib.functions.kstring

fun main() {
    val string = kstring {
        line("Counter")
        line("This will count to 100:")

        for(i in 0 .. 100) {
            + "$i,"
        }
    }
    println(string)
}