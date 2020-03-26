package devtests

import klib.extensions.binSearch
import kotlin.random.Random
import kotlin.random.nextInt
import kotlin.system.measureTimeMillis

var kotlinTotalTime = 0L
var kLibTotalTime = 0L

fun main() {
    println(" Starting 'Kotlin STD vs kLib' Speed Test ")
    println("------------------------------------------")

    binSearchArray(Random.nextInt(0 until 50))
    binSearchList(Random.nextInt(0 until 26))

    println("------------------------------------------")
    println(" Kotlin time: $kotlinTotalTime ms")
    println(" kLib time: $kLibTotalTime ms")
    println("------------------------------------------")
    println(" kLib saves ${kotlinTotalTime - kLibTotalTime} ms")
}

fun binSearchList(find: Int) {
    val sortedInput = listOf("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z")
    println("  Running with ${sortedInput.size} Items")

    val searchValue = sortedInput[find]

    val kLib = measureTimeMillis {
        sortedInput.binSearch(searchValue)
    }

    kLibTotalTime += kLib

    val kotlin = measureTimeMillis {
        sortedInput.binarySearch(searchValue)
    }

    kotlinTotalTime += kotlin
}

fun binSearchArray(find: Int) {
    val sortedInput = intArrayOf(1, 4, 5, 6, 8, 11, 12, 14, 16, 19, 20, 22, 23, 29, 31, 32, 33, 34, 35, 36, 38, 39, 42, 44, 52, 59, 60, 61, 62, 66, 67, 69, 70, 72, 73, 74, 75, 76, 77, 78, 79, 80, 84, 85, 86, 88, 89, 91, 93, 96)
    println("  Running with ${sortedInput.size} Items")

    val searchValue = sortedInput[find]

    val kLib = measureTimeMillis {
        sortedInput.binSearch(searchValue)
    }

    kLibTotalTime += kLib

    val kotlin = measureTimeMillis {
        sortedInput.binarySearch(searchValue)
    }

    kotlinTotalTime += kotlin
}
