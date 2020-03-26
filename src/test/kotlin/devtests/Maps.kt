package devtests

import klib.extensions.fullMerge
import klib.extensions.mergeArrays
import klib.extensions.smartMerge

fun main() {
    mergeArrays()
    fullMerge()
    smartMerge()
    smartMerge2()
}

fun mergeArrays() {
    val listA = mutableMapOf("a" to "b")
    val arrayA = arrayOf("c", "e", "g")
    val arrayB = arrayOf("d", "f", "h")

    listA.mergeArrays(arrayA, arrayB)
    println(listA)
}

fun fullMerge() {
    val listA: MutableMap<String, String> = mutableMapOf(
        "a" to "b",
        "c" to "d"
    )
    val listB: MutableMap<String, String> = mutableMapOf(
        "a" to "d",
        "e" to "f",
        "g" to "h"
    )

    listA.fullMerge(listB)
    println(listA)
}

fun smartMerge() {
    val listA: MutableMap<String, String> = mutableMapOf(
        "a" to "b",
        "c" to "d"
    )
    val listB: MutableMap<String, String> = mutableMapOf(
        "a" to "d",
        "e" to "f",
        "g" to "h"
    )

    listA.smartMerge(listB)
    println(listA)
}

fun smartMerge2() {
    val listA: MutableMap<String, String> = mutableMapOf(
        "a" to "b",
        "c" to "d"
    )
    val listB: MutableMap<String, Any> = mutableMapOf(
        "a" to "d",
        "e" to "f",
        "g" to "h"
    )

    listA.smartMerge(listB) { it as String }
    println(listA)
}
