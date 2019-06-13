package devtests

import klib.extensions.binSearch
import kotlin.system.measureTimeMillis

fun main() {
    binSearch(15)
    binSearch(34)
    binSearch(48)
    binSearch(24)
    binSearch(2)
    binSearch(20)
}

fun binSearch(find: Int) {
    val sortedInput = intArrayOf(1, 4, 5, 6, 8, 11, 12, 14, 16, 19, 20, 22, 23, 29, 31, 32, 33, 34, 35, 36, 38, 39, 42, 44, 52, 59, 60, 61, 62, 66, 67, 69, 70, 72, 73, 74, 75, 76, 77, 78, 79, 80, 84, 85, 86, 88, 89, 91, 93, 96)

    val searchValue = sortedInput[find]

    println("kLib: "+measureTimeMillis {
        println(sortedInput.binSearch(searchValue))
    }.toString()+" ms")

    println("Kotlin: "+measureTimeMillis {
        println(sortedInput.binarySearch(searchValue))
    }.toString()+" ms")
}