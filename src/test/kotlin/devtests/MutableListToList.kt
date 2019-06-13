package devtests

import klib.extensions.toListWithConvert

fun main() {
    val listA = mutableListOf("1","3","8")

    val listB = listA.toListWithConvert { it.toIntOrNull() ?: 0 }
    println(listB)
}