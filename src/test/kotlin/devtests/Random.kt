package devtests

import klib.functions.runRandom

fun main() {
    for(i in 0 until 100) {
        runRandom {
            println("Hey, $i worked!")
        }
    }
}