package devtests

import klib.functions.loadClass
import klib.library.LClass
import klib.library.Library
import java.io.File

/**
 * Source of hello.kt

package hello

class Hello {
    fun hi() {
        println("Hello from Hello class")
    }
}

 * Compile using:
 * kotlinc -d hello.jar hello.kt
 */

fun main() {
    val hello = loadClass {
        file = "/tmp/hello.jar"
        className = "hello.Hello"
    }

    hello("hi")
}