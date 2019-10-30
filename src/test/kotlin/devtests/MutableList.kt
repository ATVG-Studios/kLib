package devtests

import klib.extensions.binSearch

fun main() {
    val list = mutableListOf(1,4,7,9,11,66,99)

    println(list.binSearch(7))
}